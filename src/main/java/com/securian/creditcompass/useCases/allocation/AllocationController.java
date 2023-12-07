package com.securian.creditcompass.useCases.allocation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationController {

    private final AllocationInteractor allocationInteractor;

    public AllocationController(AllocationInteractor allocationInteractor) {
        /*
        @param allocationInteractor: the interactor used to assign claims to users
        */
        this.allocationInteractor = allocationInteractor;
    }

    @PostMapping("/assign")
    public boolean execute(){
        /*
        @return: true if the claims were successfully assigned, false otherwise
        */
        allocationInteractor.assignAllClaims();
        return true;
    }
}
