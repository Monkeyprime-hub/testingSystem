package com.akvelon.testingSystem.service;

import com.akvelon.testingSystem.entity.University;

import java.util.List;

public interface UniversityService {

    List<University> findAll();

    University findByName(String name);

    University save(University city);

    University findById(Long id);

    University removeById(Long id);

    University update(University city, Long universityId);

}
