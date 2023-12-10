package com.varks.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer schoolId;
}
