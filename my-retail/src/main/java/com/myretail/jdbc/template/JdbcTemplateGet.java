package com.myretail.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Project: myretail-parent
 * Package: com.myretail.jdbc.template
 * <p>
 * User: vthalapu
 * Date: 4/11/18
 * Time: 8:48 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JdbcTemplateGet {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateGet(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
