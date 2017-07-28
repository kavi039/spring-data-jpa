package com.springdata.demo;

import com.springdata.config.PersistenceContext;
import com.springdata.dao.EmployeeDao;
import com.springdata.entity.Employee;
import com.springdata.repositories.EmployeeCriteriaRepository;
import com.springdata.repositories.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Dummy {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
//        Employee employee= new Employee();
//        employee.setAge(27);
//        employee.setName("Peter");
//        employee.setFistName("kavita");
//        employee.setLastName("bora");
//        employee.setSalary(20000);
        EmployeeRepository employeeRepository=applicationContext.getBean(EmployeeRepository.class);
        EmployeeCriteriaRepository employeeCriteriaRepository=applicationContext.getBean(EmployeeCriteriaRepository.class);
//        employeeRepository.save(employee);
        EmployeeDao employeeDao=new EmployeeDao();
//        employeeDao.save(employee,employeeRepository);
//        employeeDao.delete(employee, employeeRepository);
        employeeDao.save(employeeRepository);
        employeeDao.findById(employeeRepository);
        employeeDao.findByName(employeeRepository);
        employeeDao.findByIdWithQuery(employeeRepository);
        employeeDao.countWithQuery(employeeRepository);
        employeeDao.findByFirstNameLike(employeeRepository);
        employeeDao.findByNameNot(employeeRepository);
        employeeDao.findByAgeGreaterThanEqual(employeeRepository);
        employeeDao.findByAgeLessThan(employeeRepository);
        employeeDao.findByAgeIn(employeeRepository);
        employeeDao.findDistinctByName(employeeRepository);
        employeeDao.findFirst1ByName(employeeRepository);
        employeeDao.findByNameAndAge(employeeRepository);
        employeeDao.findByFirstNameIs(employeeRepository);
        employeeDao.findAllCriteriaQuery(employeeCriteriaRepository);
        employeeDao.findByNameOrderByIdDesc(employeeRepository);
        employeeDao.findAllWithSort(employeeRepository);
        employeeDao.findAllWithPagination(employeeRepository);
        System.out.println("All operation performed");
    }
}
