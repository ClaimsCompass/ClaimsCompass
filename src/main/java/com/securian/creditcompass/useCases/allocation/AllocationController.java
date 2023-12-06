package com.securian.creditcompass.useCases.allocation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationController {

    private final AllocationInteractor allocationInteractor;

    public AllocationController(AllocationInteractor allocationInteractor) {
        this.allocationInteractor = allocationInteractor;
    }

    @PostMapping("/assign")
    public boolean execute(){
//        System.out.println("Assign activate.");
        allocationInteractor.assignAllClaims();
//        System.out.println("Assign done.");
        return true;
    }
}
