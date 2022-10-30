package com.SpringBoot.SpringBootProject.service;

import com.SpringBoot.SpringBootProject.entity.DepartmentEntity;
import com.SpringBoot.SpringBootProject.error.DepartmentNotFoundException;
import com.SpringBoot.SpringBootProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity fetchByDepartmentName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

    @Override
    public DepartmentEntity fetchByDepartmentNameIgnoreCase(String name) {
        return  departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity, Long departmentId) {
        DepartmentEntity depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(departmentEntity.getDepartmentName()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentName()))
        {
            depDB.setDepartmentName(departmentEntity.getDepartmentName());
        }

        if(Objects.nonNull(departmentEntity.getDepartmentCode()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentCode()))
        {
            depDB.setDepartmentCode(departmentEntity.getDepartmentCode());
        }

        if(Objects.nonNull(departmentEntity.getDepartmentLocation()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentLocation()))
        {
            depDB.setDepartmentLocation(departmentEntity.getDepartmentLocation());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public List<DepartmentEntity> fetchDepartmentList() {

        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<DepartmentEntity> departmentList = departmentRepository.findById(departmentId);

        if(!departmentList.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }
        return departmentList.get();
    }
}
