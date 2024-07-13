package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.database.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    // You can add custom query methods here if needed

//    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN FETCH a.courses WHERE a.clientReg = :clientReg AND a.oauthId = :oauthId")
//    Optional<Account> findByUniqueOauth2details(int oauthId, String clientReg);

    @Query("SELECT a FROM Account a WHERE a.clientReg = :clientReg AND a.oauthId = :oauthId")
    Optional<Account> findByUniqueOauth2details(int oauthId, String clientReg);

}

