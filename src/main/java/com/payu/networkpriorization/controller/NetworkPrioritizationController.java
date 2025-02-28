package com.payu.networkpriorization.controller;

import com.payu.networkpriorization.model.NetworkRequest;
import com.payu.networkpriorization.model.NetworkResponse;
import com.payu.networkpriorization.service.NetworkPrioritizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/network")
public class NetworkPrioritizationController {

    private final NetworkPrioritizationService networkService;
    @Autowired
    public NetworkPrioritizationController(NetworkPrioritizationService networkService) {
        this.networkService = networkService;
    }

    @PostMapping("/prioritize")
    public ResponseEntity<NetworkResponse> prioritizeNetwork(@RequestBody NetworkRequest request){
        int[] prioritize = networkService.prioritizeNetwork(request.getResponseTimes(), request.getCosts(), request.getCriteria());
        NetworkResponse response = new NetworkResponse(prioritize);
        return ResponseEntity.ok(response);
    }
}
