package com.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Entity.Employee;
import com.Employee.Exception.IdNotFoundException;
import com.Employee.Exception.NameNotFoundException;

@Service
public class EmployeeService {
 @Autowired
 EmployeeDAO ed;
 
 public String postObj(Employee e) {
	 return ed.postObj(e);
 }
 
 public String postListOfEmp(List<Employee> e) {
	 return ed.postListOfEmp(e);
 }
 
 public Employee getSingleId(int x) {
	 return ed.getSingleId(x);
 }
 
 public List<Employee> getEntireObj() {
	 return ed.getEntireObj();
 }
 
 public String update(int x, Employee e) {
	 return ed.update(x,e);
 }
 
 public String deleteObj(int x) {
	 return ed.deleteObj(x);
 }
 
 public String updateField(int x, Employee name) {
	 return ed.updateField(x, name);
 }
 //native query
 public List<Employee> getBtwn(int x, int y){
	 return ed.getBtwn(x,y);
 }
 //jQuery
 public List<Employee> getInBtwn(int x, int y){
	 return ed.getInBtwn(x,y);
 }
 
 public List<Employee> getString(String x){
	 return ed.getString(x);
 }
 
 public List<Employee> getMaxSal(){
	 return ed.getMaxSal();
 }
 
 public List<Employee> get2ndMaxSal(){
	 return ed.get2ndMaxSal();
 }
 
 public List<Object> groupingByNme(){
	 return ed.groupingByNme();
 }
 
 public Employee getEntireObjs(String x) {
	 return ed.getEntireObjs(x);
 }
 //Exception
 public List<Employee> getByName(String x) throws NameNotFoundException {
	 if(ed.getByName(x).isEmpty()){
		  throw new NameNotFoundException("The given name is not available");
	 }else {	 	 
	 return ed.getByName(x);
	 }
 }
 
 public Employee getById(int x) throws IdNotFoundException {
	 if(ed.getById(x)==null) {
		 throw new IdNotFoundException("The given id is not available");
	 }else {
		 return ed.getById(x);
	 }
 }
 
// public Employee get2ndMax() {
//	 return ed.get2ndMax();
// }
 
 
 
}
