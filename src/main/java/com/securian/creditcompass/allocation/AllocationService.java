package com.securian.creditcompass.allocation;
import com.securian.creditcompass.DataAccess.ClaimRepository;
import com.securian.creditcompass.DataAccess.ExaminerRepository;
import com.securian.creditcompass.entities.Claim;
import com.securian.creditcompass.entities.ClaimsExaminer;
import org.apache.catalina.util.ErrorPageSupport;

import java.util.List;

// Facade Implementation
public class AllocationService {

    private final ExaminerRepository examinerRepository;
    private final ClaimRepository claimRepository;

    public AllocationService(ExaminerRepository examinerRepository, ClaimRepository claimRepository){
        this.examinerRepository = examinerRepository;
        this.claimRepository = claimRepository;
    }

    public void assignClaim(Claim nextClaim, List <ClaimsExaminer> claimsExaminers ) {
        // assign the claim to this examiner with the lowest score
        ClaimsExaminer minExaminer = getExaminerWithMinScore(claimsExaminers);
        nextClaim.setClaimExaminer(minExaminer);
    }

    public void assignAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        List <ClaimsExaminer> claimsExaminers = examinerRepository.findAll();
        for (Claim claim : claims) {
            assignClaim(claim, claimsExaminers);
        }
    }

    public int getExaminerScore() {
        // return the total score of all claims assigned to this examiner
        List<Claim> allClaims = claimRepository.findAll();
        if (allClaims == null) {
            return 0;
        }
        else {
            int totalScore = 0;
            for (Claim claim : allClaims) {
                totalScore += (int) claim.getTotalScore();
            }
            return totalScore;
        }
    }

    // From a list of claims examiners, return the one with the minimum examiner score
    public ClaimsExaminer getExaminerWithMinScore(List<ClaimsExaminer> examiners) {
        ClaimsExaminer minExaminer = examiners.get(0);
        for (ClaimsExaminer examiner : examiners) {
            if (examiner.getExaminerScore() < minExaminer.getExaminerScore()) {
                minExaminer = examiner;
            }
        }
        return minExaminer;
    }
}
