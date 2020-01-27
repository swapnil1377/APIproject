package com.cjc.NEW.API.Servicelayer;

import java.util.List;

import com.cjc.NEW.API.model.Student;

public interface InterfaceService 
{
    public Student saveAllData(Student s);
    
	public List<Student>getAllData();
	
	public void saveList(List<Student> slist);
	
	public List<Student> DeleteData(int id);
	
	public Student editData(int id);
	
	public List<Student> UpdateData(Student s);
	
	public int getSingleData(int id);
}
