package com.meet5.meet5.controller;

import com.meet5.meet5.entity.Meet5User;
import com.meet5.meet5.entity.Meet5Visitor;
import com.meet5.meet5.service.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sureena Wadhwa
 * **/

@RestController
@RequestMapping("/user/visit")
@AllArgsConstructor
public class VisitorController {

    private VisitorService visitorService;

    // if user is fraudulent, they will not be allowed to visit other profiles
    @PostMapping()
    public Meet5Visitor updateVisitor(String visitor_id, String visited_id) {
        return visitorService.isFraud(visitor_id)
                ? null
                : visitorService.updateVisitor(visitor_id, visited_id);
    }

    // API to check if user is fraudulent
    @GetMapping()
    public boolean isFraudulent(@RequestParam("id") String id) {
        return visitorService.isFraud(id);
    }

    // API to get visitors of a user
    @GetMapping("/visitorsOf/{id}")
    private List<Meet5User> getVisitors(@PathVariable("id") String id ) {
        return visitorService.getAllVisitorsOfUser(id);
    }

}
