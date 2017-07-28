package com.springdata.dao;

import com.springdata.entity.Employee;
import com.springdata.repositories.EmployeeCriteriaRepository;
import com.springdata.repositories.EmployeeRepository;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kavita on 1/7/17.
 */
public class EmployeeDao {

    public void save(Employee employee, EmployeeRepository employeeRepository) {
        employeeRepository.save(employee);
        System.out.println("Saved successfully");
    }

    public void delete(Employee employee, EmployeeRepository employeeRepository) {
        employeeRepository.delete(employee);
        System.out.println("deleted successfully");
    }

    public void save(EmployeeRepository employeeRepository) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setAge(27);
        employee.setName("Peter");
        employee.setFistName("kavita");
        employee.setLastName("bora");
        employee.setSalary(20000);
        employees.add(employee);
        employee = new Employee();
        employee.setAge(27);
        employee.setName("Peter");
        employee.setFistName("kavita1");
        employee.setLastName("bora1");
        employee.setSalary(20000);
        employees.add(employee);
        System.out.println(employeeRepository.save(employees));
    }

    public void findById(EmployeeRepository employeeRepository) {
        System.out.println("==============findById===========================");
        System.out.println(employeeRepository.findById(1));
        System.out.println("=========================================");
    }

    public void findByName(EmployeeRepository employeeRepository) {
        System.out.println("================findByName=========================");
        System.out.println(employeeRepository.findByName("peter"));
        System.out.println("=========================================");
    }

    public void findByIdWithQuery(EmployeeRepository employeeRepository) {
        System.out.println("=================findByIdWithQuery========================");
        System.out.println(employeeRepository.findByIdWithQuery(1));
        System.out.println("=========================================");
    }

    public void countWithQuery(EmployeeRepository employeeRepository) {
        System.out.println("=================countWithQuery========================");
        System.out.println(employeeRepository.countWithQuery());
        System.out.println("=========================================");
    }

    public void findByFirstNameLike(EmployeeRepository employeeRepository) {
        System.out.println("=================findByFirstNameLike========================");
        System.out.println(employeeRepository.findByfistNameLike("kavi%"));
        System.out.println("=========================================");
    }

    public void findByNameNot(EmployeeRepository employeeRepository) {
        System.out.println("=================findByNameNot========================");
        System.out.println(employeeRepository.findByNameNot("Peter"));
        System.out.println("=========================================");
    }

    public void findByAgeIn(EmployeeRepository employeeRepository) {
        System.out.println("=================findByAgeIn========================");
        System.out.println(employeeRepository.findByAgeIn(Arrays.asList(27, 1)));
        System.out.println("=========================================");
    }

    public void findByAgeGreaterThanEqual(EmployeeRepository employeeRepository) {
        System.out.println("=================findByAgeGreaterThanEqual========================");
        System.out.println(employeeRepository.findByAgeGreaterThanEqual(27));
        System.out.println("=========================================");
    }

    public void findByAgeLessThan(EmployeeRepository employeeRepository) {
        System.out.println("=================findByAgeLessThan========================");
        System.out.println(employeeRepository.findByAgeLessThan(20));
        System.out.println("=========================================");
    }

    public void findDistinctByName(EmployeeRepository employeeRepository) {
        System.out.println("=================findDistinctByName========================");
        System.out.println(employeeRepository.findDistinctByName("Peter"));
        System.out.println("=========================================");
    }

    public void findFirst1ByName(EmployeeRepository employeeRepository) {
        System.out.println("=================findFirst1ByName========================");
        System.out.println(employeeRepository.findFirst1ByName("Peter"));
        System.out.println("=========================================");
    }

    public void findByNameAndAge(EmployeeRepository employeeRepository) {
        System.out.println("=================findByNameAndAge========================");
        System.out.println(employeeRepository.findByNameAndAge("Peter", 27));
        System.out.println("=========================================");
    }

    public void findByFirstNameIs(EmployeeRepository employeeRepository) {
        System.out.println("=================findByFirstNameIs========================");
        System.out.println(employeeRepository.findByFirstNameIs("kavita"));
        System.out.println("=========================================");
    }

    public void findAllCriteriaQuery (EmployeeCriteriaRepository employeeCriteriaRepository) {

        Specification<Employee> employeeSpecification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, javax.persistence.criteria.CriteriaQuery<?> query, CriteriaBuilder cb) {
               Path path=root.get("id");
                Predicate predicate = cb.gt(path, 5);
                return  predicate;
            }
        };


        System.out.println("=================findAllCriteriaQuery========================");
        System.out.println(employeeCriteriaRepository.findAll(employeeSpecification));
        System.out.println("=========================================");
    }

    public void  findByNameOrderByIdDesc(EmployeeRepository employeeRepository){
        System.out.println("=================findByNameOrderByIdDesc========================");
        System.out.println(employeeRepository.findByNameOrderByIdDesc("Peter"));
        System.out.println("=========================================");
    }

    public void  findAllWithSort(EmployeeRepository employeeRepository){
        System.out.println("=================findByNameOrderByIdDesc========================");
        System.out.println(employeeRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
        System.out.println("=========================================");
    }

    public void  findAllWithPagination(EmployeeRepository employeeRepository){
        System.out.println("=================findByNameOrderByIdDesc========================");
        PageRequest obj=new PageRequest(0,1,new Sort(Sort.Direction.ASC,"id"));
        Page<Employee> pageList=employeeRepository.findAll(obj);
        System.out.println(pageList.getContent().size());
        System.out.println(pageList.getTotalElements());
        System.out.println(pageList.getNumber());
        System.out.println(pageList.getTotalPages());
        System.out.println("=========================================");
    }
}
