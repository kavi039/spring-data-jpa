package com.springdata.repositories;

import com.springdata.entity.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

/**
 * Created by kavita on 1/7/17.
 */
public interface EmployeeCriteriaRepository extends Repository<Employee,Integer>,JpaSpecificationExecutor<Employee> {
}
