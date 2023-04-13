package com.bookings.accountservice.controllers;

import com.bookings.accountservice.handlers.AccountHandler;
import com.bookings.accountservice.models.Account;
import com.bookings.accountservice.models.AccountCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountHandler accountHandler;
    @PostMapping("/create")
    public Account createAccount(@RequestBody AccountCreateRequest request) {
       return accountHandler.createAccount(request);
    }

    @GetMapping("/id/{id}")
    public Account getById(@PathVariable String id) {
        return accountHandler.getAccountById(id);
    }
}
