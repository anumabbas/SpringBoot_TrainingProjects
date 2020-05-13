package com.spring.cdk.training.phase3.model;

import java.lang.annotation.Documented;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Employee Entity
 */

@Data
@Builder
@AllArgsConstructor
@Document(indexName = "employee-store", type = "employees")
public class Employee {

  @Id
  private String employeeId;
  private String firstName;
  private String lastName;
  private Integer age;
  private String experience;
  private List<String> skills;
  private Double salary;
  private Date dob;
  @Field(type = FieldType.Nested)
  private List<Phone> phone;

  public Employee(){

  }

}
