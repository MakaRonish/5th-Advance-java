package ca.sheridancollege.makaju.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.makaju.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
