package demo.SpringDataJpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.SpringDataJpa.Repository.EmployeeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getAll()throws Exception {
		employeeRepository.getAll().forEach(employees -> {
			System.out.println(employees);
		});
	}
	
	@Test
	public void add()throws Exception{
		employeeRepository.addEmployee("xuan", "tin", "xuantintin@gmail.com");
	}

	@Test
	public void update()throws Exception{
		employeeRepository.updateEmployee("trung", "truc", "trungtruc@gmail.com", 4);
	}
	
	@Test
	public void delete()throws Exception{
		employeeRepository.deleteEmployee(3);
	}

}
