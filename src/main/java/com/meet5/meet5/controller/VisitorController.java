package com.meet5.meet5.controller;

import com.meet5.meet5.entity.Meet5Visitor;
import com.meet5.meet5.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sureena Wadhwa
 * **/
@RestController
@RequestMapping("/user/visit")
public class VisitorController {
    @Autowired private VisitorService visitorService;

    // if user is fraudulent, they will not be allowed to visit other profiles
    @PostMapping()
    public Meet5Visitor updateVisitor(String visitor_id, String visited_id) {
        boolean isFraud = visitorService.isFraud(visitor_id);
        if(isFraud){
            return null;
        }
        return visitorService.updateVisitor(visitor_id, visited_id);
    }

    // API to check if user is fraudulent
    @GetMapping()
    public boolean isFraudulent(@RequestParam("id") String id) {
        return visitorService.isFraud(id);
    }

}
