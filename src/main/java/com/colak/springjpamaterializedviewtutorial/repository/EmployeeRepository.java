package com.colak.springjpamaterializedviewtutorial.repository;

import com.colak.springjpamaterializedviewtutorial.jpa.DepartmentSalarySummary;
import com.colak.springjpamaterializedviewtutorial.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            name = "get_department_salary_summary",
            nativeQuery = true
    )
    List<DepartmentSalarySummary> getDepartmentSalarySummary();

    /*
    The refresh materialized view statement does not return any result set,
    but Spring Data JPA expects one. To fix this, you need to annotate your method with @Modifying,
    which tells Spring Data JPA that the query is a DML statement and does not return any result.
    You can also use the clearAutomatically attribute to clear the persistence context after the query execution,
    which might be useful if you want to query the refreshed view afterwards.
     */
    @Modifying(clearAutomatically = true)
    // use @Async instead!
    @Query(
            value = "refresh materialized view department_salary_summary;",
            nativeQuery = true
    )
    void refreshDepartmentSalarySummary();
}
