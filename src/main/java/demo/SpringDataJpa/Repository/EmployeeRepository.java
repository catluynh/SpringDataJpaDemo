package demo.SpringDataJpa.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.SpringDataJpa.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select e from Employee e")
	List<Employee> getAll();
	
//	@Query("insert into employee(first_name, last_name, email) values(?1, ?2, ?3)")
//	void addEmployee(String first_name, String last_name, String email);
	
	@Transactional
	@Modifying
	@Query("update Employee e set e.firstName=?1, e.lastName=?2, e.email=?3 where e.id = ?4")
	void updateEmployee(String firstName, String lastName, String email, int id);
	
	@Transactional
	@Modifying
	@Query("delete from Employee e where e.id=?1")
	void deleteEmployee(int id);
}
