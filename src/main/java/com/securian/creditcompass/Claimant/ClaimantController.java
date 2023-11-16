package com.securian.creditcompass.Claimant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimantController {

    private final ClaimantRepository claimantRepository;

    public ClaimantController(ClaimantRepository claimantRepository) {
        this.claimantRepository = claimantRepository;
    }
    @GetMapping("/claimants")
    public Iterable<Claimant> findClaims() {
        return this.claimantRepository.findAll();
    }

    @GetMapping("/claimant")
    public Claimant findLastClaimant() {
        Iterable<Claimant> allClaimants =  this.claimantRepository.findAll();
        java.util.Iterator<Claimant> it = allClaimants.iterator();
        Claimant curClaimant = new Claimant("NULL", "NULL");

        while (it.hasNext()) {
            curClaimant = it.next();
        }
        return curClaimant;
    }

    @PostMapping("/claimants")
    public Claimant addOneClaimant(@RequestBody Claimant claimant) {
        return this.claimantRepository.save(claimant);
    }
}
