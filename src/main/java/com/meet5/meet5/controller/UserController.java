package com.meet5.meet5.controller;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sureena Wadhwa
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @PostMapping()
  private int createUser(Meet5User requestUser) {
    return userService.createUser(requestUser);
  }

  @GetMapping()
  private List<Meet5User> getAll() {
    return userService.getAllUsers();
  }

  @GetMapping("/visitorsOf/{id}")
  private List<Meet5User> getVisitors(@PathVariable("id") String id ) {
    return userService.getAllVisitorsOfUser(id);
  }
}
