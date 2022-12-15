package com.meet5.meet5.controller;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.entity.Meet5Visitor;
import com.meet5.meet5.service.VisitorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author Sureena Wadhwa
 * **/

@RestController
@RequestMapping("/user/visit")
@AllArgsConstructor
@Slf4j
public class VisitorController {

    private VisitorService visitorService;

    // if user is fraudulent, they will not be allowed to visit other profiles
    @PostMapping()
    public ResponseEntity<Meet5Visitor> updateVisitor(String visitor_id, String visited_id) throws NoSuchElementException {
        try{
            return visitorService.isFraud(visitor_id)
                ? null
                : ok(visitorService.updateVisitor(visitor_id, visited_id));
        }
        catch(NoSuchElementException ex) {
            log.error("Cannot find user with this Id " + visitor_id);
            return notFound().build();
        }
    }

    // API to check if user is fraudulent
    @GetMapping()
    public boolean isFraudulent(@RequestParam("id") String id) {
        return visitorService.isFraud(id);
    }

    // API to get visitors of a user
    @GetMapping("/of/{id}")
    private List<Meet5User> getVisitors(@PathVariable("id") String id ) {
        return visitorService.getAllVisitorsOfUser(id);
    }

}
