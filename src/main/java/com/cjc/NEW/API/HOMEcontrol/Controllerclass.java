package com.cjc.NEW.API.HOMEcontrol;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.NEW.API.Servicelayer.InterfaceService;
import com.cjc.NEW.API.model.Student;

@RestController
public class Controllerclass {
	
	@Autowired
	InterfaceService is;
	
	/*
	 * @Autowired Student stu;
	 */
	
	HashMap<Integer, Student>m=new HashMap<>();

	@RequestMapping("/")
	public String Check()
	{
		return "Ok......Entre";
	}
	
	@PostMapping("/students")
	public String saveData(@RequestBody Student s )
	{
		is.saveAllData(s);
		return "Data______Saved";
	
	}
	
	@PostMapping("/savelist")
	public String saveList(@RequestBody List<Student> listt )
	{
		
		is.saveList(listt);
		return "List______Saved";
	
	}
	
	
	@GetMapping(value = "/datalist")
	public List<Student>getALLdata()
	{
	List<Student>list=is.getAllData();
		return list;		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public List<Student>getData(@PathVariable int id)
	{
		is.DeleteData(id);
		List<Student>lis=is.getAllData();
		return lis;
		
	}	
	
	@RequestMapping(value = "/edit/{id}",method =RequestMethod.GET)
	public Student Editdata(@PathVariable int id)
	{
		
		return is.editData(id);
		
	}
	
	@RequestMapping(value = "/update/{id}",method =RequestMethod.PUT )
	public Student updateData(@RequestBody Student s1,@PathVariable int id)
	{
		Student stu=new Student();
		Integer i=is.getSingleData(id);
		if(i!=null)
		{
			stu.setId(i);
			stu.setName(s1.getName());
			stu.setCity(s1.getCity());
			return is.saveAllData(stu);
		}
		else
		{
		
			return null;
		}
		
	}
	
	
}
