package com.bookings.accountservice.handlers;

import com.bookings.accountservice.Utility.AccountType;
import com.bookings.accountservice.domains.AccountDomain;
import com.bookings.accountservice.models.Account;
import com.bookings.accountservice.models.AccountCreateRequest;
import com.bookings.accountservice.models.RateCreateRequest;
import com.bookings.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class AccountHandler {

    public static final String CREATE_RATE_URL = "http://RATE-SERVICE/rates/create";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(AccountCreateRequest request) {
        AccountDomain accountDomain = new AccountDomain(true, 0.0, AccountType.USER.toString());
        RateCreateRequest rateCreateRequest = new RateCreateRequest();
        rateCreateRequest.setNumberOfNights(request.getNumberOfNights());
        rateCreateRequest.setRoomTypeId(request.getRoomTypeId());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RateCreateRequest> rateRequest = new HttpEntity<RateCreateRequest>(rateCreateRequest, headers);
        ResponseEntity<Double> rate = restTemplate.postForEntity(CREATE_RATE_URL, rateRequest, Double.class);
        accountDomain.setBalance(rate.getBody().doubleValue());
        return accountRepository.save(accountDomain).toModel();
    }

    public Account getAccountById(String id) {
        Optional<AccountDomain> account =  accountRepository.findById(id);
        if(account.isPresent()) {
            return account.get().toModel();
        }
        return null;
    }
}
