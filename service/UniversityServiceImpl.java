package com.akvelon.testingSystem.service;

import com.akvelon.testingSystem.constant.LogMessage;
import com.akvelon.testingSystem.exceptions.NotFoundException;
import com.akvelon.testingSystem.constant.ErrorMessage;
import com.akvelon.testingSystem.entity.University;
import com.akvelon.testingSystem.repo.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UniversityServiceImpl implements UniversityService {

    final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<University> findAll() {
        log.info(LogMessage.IN_FIND_ALL);
        return universityRepository.findAll();
    }

    @Override
    public University findByName(String name) {
        log.info(LogMessage.IN_FIND_BY_NAME, name);
        return universityRepository.findByName(name);
    }

    @Override
    public University save(University city) {
        log.info(LogMessage.IN_SAVE, city);

        return universityRepository.save(city);
    }

    @Override
    public University findById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID, id);

        return universityRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorMessage.University_NOT_FOUND_BY_ID + id));
    }

    @Override
    public University removeById(Long id) {
        log.info(LogMessage.IN_DELETE_BY_ID, id);

        University university = findById(id);
        universityRepository.delete(university);
        return university;
    }

    @Override
    public University update(University university, Long universityId) {
        log.info(LogMessage.IN_UPDATE, university);
        University updatable = findById(universityId);
        updatable.setName(university.getName());
        return universityRepository.save(university);


    }
}
