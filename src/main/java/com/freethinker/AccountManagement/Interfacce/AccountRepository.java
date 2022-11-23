package com.freethinker.AccountManagement.Interfacce;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freethinker.AccountManagement.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	List<Account> findByAccountIdContaining(String accountId);
}
