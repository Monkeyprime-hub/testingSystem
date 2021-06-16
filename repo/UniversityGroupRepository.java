package com.akvelon.testingSystem.repo;

import com.akvelon.testingSystem.entity.University;
import com.akvelon.testingSystem.entity.UniversityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UniversityGroupRepository extends JpaRepository<UniversityGroup, UUID> {

    Optional<UniversityGroup> findById(UUID id);
    UniversityGroup findByName(String name);

}
