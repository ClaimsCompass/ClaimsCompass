//package com.securian.creditcompass.PolicyHolder;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class PolicyHolderController {
//
//    private final PolicyHolderRepository PolicyHolderRepository;
//
//    public PolicyHolderController(PolicyHolderRepository PolicyHolderRepository) {
//        this.PolicyHolderRepository = PolicyHolderRepository;
//    }
//    @GetMapping("/PolicyHolders")
//    public Iterable<PolicyHolder> findPolicyHolders() {
//        return this.PolicyHolderRepository.findAll();
//    }
//
//    @GetMapping("/PolicyHolder")
//    public PolicyHolder findLastPolicyHolder() {
//        Iterable<PolicyHolder> allPolicyHolder =  this.PolicyHolderRepository.findAll();
//        java.util.Iterator<PolicyHolder> it = allPolicyHolder.iterator();
//        PolicyHolder curPolicyHolder = new PolicyHolder("NULL", "NULL");
//
//        while (it.hasNext()) {
//            curPolicyHolder = it.next();
//        }
//        return curPolicyHolder;
//    }
//
//    @PostMapping("/PolicyHolders")
//    public PolicyHolder addOnePolicyHolder(@RequestBody PolicyHolder policyholder) {
//        return this.PolicyHolderRepository.save(policyholder);
//    }
//}
