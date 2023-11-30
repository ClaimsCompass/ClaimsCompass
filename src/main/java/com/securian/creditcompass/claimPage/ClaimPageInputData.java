package com.securian.creditcompass.claimPage;

import lombok.Getter;

public class ClaimPageInputData {
    public final Long claimId;
    public Boolean isPost;

    public ClaimPageInputData(Long claimId, Boolean isPost) {
        this.claimId = claimId;
    }


}
