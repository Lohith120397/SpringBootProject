package com.SpringBoot.SpringBootProject.repository;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder().departmentName("Computer science").departmentCode("CS-01").departmentLocation("Bangalore").build();

        testEntityManager.persist(departmentEntity);
    }

    @Test
    void findByDepartmentId() {
        DepartmentEntity department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Computer science");
    }
}