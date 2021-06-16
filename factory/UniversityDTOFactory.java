package com.akvelon.testingSystem.factory;

import com.akvelon.testingSystem.dto.UniversityDTO;
import com.akvelon.testingSystem.entity.University;

import java.util.List;
import java.util.stream.Collectors;

public class UniversityDTOFactory {

    public UniversityDTO createUniversityDTO(University university) {
        return UniversityDTO.builder()
                .id(university.getId())
                .name(university.getName())
                .build();
    }

    public List<UniversityDTO> createUniversityDTOList(List<University> universityList) {
        return universityList.stream()
                .map(this::createUniversityDTO)
                .collect(Collectors.toList());
    }
}
