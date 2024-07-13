package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.Account;
import com.kiran.b.s.GradeSummarisation.database.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepo accountRepository;

    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> findByUniqueOauth2details(int oauthId, String clientReg) {
        return accountRepository.findByUniqueOauth2details(oauthId, clientReg);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }
}
