package com.StudentDetails.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.repository.StudentRepostiory;
import com.StudentDetails.service.StudentServiceImpl;

@SpringBootTest
public class TestingMockingService {
	
	@MockBean
	StudentRepostiory studentRepo;
	
	@Autowired
	StudentServiceImpl stdServiceImpl;
	
	
	@Test
	public void test_saveData() {
		//mocking obj
		Student std=new Student(12L,"likitha","java","mahalakshmi");
		when(studentRepo.save(std)).thenReturn(std);
		//first actual value and second one is expected value.
		assertEquals(std, stdServiceImpl.saveStudent(std));
		
	}
	@Test
	public void test_findByStudentId() {
		/*mocking object*/
		Student std=new Student(12L,"likitha","java","mahalakshmi");
		when(studentRepo.findById(12L)).thenReturn(Optional.of(std));
		assertEquals("likitha", stdServiceImpl.findByStudentId(12L).getStudentName());
	}
	
	@Test
	public void test_getAllStudents() {
		/*
		Student std1=new Student(12L,"likitha","java","mahalakshmi");
		Student std2=new Student(10L,"prasanna","reactjs","ranjitha");
		
        List<Student> stdList = Arrays.asList(std1);
		
		 List<Student> stdList =new ArrayList<>();
		 stdList.add(std1);
		 stdList.add(std2);
*/
	    List<Student> stdList = Arrays.asList(new Student(100L,"likitha","java","mahalakshmi"),
	                new Student(101L,"prasanna","reactjs","ranjitha"));
        when(studentRepo.findAll()).thenReturn(stdList);

        assertEquals(2, stdServiceImpl.getData().size());
		
	}
	@Test
	public void test_removeStudent() {
		
		Student std=new Student(12L,"likitha","java","mahalakshmi");
		stdServiceImpl.removedata(12L);
		verify(studentRepo,times(1)).deleteById(std.getStudentid());
		
	}	
	@Test
	public void test_updateStudent() {
	    Student existingStudent = new Student(12L, "likitha", "java", "mahalakshmi");
	    Student updatedStudent = new Student(12L, "likitha_updated", "spring", "mahalakshmi_updated");
	    
	    // Mocking the repository to return the existing student
	    when(studentRepo.findById(existingStudent.getStudentid())).thenReturn(Optional.of(existingStudent));
	    // Mocking the save operation
	    when(studentRepo.save(existingStudent)).thenReturn(existingStudent);
	    
	    Student result = stdServiceImpl.updateStudent(updatedStudent);
	    
	    // Verify the fields are updated correctly
	    assertEquals(updatedStudent.getStudentid(), result.getStudentid());
	    assertEquals(updatedStudent.getCourse(), result.getCourse());
	    assertEquals(updatedStudent.getParentName(), result.getParentName());
	    assertEquals(updatedStudent.getStudentName(), result.getStudentName());
	}

	

}
