package com.springdata.repositories;


import com.springdata.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findById(Integer id);

    List<Employee> findByName(String name);

    @Query("SELECT name from Employee where id=:id")
    String findByIdWithQuery(@Param("id") Integer id);

    @Query("SELECT count(*) from Employee")
    String countWithQuery();

    List<Employee> findByfistNameLike(String firstName);

    List<Employee> findByNameNot(String name);

    List<Employee> findByAgeIn(List<Integer> ageList);

    List<Employee> findByAgeGreaterThanEqual(Integer age);

    List<Employee> findByAgeLessThan(int age);

    List<Employee> findDistinctByName(String name);

    List<Employee> findFirst1ByName(String name);

    List<Employee> findByNameAndAge(String name, Integer age);

    List<Employee> findByFirstNameIs(@Param("name") String name);

    List<Employee> findByNameOrderByIdDesc(String name);

    List<Employee> findAll(Sort sort);

    Page<Employee> findAll(Pageable pageable);
}
