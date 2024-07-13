package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.database.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v1/home" )
public class HomeController {

    @Autowired
    private AccountService accountService;

}