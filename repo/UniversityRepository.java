package com.akvelon.testingSystem.repo;

import com.akvelon.testingSystem.entity.University;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {

    University findByName(String name);

    Boolean existsByName(@NonNull String name);

    @Query("SELECT u FROM University u " +
            "WHERE :isFiltered = FALSE " +
            "OR LOWER(u.name) LIKE LOWER(CONCAT('%',:part, '%')) " +
            "ORDER BY u.name DESC")
    List<University> findAllByPart(boolean isFiltered, String part);
}
