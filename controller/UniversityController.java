package com.akvelon.testingSystem.controller;

import com.akvelon.testingSystem.dto.UniversityDTO;
import com.akvelon.testingSystem.entity.UniversityGroup;
import com.akvelon.testingSystem.factory.UniversityDTOFactory;
import com.akvelon.testingSystem.service.UniversityService;
import com.akvelon.testingSystem.entity.University;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/api/university")
public class UniversityController {


    UniversityService universityService;
    UniversityDTOFactory dtoFactory;


    @GetMapping
    public ResponseEntity<List<UniversityDTO>> fetchUniversities() {

        List<University> universityList = universityService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoFactory.createUniversityDTOList(universityList));
    }

    @GetMapping("/{universityId}")
    public ResponseEntity<UniversityDTO> getUniversityById(@PathVariable Long universityId) {

        University university = universityService.findById(universityId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoFactory.createUniversityDTO(university));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<UniversityDTO> getUniversityByName(@PathVariable String name) {

        University university = universityService.findByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoFactory.createUniversityDTO(university));
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> saveUniversity(@RequestBody University university) {

        University savedUniversity = universityService.save(university);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dtoFactory.createUniversityDTO(savedUniversity));
    }

    @PutMapping("/{universityId}")
    public ResponseEntity<UniversityDTO> updateUniversity(@RequestBody University university, @PathVariable Long universityId) {

        University updatableUniversity = universityService.update(university, universityId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoFactory.createUniversityDTO(updatableUniversity));
    }

    @DeleteMapping("/{universityId}")
    public ResponseEntity<UniversityDTO> removeUniversity(@PathVariable Long universityId) {

        University university = universityService.removeById(universityId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoFactory.createUniversityDTO(university));
    }
}
