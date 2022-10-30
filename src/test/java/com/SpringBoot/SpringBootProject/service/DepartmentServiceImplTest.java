package com.SpringBoot.SpringBootProject.service;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import com.SpringBoot.SpringBootProject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder().departmentId(1L).departmentName("CS").departmentCode("CS-01").departmentLocation("Bangalore").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS")).thenReturn(departmentEntity);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void fetchByDepartmentNameTest()
    {
        String departmentName = "CS";

        DepartmentEntity departmentEntity = departmentService.fetchByDepartmentName(departmentName);

        assertEquals(departmentName, departmentEntity.getDepartmentName());

    }

}