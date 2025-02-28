package com.payu.networkpriorization.model;

import lombok.Getter;
import lombok.Setter;

public class NetworkRequest {
    @Getter @Setter
    private int[] responseTimes;
    @Getter @Setter
    private int[] costs;
    @Getter @Setter
    private String criteria; // Allowed Values: "RESPONSE_TIME" o "COST"
}
