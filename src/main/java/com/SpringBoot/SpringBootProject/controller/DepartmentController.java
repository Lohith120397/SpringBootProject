package com.SpringBoot.SpringBootProject.controller;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import com.SpringBoot.SpringBootProject.error.DepartmentNotFoundException;
import com.SpringBoot.SpringBootProject.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping(value = "/departments")
    public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity departmentEntity)
    {
        LOGGER.info("Inside save department method of DepartmentController");
        return departmentService.saveDepartment(departmentEntity);
    }

    @GetMapping(value = "/departments")
    public List<DepartmentEntity> fetchDepartmentList()
    {
        LOGGER.info("Inside fetchDepartmentList method of DepartmentController");
        List<DepartmentEntity> listOfDepartments = departmentService.fetchDepartmentList();
        LOGGER.info("List of Departments after fetching from database: " + listOfDepartments);
        return listOfDepartments;
    }

    @GetMapping(value = "/departments/{id}")
    public DepartmentEntity fetchDepartmentById(@PathVariable("id")Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping(value = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!!";
    }

    @DeleteMapping(value = "/departments")
    public String deleteAllDepartments()
    {
        departmentService.deleteAllDepartments();
        return "All the departments are deleted!!!";
    }

    @PutMapping(value = "/departments/{id}")
    public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity departmentEntity, @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(departmentEntity, departmentId);
    }

    @GetMapping(value = "/departments/name/{name}")
    public DepartmentEntity fetchByDepartmentName(@PathVariable("name") String name)
    {
        return departmentService.fetchByDepartmentName(name);
    }

}
