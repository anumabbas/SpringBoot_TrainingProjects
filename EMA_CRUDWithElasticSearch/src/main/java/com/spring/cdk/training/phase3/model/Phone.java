package com.spring.cdk.training.phase3.model;

import com.spring.cdk.training.phase3.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Phone Entity having manyToOne relation with Employee class
 */

@Data
@Builder
@AllArgsConstructor
public class Phone {

  private Long phoneId;
  private String phoneNumber;
  private PhoneType phoneType;
  private Employee employee;
}




