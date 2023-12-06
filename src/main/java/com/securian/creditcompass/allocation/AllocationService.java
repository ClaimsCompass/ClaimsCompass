package com.securian.creditcompass.allocation;
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
public class AllocationService {

    @Autowired
    private ExaminerRepository examinerRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public AllocationService(ExaminerRepository examinerRepository, ClaimRepository claimRepository){
        this.examinerRepository = examinerRepository;
        this.claimRepository = claimRepository;
    }

    public void assignClaim(Claim nextClaim, List <ClaimsExaminer> claimsExaminers ) {
        // assign the claim to this examiner who has the lowest score
        // set examiner column of this claim to the examiner with the lowest score
        ClaimsExaminer minExaminer = getExaminerWithMinScore(claimsExaminers);
        nextClaim.setClaimExaminer(minExaminer);
        claimRepository.save(nextClaim);
    }

    public void assignAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        List <ClaimsExaminer> claimsExaminers = examinerRepository.findAll();
        for (Claim claim : claims) {
            assignClaim(claim, claimsExaminers);
        }
    }

    public int getExaminerScore(ClaimsExaminer currExaminer) {
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
        System.out.println("Size: " + examiners.size());
        for (ClaimsExaminer examiner : examiners) {
            System.out.println(examiner.getUsername());
        }
        ClaimsExaminer minExaminer = examiners.get(0);
        for (ClaimsExaminer examiner : examiners) {
            Integer curExaminerScore = getExaminerScore(examiner);
            Integer minExaminerScore = getExaminerScore(minExaminer);

            System.out.println(examiner.getUsername() + " " + curExaminerScore);
            System.out.println(minExaminer.getUsername() + " " + minExaminerScore);
            if (curExaminerScore < minExaminerScore) {
                minExaminer = examiner;
            }
        }
        return minExaminer;
    }
}
