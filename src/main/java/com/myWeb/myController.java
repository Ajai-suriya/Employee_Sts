package com.myWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
	
	@GetMapping(value="/get")
	public String getThis() {
		return "Hello world";
	}
	
	@GetMapping(value = "/name")
	public String getName() {
		return "Ajai suriya";
	}
	
	@GetMapping(value = "getgreetings/{x}")
	public 	String getGreetings(@PathVariable String x) {
		return x + " Ajai";
	}
	
	@GetMapping(value = "getMax/{x}/{y}")
	public String getMax(@PathVariable int x, @PathVariable int y ) {
		if(x>y) {
			return x + " is greater";
		}else {
			return y + " is greater";
		}
	}
	
	@GetMapping(value = "primeNumber/{x}/{y}")
	public List<Integer> getPrime(@PathVariable int x, @PathVariable int y) {
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=x; i<y; i++) {
			boolean isPrime = true;
		 for(int j=2; j<i; j++) {
			 if(i%j==0) {
				isPrime = false; 
			 }
		 }
		 if(isPrime==true) {
			 a.add(i);
		 }
		}
		return a;
	}
	
	@GetMapping(value = "Access")
	public String getAccess(@RequestParam String userName, @RequestParam String userPassword) {
	   if(userName.equals("Bristol") && userPassword.equals("onesoft")) {
		   return "Login Successful";
	   }else {
		   return "Login Failed";
	   }
	}
	
	@GetMapping(value = "vote/{x}")
	public String eligibligty(@PathVariable int x) {
		if(x>=18) {
			return "Eligible";
		}else {
			return "Not Eligible";
		}
	}
	
	@GetMapping(value = "getObject")
	public mobile getObject(@RequestBody mobile m) {
		return m;
	}
	//printing list of objects
	@GetMapping(value = "getListObj")
	public List<mobile> getList(@RequestBody List<mobile> m){
		return  m;
	}
	
	@GetMapping(value = "getMaxObj/{a}")
	public List<mobile> getMaxObj(@RequestBody List<mobile> m, @PathVariable String a){
		return m.stream().filter(x->x.getBrand().equalsIgnoreCase(a)).collect(Collectors.toList());
	}

	@GetMapping(value = "getinbtwn/{a}/{b}")
	public List<mobile>getInbetween(@RequestBody List<mobile> m, @PathVariable int a, @PathVariable int b){
		return m.stream().filter(x->x.getPrice()>a && x.getPrice()<b).collect(Collectors.toList());
	}
	//2nd max
	@GetMapping(value = "get2ndMax")
	public mobile get2ndMax(@RequestBody List<mobile> m){
		return m.stream().sorted(Comparator.comparing(mobile::getPrice).reversed()).skip(1).findFirst().get();
	}
	
	@GetMapping(value = "getLastChar/{a}")
	public List<Character> getLastChar(@RequestBody List<mobile> m, @PathVariable String a) {
		return m.stream().filter(x->x.getBrand().toLowerCase().startsWith(a.toLowerCase())).map(x->x.getBrand().charAt(x.getBrand().length()-1)).collect(Collectors.toList());
	}
	
	
}
