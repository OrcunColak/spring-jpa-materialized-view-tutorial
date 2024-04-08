package com.colak.springjpamaterializedviewtutorial.jpa;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DepartmentSalarySummary {
    private String department;
    private BigDecimal totalSalary;
}
