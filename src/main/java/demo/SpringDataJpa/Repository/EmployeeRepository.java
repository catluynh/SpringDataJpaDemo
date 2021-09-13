package demo.SpringDataJpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.SpringDataJpa.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value ="select * from employee", nativeQuery = true)
	List<Employee> getAll();
	
	@Query(value ="insert into employee(first_name, last_name, email) values(?1, ?2, ?3)", nativeQuery = true)
	void addEmployee(String first_name, String last_name, String email);
	
	@Query(value ="update employee set first_name=?1, last_name=?2, email=?3 where id = ?4", nativeQuery = true)
	void updateEmployee(String first_name, String last_name, String email, Integer id);
	
	@Query(value ="delete from employee where id=?1", nativeQuery = true)
	void deleteEmployee(int id);
}
