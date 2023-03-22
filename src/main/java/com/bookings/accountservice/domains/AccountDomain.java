package com.bookings.accountservice.domains;

import com.bookings.accountservice.models.Account;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "account")
public class AccountDomain {
    @Id
    private String id;
    private Boolean active;
    private Double balance;
    private String type;

    public AccountDomain() {}

    public AccountDomain(Boolean active, Double balance, String type) {
        this.active = active;
        this.balance = balance;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account toModel() {
        Account account = new Account();
        account.setId(id);
        account.setBalance(balance);
        account.setType(type);
        account.setActive(active);

        return account;
    }
}
