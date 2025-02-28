package com.payu.networkpriorization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class NetworkResponse {
    @Getter @Setter
    private int[] prioritizedNetworks;
}
