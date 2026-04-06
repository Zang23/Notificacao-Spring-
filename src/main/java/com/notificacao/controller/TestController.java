package com.notificacao.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public String test() throws Exception {
        return dataSource.getConnection().isValid(2) ? "Conectado!" : "Erro";
    }
}
                                     