package com.bookings.accountservice.handlers;

import com.bookings.accountservice.Utility.AccountType;
import com.bookings.accountservice.domains.AccountDomain;
import com.bookings.accountservice.models.Account;
import com.bookings.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountHandler {

    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account) {
        AccountDomain accountDomain = new AccountDomain(true, 0.0, AccountType.USER.toString());
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
