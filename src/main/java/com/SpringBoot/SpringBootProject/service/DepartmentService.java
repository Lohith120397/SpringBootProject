package com.SpringBoot.SpringBootProject.service;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import com.SpringBoot.SpringBootProject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    public List<DepartmentEntity> fetchDepartmentList();

    public DepartmentEntity fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public void deleteAllDepartments();

    public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity, Long departmentId);

    public DepartmentEntity fetchByDepartmentName(String name);

    public DepartmentEntity fetchByDepartmentNameIgnoreCase(String name);
}
