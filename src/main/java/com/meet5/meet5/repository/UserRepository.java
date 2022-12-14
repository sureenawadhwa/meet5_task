package com.meet5.meet5.repository;

import com.meet5.meet5.entity.Meet5User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sureena Wadhwa
 */
@Repository
public class UserRepository {
  @Autowired private JdbcTemplate jdbcTemplate;

  public int save(Meet5User meet5User) {
    return jdbcTemplate.update("INSERT into meet5_user VALUES (?, ?, ?,?)",
            meet5User.getId(), meet5User.getName(), meet5User.getAge(),meet5User.getCreatedTs());
  }

  public List<Meet5User> getAll() {
    return jdbcTemplate.query(
        "SELECT * FROM meet5_user", new BeanPropertyRowMapper<Meet5User>(Meet5User.class));
  }

}
