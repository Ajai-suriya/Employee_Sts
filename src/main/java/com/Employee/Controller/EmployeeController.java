package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Exception.IdNotFoundException;
import com.Employee.Exception.NameNotFoundException;
import com.Employee.Service.EmployeeService;

@RestController
public class EmployeeController {
 @Autowired
 EmployeeService es;
 @PostMapping(value = "/postSingleObj")
 public String postObj(@RequestBody Employee e) {
	 return es.postObj(e);
 }
 
 @PostMapping(value = "postListOfEmployee")
 public String postListOfEmp(@RequestBody List<Employee> e) {
	 return es.postListOfEmp(e);
 }
 
 @PostMapping(value = "getSingleID/{x}")
 public Employee getSingleId(@PathVariable int x) {
	 return es.getSingleId(x);
 }
 
 @PostMapping(value = "getEntireObj")
 public List<Employee> getEntireObj() {
	 return es.getEntireObj();
 }
 
 @PutMapping(value = "updateObj/{x}")
 public String update(@PathVariable int x, @RequestBody Employee e) {
	 return es.update(x,e);
 }
 
 @DeleteMapping(value = "deleteobj/{x}")
 public String deleteObj(@PathVariable int x) {
	 return es.deleteObj(x);
 }
 
 @PatchMapping(value = "updateFields/{x}")
 public String updateField(@PathVariable int x, @RequestBody Employee name) {
	 return es.updateField(x, name);
 }
 //native query
 @GetMapping(value = "/getBetween/{x}/{y}")
 public List<Employee> getBtwn(@PathVariable int x, @PathVariable int y){
	 return es.getBtwn(x,y);
 }
 //JQuery
 @GetMapping(value = "/getInBtwn/{x}/{y}")
 public List<Employee> getInBtwn(@PathVariable int x, @PathVariable int y){
	 return es.getInBtwn(x,y);
 }
 
 @GetMapping(value = "/getString/{x}")
 public List<Employee> getString(@PathVariable String x){
	 return es.getString(x);
 }
 
 @GetMapping(value = "/getMaxSal")
 public List<Employee> getMaxSal(){
	 return es.getMaxSal();
 } 
 
 @GetMapping(value = "/get2ndMaxSal")
 public List<Employee> get2ndMaxSal(){
	 return es.get2ndMaxSal();
 }
 
 @GetMapping(value = "/groupingByNme")
 public List<Object> groupingByNme(){
	 return es.groupingByNme();
 }
 
 @GetMapping(value = "getEntireObjs/{x}")
 public Employee getEntireObjs(@PathVariable String x) {
	 return es.getEntireObjs(x);
 }
 //Exception
 @GetMapping(value = "/getByName/{x}")
 public List<Employee> getByName(@PathVariable String x) throws NameNotFoundException {
	 return es.getByName(x);
 }
 
 @GetMapping(value = "/getById/{x}")
 public Employee getById(@PathVariable int x) throws IdNotFoundException {
	 return es.getById(x);
 }
 
// @GetMapping(value = "/get2ndMax")
// public Employee get2ndMax() {
//	 return es.get2ndMax();
// }
 
 
 
}
