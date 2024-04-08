package com.colak.springjpamaterializedviewtutorial.repository;


import com.colak.springjpamaterializedviewtutorial.jpa.DepartmentSalarySummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    @Transactional
    void refreshMaterializedView() {
        repository.refreshDepartmentSalarySummary();

        List<DepartmentSalarySummary> departmentSalarySummary = repository.getDepartmentSalarySummary();
        assertThat(departmentSalarySummary).hasSize(3);
        List<DepartmentSalarySummary> expected = List.of(
                new DepartmentSalarySummary("Sales", new BigDecimal("115000")),
                new DepartmentSalarySummary("Engineering", new BigDecimal("110000")),
                new DepartmentSalarySummary("Marketing", new BigDecimal("105000"))
        );
        assertThat(departmentSalarySummary).containsAll(expected);
    }
}
