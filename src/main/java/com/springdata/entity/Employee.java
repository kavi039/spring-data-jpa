package com.springdata.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "Employee.findByFirstNameIs",
        query = "SELECT * from Employee where fistName = :name",
        resultClass = Employee.class)
@EntityListeners(AuditingEntityListener.class)
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer salary;

    private String fistName;

    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreatedDate
    private ZonedDateTime creationTime;

    public ZonedDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(ZonedDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(ZonedDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @LastModifiedDate
    private ZonedDateTime modificationTime;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
