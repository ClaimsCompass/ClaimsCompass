package com.securian.creditcompass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClaimController {

    private final ClaimRepository claimRepository;

    public ClaimController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }
    @GetMapping("/claims")
    public Iterable<Claim> findClaims() {
        return this.claimRepository.findAll();
    }

    @GetMapping("/claim")
    public Claim findLastClaim() {
        Iterable<Claim> allClaims =  this.claimRepository.findAll();
        java.util.Iterator<Claim> it = allClaims.iterator();
        Claim curClaim = new Claim("NULL", "NULL", -1f);

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
