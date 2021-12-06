package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
