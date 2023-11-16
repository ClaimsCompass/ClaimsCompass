import java.util.ArrayList;
import java.util.List;

public class RenderDashboardService {

    public List<List<Object>> findAll(List<Claim> claimList) {
        List<List<Object>> allClaimsAttributes = new ArrayList<>();

        for (Claim claim : claimList) {
            List<Object> claimAttributes = new ArrayList<>();
            // Assuming Claim class has attributes like claimId, amount, date, etc.
            claimAttributes.add(claim.getId());
            claimAttributes.add(claim.getClaimAmt());
            claimAttributes.add(claim.getCreationDate());
            claimAttributes.add(claim.getClaimType());
            urgency = claim.getUrgencyScore();
            if (urgency >= 6) {
                claimAttributes.add("High");
            }
            else if (urgency >= 3) {
                claimAttributes.add("Medium");
            }
            else {
                claimAttributes.add("Low");
            }
            complexity = claim.getComplexityScore();
            // Complexity
            if (complexity >= 7) {
                claimAttributes.add("High");
            }
            else if (complexity >= 4) {
                claimAttributes.add("Medium");
            }
            else {
                claimAttributes.add("Low");
            }
            allClaimsAttributes.add(claimAttributes);
        }

        return allClaimsAttributes;
    }
}
