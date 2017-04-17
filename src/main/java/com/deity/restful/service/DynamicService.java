package com.deity.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Deity on 2017/4/17.
 */
@Service
public class DynamicService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add() {
        jdbcTemplate.update("insert into table (xxx,xxx) VALUES(XXX, XXX)");
    }

    @Transactional
    public void add2() {
        jdbcTemplate.update("insert into table (xxx,xxx) VALUES(XXX, XXX)");
        jdbcTemplate.update("insert into table (xxx,xxx) VALUES(XXX, XXX)");
    }
}
