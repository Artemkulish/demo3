package com.softserve.messaging.controller;

import com.softserve.messaging.model.UserReceipt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "identity-service")
public interface IdentityClient {

    @GetMapping(path = "/accounts/{id}")
    UserReceipt getMissingUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken, @PathVariable UUID id);
}
