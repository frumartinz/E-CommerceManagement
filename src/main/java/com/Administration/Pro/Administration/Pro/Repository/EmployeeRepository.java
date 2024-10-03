package com.Administration.Pro.Administration.Pro.Repository;

import com.Administration.Pro.Administration.Pro.Webdomains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query(value = "SELECT * FROM employees WHERE given_name = :given_name", nativeQuery = true)
//    List<Employee> findByFirstName(@Param("given_name") String given_name);

    List<Employee> findBySurnameContainingIgnoreCase(String query);
}
