package com.meet5.meet5.controller;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  private Meet5User createUser(Meet5User requestUser) {
    return userService.createUser(requestUser);
  }

  @GetMapping()
  private List<Meet5User> getAll() {
    return userService.getAllUsers();
  }
}
