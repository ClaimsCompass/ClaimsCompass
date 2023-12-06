package com.securian.creditcompass.useCases.claimPage;

import lombok.Getter;

public class ClaimPageInputData {
    public final Long claimId;
    public Boolean isPost;

    public ClaimPageInputData(Long claimId, Boolean isPost) {
        /*
        @param claimId: the id of the claim to get
        @param isPost: whether the request is a POST request
         */
        this.claimId = claimId;
    }


}
