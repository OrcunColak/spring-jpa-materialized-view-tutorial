package com.colak.springjpamaterializedviewtutorial.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")

@NamedNativeQuery(name = "get_department_salary_summary",
        query = "select * from department_salary_summary",
        resultSetMapping = "DepartmentSalarySummaryDto")
@SqlResultSetMapping(name = "DepartmentSalarySummaryDto",
        classes = @ConstructorResult(targetClass = DepartmentSalarySummary.class,
                columns = {@ColumnResult(name = "department"),
                        @ColumnResult(name = "total_salary")}))
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private Double salary;

}
