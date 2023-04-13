package com.bookings.accountservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {
        private String roomTypeId;
        private Integer numberOfNights;
        private String ratePlanId;
}
