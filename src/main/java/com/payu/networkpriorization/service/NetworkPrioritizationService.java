package com.payu.networkpriorization.service;

import org.springframework.stereotype.Service;

@Service
public class NetworkPrioritizationService {
    public int[] prioritizeNetwork(int[] responseTimes, int[] costs, String criteria) {
        return NetworkPrioritization.prioritizeNetwork(responseTimes, costs, criteria);
    }
}
