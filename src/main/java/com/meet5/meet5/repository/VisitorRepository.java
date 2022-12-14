package com.meet5.meet5.repository;

import com.meet5.meet5.entity.Meet5Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Sureena Wadhwa
 **/
@Repository
public class VisitorRepository {

    @Autowired private JdbcTemplate jdbcTemplate;

    @Value("${fraudulentThreshold:100}")
    private int fraudulentThreshold;

    public Meet5Visitor save(Meet5Visitor meet5Visitor) {
        jdbcTemplate.update("INSERT into meet5_visitor VALUES (?, ?, ?)",
                meet5Visitor.getVisitor_id(), meet5Visitor.getVisited_id(), meet5Visitor.getVisited_ts());
        return meet5Visitor;
    }

    public boolean isFraudulent(String id){
        String query = "SELECT count(*) >=? from meet5_user " +
                "INNER JOIN meet5_visitor ON meet5_user.id = meet5_visitor.visitor_id " +
                "where TIMESTAMPDIFF(MINUTE, created_ts, visited_ts) < 10 and visitor_id = ?";
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(query, boolean.class,fraudulentThreshold,id));
    }
}
