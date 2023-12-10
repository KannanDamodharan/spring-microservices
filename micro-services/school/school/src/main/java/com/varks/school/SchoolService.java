package com.varks.school;


import com.varks.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public void saveSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school= schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());
        var students = client.findAllStudentsBySchool(schoolId); // find all the students from micro-services
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students).build();
    }
}
