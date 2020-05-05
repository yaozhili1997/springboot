package com.yzl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class ProviderController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/providers")
    public Map list() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from provider");
        Map<String, Object> map = maps.get(0);
        return map;
    }
}
