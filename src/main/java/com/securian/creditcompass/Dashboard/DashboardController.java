//package com.securian.creditcompass;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
//@RestController
//public class DashboardController {
//
//    private final ClaimRepository claimRepository; // Assuming you have a repository for Claims
//
//    @GetMapping("/api/claims") // API endpoint to get all claims
//    public List<List> getAllClaims() {
//        return claimRepository.findAll();
//    }
//
//    // Other API endpoints for CRUD operations, filtering, etc.
//}
/////package com.securian.creditcompass.Dashboard;
/////
/////import com.securian.creditcompass.Claimant.Claimant;
/////import com.securian.creditcompass.entities.Claim;
/////import org.springframework.web.bind.annotation.GetMapping;
/////import org.springframework.web.bind.annotation.PostMapping;
/////import org.springframework.web.bind.annotation.RequestBody;
/////import org.springframework.web.bind.annotation.RestController;
/////
/////import java.util.List;
/////
/////@RestController
/////public class DashboardController {
/////
/////    private final DashboardRepository dashboardRepository;
/////
/////    public DashboardController(DashboardRepository dashboardRepository) {
/////        this.dashboardRepository = dashboardRepository;
/////    }
/////    @GetMapping("/claims")
/////    public List<Claim> findClaims() {
/////        return (List<Claim>) this.dashboardRepository.findAll();
/////    }
/////
/////    @GetMapping("/processedClaims")
/////    public List<Claim> findProcessedClaims() {return (List<Claim>) this.dashboardRepository.findAll();}
/////
/////    @GetMapping("/claims")
/////    public Claim findLastClaim() {
/////        Iterable<Claim> allClaims =  this.dashboardRepository.findAll();
/////        java.util.Iterator<Claim> it = allClaims.iterator();
/////        Claim curClaim = new Claim("NULL", "NULL", -1f, new Claimant("NULL", "NULL")); // This will not work at the moment since we're not sure if we
/////        //want the claimant in claim or claim in claimant (more to discuss)
/////
/////        while (it.hasNext()) {
/////            curClaim = it.next();
/////        }
/////        return curClaim;
/////    }
/////
/////    @PostMapping("/claims")
/////    public Claim addOneClaim(@RequestBody Claim claim) {
/////        return this.dashboardRepository.save(claim);
/////    }
/////}
