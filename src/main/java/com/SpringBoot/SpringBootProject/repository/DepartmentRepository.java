package com.SpringBoot.SpringBootProject.repository;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    public DepartmentEntity findByDepartmentName(String name);

    public DepartmentEntity findByDepartmentNameIgnoreCase(String name);

}
