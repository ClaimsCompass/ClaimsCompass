package com.securian.creditcompass.Claim;

import com.securian.creditcompass.Claimant.Claimant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimController {

    private final ClaimRepository claimRepository;

    public ClaimController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }
    @GetMapping("/claims")
    public List<Claim> findClaims() {
        return (List<Claim>) this.claimRepository.findAll();
    }

    @GetMapping("/processedClaims")
    public List<Claim> findProcessedClaims() {return (List<Claim>) this.claimRepository.findAll();}

    @GetMapping("/claims")
    public Claim findLastClaim() {
        Iterable<Claim> allClaims =  this.claimRepository.findAll();
        java.util.Iterator<Claim> it = allClaims.iterator();
        Claim curClaim = new Claim("NULL", "NULL", -1f, new Claimant("NULL", "NULL")); // This will not work at the moment since we're not sure if we
        //want the claimant in claim or claim in claimant (more to discuss)

        while (it.hasNext()) {
            curClaim = it.next();
        }
        return curClaim;
    }

    @PostMapping("/claims")
    public Claim addOneClaim(@RequestBody Claim claim) {
        return this.claimRepository.save(claim);
    }
}
