package com.meet5.meet5.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Sureena Wadhwa
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meet5User {

  private String id;
  private String name;
  private int age;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdTs;
}
