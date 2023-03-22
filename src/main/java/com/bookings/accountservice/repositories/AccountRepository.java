/*
*@ Copyright --Anant Barthwal
*/
package com.bookings.accountservice.repositories;

import com.bookings.accountservice.domains.AccountDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<AccountDomain, String> {

}
