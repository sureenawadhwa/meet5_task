package com.meet5.meet5.service;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.entity.Meet5Visitor;
import com.meet5.meet5.repository.UserRepository;
import com.meet5.meet5.repository.VisitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Sureena Wadhwa
 **/
@Service
@AllArgsConstructor
public class VisitorService {

    private VisitorRepository visitorRepository;
    private UserRepository userRepository;

    public Meet5Visitor updateVisitor(String visitor_id, String visited_id) throws NoSuchElementException {
        userRepository
                .findById(visitor_id)
                .orElseThrow(() -> new NoSuchElementException("Cannot find user with this ID "+ visitor_id));
        LocalDateTime getCurrentDateTime = LocalDateTime.now();
        Meet5Visitor meet5Visitor = new Meet5Visitor(visitor_id, visited_id, getCurrentDateTime);
        return visitorRepository.save(meet5Visitor);
    }

    public boolean isFraud(String id) {
        return visitorRepository.isFraudulent(id);
    }

    public List<Meet5User> getAllVisitorsOfUser(String id) {
        return visitorRepository.getAllVisitorsOfUserSortedDesc(id);
    }

}
