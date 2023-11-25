package com.securian.creditcompass.Allocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping("/assign")
    public void execute(){
        System.out.println("Assign activate.");
        allocationService.assignAllClaims();
        System.out.println("Assign done.");
    }
}
