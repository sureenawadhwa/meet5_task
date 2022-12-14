package com.meet5.meet5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Sureena Wadhwa
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meet5Visitor {

    private String visitor_id;
    private String visited_id;
    LocalDateTime visited_ts;
}
