package com.securian.creditcompass.useCases.allocation;
import com.securian.creditcompass.dataAccess.ClaimRepository;
import com.securian.creditcompass.dataAccess.ExaminerRepository;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Facade Implementation
@Service
public class AllocationInteractor {

    @Autowired
    private ExaminerRepository examinerRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public AllocationInteractor(ExaminerRepository examinerRepository, ClaimRepository claimRepository){
        /*
        @param examinerRepository: the repository used to access the examiners
        @param claimRepository: the repository used to access the claims
         */
        this.examinerRepository = examinerRepository;
        this.claimRepository = claimRepository;
    }

    public void assignClaim(Claim nextClaim, List <ClaimsExaminer> claimsExaminers ) {
        /*
        @param nextClaim: the claim to be assigned
        @param claimsExaminers: the list of examiners to assign the claim to
        */
        // assign the claim to this examiner who has the lowest score
        // set examiner column of this claim to the examiner with the lowest score
        if (nextClaim.getExaminer() != null) {
            return;
        }
        ClaimsExaminer minExaminer = getExaminerWithMinScore(claimsExaminers);
        nextClaim.setClaimExaminer(minExaminer);
        claimRepository.save(nextClaim);
    }

    public void assignAllClaims() {
        /*
        Assign all unassigned claims to examiners
        */
        List<Claim> claims = claimRepository.findAll();
        List <ClaimsExaminer> claimsExaminers = examinerRepository.findAll();
        for (Claim claim : claims) {
            assignClaim(claim, claimsExaminers);
        }
    }

    public int getExaminerScore(ClaimsExaminer currExaminer) {
        /*
        @param currExaminer: the examiner to calculate the score of
        @return: the score of the examiner
        */
        // return the total score of all claims assigned to this examiner
        String examinerUsername = currExaminer.getUsername();
        List<Claim> allClaims = claimRepository.findClaimsByExaminer(examinerUsername);
        ArrayList<Claim> filteredClaims = new ArrayList<Claim>();

        for (int i = 0; i < allClaims.size(); i++) {
            if (!allClaims.get(i).isProcessed()) {
                filteredClaims.add(allClaims.get(i));
            }
        }
        int totalScore = 0;
        for (Claim claim : filteredClaims) {
            totalScore += claim.getUrgencyScore() + claim.getComplexityScore();
        }
        return totalScore;
    }

    // From a list of claims examiners, return the one with the minimum examiner score
    public ClaimsExaminer getExaminerWithMinScore(List<ClaimsExaminer> examiners) {
        /*
        @param examiners: the list of examiners to find the one with the minimum score
        @return: the examiner with the minimum score
        */
        ClaimsExaminer minExaminer = examiners.get(0);
        for (ClaimsExaminer examiner : examiners) {
            int curExaminerScore = getExaminerScore(examiner);
            int minExaminerScore = getExaminerScore(minExaminer);
            if (curExaminerScore < minExaminerScore) {
                minExaminer = examiner;
            }
        }
        return minExaminer;
    }
}
