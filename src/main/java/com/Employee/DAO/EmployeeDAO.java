package com.Employee.DAO;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDAO {
  @Autowired
  EmployeeRepository er;
  
  public String postObj(Employee e) {
	  er.save(e);
	  return "Posted single object successfully";
  }
  
  public String postListOfEmp(List<Employee> e) {
	  er.saveAll(e);
	  return "Posted successfully";
  }
  
  public Employee getSingleId(int x) {
	return er.findById(x).get();
  }
  
  public List<Employee> getEntireObj() {
	return er.findAll();
  }
  
  public String update(int x, Employee e) {
	  
	  Employee a = er.findById(x).get();
	  a.setName(e.getName());
	  a.setGender(e.getGender());
	  a.setSalary(e.getSalary());
	  a.setExperience(e.getExperience());
	  er.save(a);
	  return "Updated successfully";
  }
  
  public String deleteObj(int x) {
	    er.deleteById(x);
		return "Deleted successfully";
	  }
  
 public String updateField(int x, Employee name) {
	  
	  Employee a = er.findById(x).get();
	  a.setName(name.getName());
	  er.save(a);
	  return "Updated successfully";
  }
 //NATIVE QUERY
 public List<Employee> getBtwn(int x, int y){
	 return er.getBtwn(x,y);
 }
 //jQuery
 public List<Employee> getInBtwn(int x, int y){
	 return er.getInBtwn(x,y);
 }
 
 public List<Employee>getString(String x){
	 return er.getString(x);
 }
 
 public List<Employee>getMaxSal(){
	 return er.getMaxSal();
 }
 
 public List<Employee>get2ndMaxSal(){
	 return er.get2ndMaxSal();
 }
 
 public List<Object>groupingByNme(){
	 return er.groupingByNme();
 }
 
 public Employee getEntireObjs(String x) {
	 return er.getEntireObjs(x);
 }
 //Exception
 public List<Employee> getByName(String x) {
	 return er.getByName(x);
 }
 
 public Employee getById(int x) {
	 return er.getById(x);
 }
 
// public Employee get2ndMax () {
//	List<Employee> max2nd = er.findAll(); 
//	max2nd.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
// }
 
}
