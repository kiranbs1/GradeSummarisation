package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.data.DTOs.AccountDTO;
import com.kiran.b.s.GradeSummarisation.data.DTOs.CourseDTO;
import com.kiran.b.s.GradeSummarisation.data.mappers.DTOMapper;
import com.kiran.b.s.GradeSummarisation.data.mappers.EntityMapper;
import com.kiran.b.s.GradeSummarisation.database.entities.Account;
import com.kiran.b.s.GradeSummarisation.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping( "/v1/account" )
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getOrCreateAuthenticatedAccount")
    public ResponseEntity<AccountDTO> getOrCreateAccount(@AuthenticationPrincipal() OAuth2AuthenticatedPrincipal userPrincipal ) {
        int id = userPrincipal.getAttribute("id");
        String email = userPrincipal.getAttribute("email");
        String clientRegistration = userPrincipal.getAttribute("clientRegistrationId");

        Optional<Account> account = accountService.findByUniqueOauth2details(id, clientRegistration);
        if (!account.isEmpty()) {
            AccountDTO accountDTO = DTOMapper.toAccountDTO(account.get());
            System.out.println("We found the account" + account.get().getUserAccountId() + " : " + accountDTO.getUserAccountId());
            return ResponseEntity.ok(accountDTO);
        }
        System.out.println("We created a new account account");
        Account newAccount = new Account(email, clientRegistration, id);
        newAccount = accountService.save(newAccount);
        AccountDTO accountDTO = DTOMapper.toAccountDTO(newAccount);
        return ResponseEntity.ok(accountDTO);
    }
}
