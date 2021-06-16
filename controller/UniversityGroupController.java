package com.akvelon.testingSystem.controller;

import com.akvelon.testingSystem.entity.University;
import com.akvelon.testingSystem.entity.UniversityGroup;
import com.akvelon.testingSystem.service.UniversityGroupService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/group")
public class UniversityGroupController {

    final
    UniversityGroupService groupService;

    public UniversityGroupController(UniversityGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<UniversityGroup>> fetchUniversities() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.findAll());
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<UniversityGroup> getUniversityById(@PathVariable UUID groupId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.findById(groupId));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<UniversityGroup> getUniversityByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<UniversityGroup> saveUniversity(@RequestBody UniversityGroup group) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(groupService.save(group));
    }

//    @PutMapping("/{groupId}")
//    public ResponseEntity<University> updateUniversity(@RequestBody UniversityGroup group, @PathVariable UUID groupId) {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(groupService.update(group, groupId));
//    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<UniversityGroup> removeUniversity(@PathVariable UUID groupId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.removeById(groupId));
    }


}
