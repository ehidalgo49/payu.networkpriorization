package com.payu.networkpriorization.controller;

import com.payu.networkpriorization.model.NetworkRequest;
import com.payu.networkpriorization.model.NetworkResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/network")
public class NetworkPrioritizationController {
    @PostMapping("/prioritize")
    public ResponseEntity<NetworkResponse> prioritizeNetwork(@RequestBody NetworkRequest request){
        int[] prioritize = {};
        NetworkResponse response = new NetworkResponse(prioritize);
        return ResponseEntity.ok(response);
    }
}
