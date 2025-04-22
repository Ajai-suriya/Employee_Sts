package com.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//native Query
	@Query (value = "Select * from Employee where salary between ? and ?", nativeQuery = true)
	public List<Employee> getBtwn(int x, int y);
	
	//jQuery
	@Query(value = "select e from Employee e where e.salary between :a and :b")
	public List<Employee> getInBtwn(@Param("a") int a, @Param("b") int b);
	
	@Query(value = "select e from Employee e where e.name like concat(:x, '%')")
	public List<Employee> getString(@Param("x") String x);
	
	@Query(value = "select e from Employee e where e.salary = (select max(e.salary) from Employee e)")
	public List<Employee> getMaxSal();
	
	@Query(value = "select e from Employee e where e.salary = (select max(e.salary)from Employee e where e.salary < (select max(e.salary)from Employee e))")
	public List<Employee> get2ndMaxSal();
	
	@Query(value = "select e.name,e.gender from Employee e group by e.name,e.gender")
	public List<Object> groupingByNme();
	
	@Query(value = "select e from Employee e where lower(e.name)=lower(:x)")
	public Employee getEntireObjs(@Param("x") String x);
	
	//Exception 
	@Query(value = "select e from Employee e where e.name = :x ")
	public List<Employee> getByName(String x);
	
	@Query(value = "select e from Employee e where e.id = :x")
	public Employee getById(@Param("x") int x);
}
