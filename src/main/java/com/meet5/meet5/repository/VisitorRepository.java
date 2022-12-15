package com.meet5.meet5.repository;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.entity.Meet5Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * @author Sureena Wadhwa
 **/
@Repository
@RequiredArgsConstructor
public class VisitorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Value("${fraudulentThreshold:100}")
    private int fraudulentThreshold;

    public Meet5Visitor save(Meet5Visitor meet5Visitor) {
        jdbcTemplate.update("INSERT into meet5_visitor VALUES (?, ?, ?)",
                meet5Visitor.getVisitor_id(), meet5Visitor.getVisited_id(), meet5Visitor.getVisited_ts());
        return meet5Visitor;
    }

    public boolean isFraudulent(String id){
        String query = "SELECT count(*) >= ? from meet5_user " +
                        "INNER JOIN meet5_visitor ON meet5_user.id = meet5_visitor.visitor_id " +
                        "where TIMESTAMPDIFF(MINUTE, created_ts, visited_ts) < 10 and visitor_id = ?";
        return TRUE.equals(jdbcTemplate.queryForObject(query, boolean.class, fraudulentThreshold, id));
    }

    public List<Meet5User> getAllVisitorsOfUserSortedDesc(String id) {
        String query = "SELECT u.id, u.name, u.age, u.created_ts " +
                "from meet5_user as u " +
                "INNER JOIN meet5_visitor " +
                "ON u.id = meet5_visitor.visitor_id " +
                "where visited_id = ? " +
                "ORDER BY visited_ts DESC";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Meet5User.class), id);
    }
}
