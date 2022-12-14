package com.meet5.meet5.service;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sureena Wadhwa @Since 13/12/2022
 */
@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;

  public List<Meet5User> getAllUsers(){
    return userRepository.getAll();
  }

  public int createUser(Meet5User meet5User){
    meet5User.setCreatedTs(LocalDateTime.now());
    return userRepository.save(meet5User);
  }

  public List<Meet5User> getAllVisitorsOfUser(String id) {
    return userRepository.getAllVisitorsOfUserSortedDesc(id);
  }
}
