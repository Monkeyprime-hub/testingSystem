package com.akvelon.testingSystem.service;

import com.akvelon.testingSystem.constant.ErrorMessage;
import com.akvelon.testingSystem.entity.UniversityGroup;
import com.akvelon.testingSystem.exceptions.NotFoundException;
import com.akvelon.testingSystem.repo.UniversityGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityGroupService {

    final
    UniversityGroupRepository groupRepository;

    public UniversityGroupService(UniversityGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public UniversityGroup save(UniversityGroup group) {
        return groupRepository.save(group);
    }

    public UniversityGroup findById(UUID id) {
        return groupRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorMessage.University_NOT_FOUND_BY_ID + id));
    }

    public UniversityGroup removeById(UUID id) {

        UniversityGroup university = findById(id);
        groupRepository.delete(university);
        return university;
    }

    public UniversityGroup findByName(String name) {
        return groupRepository.findByName(name);
    }

    public List<UniversityGroup> findAll() {
        return groupRepository.findAll();
    }
}
