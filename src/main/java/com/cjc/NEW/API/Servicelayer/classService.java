package com.cjc.NEW.API.Servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.NEW.API.Utility.DataJPAInterface;
import com.cjc.NEW.API.model.Student;

@Service
public class classService implements InterfaceService
{
	@Autowired
	DataJPAInterface jp;
	
	
	
	@Override
	public Student saveAllData(Student s) {
	
		return jp.save(s);
		
	}



	@Override
	public List<Student> getAllData() {
		
	List<Student>l=(List<Student>) jp.findAll();
		return l;
	}



	@Override
	public void saveList(List<Student> slist) {
		jp.saveAll(slist);
		
	}



	@Override
	public List<Student> DeleteData(int id) {
		
		jp.deleteById(id);
		List<Student>liss=(List<Student>) jp.findAll();
		return liss;
	}



	@Override
	public Student editData(int id) {
		
		return jp.findById(id).get();
	}



	@Override
	public List<Student> UpdateData(Student s) {
	    jp.save(s);
	   
		return  (List<Student>) jp.findAll();
	}



	@Override
	public int getSingleData(int id) {
		
		jp.findById(id);
		return id;
	}

}
