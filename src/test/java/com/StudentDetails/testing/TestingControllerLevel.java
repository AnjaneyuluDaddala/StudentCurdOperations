package com.StudentDetails.testing;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.StudentDetails.Controller.StudentController;
import com.StudentDetails.Entity.Student;
import com.StudentDetails.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StudentController.class)
public class TestingControllerLevel {
	
	@MockBean
	StudentServiceImpl stdservImpl;
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objMapper;
	
	private Student student;
	
	//first MockMvc
	//perform post,get
	//response.andExcept(status.iscreated()) at last
	
	public void init() {
		student=new Student(12L,"likitha","java","mahalakshmi");
	}
	

    @Test
    public void testSaveData() throws Exception {
    	
        when(stdservImpl.saveStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/student/save")
                .param("stdid", "12")
                .param("stdName", "likitha")
                .param("course", "java")
                .param("parentName", "mahalakshmi"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("data is saved"));

        verify(stdservImpl).saveStudent(any(Student.class));
    }
	
	
	/*
	
	  @Test
	    public void test_saveContact() throws Exception {
	         Contact contact = new Contact(100L,"Lipsa","Patra","lipsa@gmail.com","123456");
	         when(contactService.saveContact(contact)).thenReturn(contact);
	         mockMvc.perform(post("/contact")
	                 .contentType(MediaType.APPLICATION_JSON)
	                 .content(new ObjectMapper().writeValueAsString(contact)))
	                 .andExpect(status().isOk());

	     }
	    @Test
	    public void test_getContactById() throws Exception {
	        Contact contact = new Contact(100L,"Lipsa","Patra","lipsa@gmail.com","123456");
	        when(contactService.getContactById(100L)).thenReturn(contact);
	        mockMvc.perform(get("/contact/{id}",100L)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	               .andExpect(jsonPath("$.firstName").value("Lipsa"));
	    }

	    @Test
	    public  void test_getContactList() throws Exception {
	        List<Contact> contactList = Arrays.asList(new Contact(100L, "Lipsa", "Patra", "lipsa@gmail.com", "123456"),
	                new Contact(101L, "Robert", "Frost", "robert@gmail.com", "56789"));

	        when(contactService.getContactList()).thenReturn(contactList);
	        mockMvc.perform(get("/contacts")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$[0].firstName").value("Lipsa"));


	    }

	    @Test
	    public void test_deleteContact() throws Exception {
	        Contact contact = new Contact(100L,"Lipsa","Patra","lipsa@gmail.com","123456");
	        doNothing().when(contactService).deleteContact(contact);
	        mockMvc.perform(delete("/contact")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(contact)))
	                .andExpect(status().isOk());


	    }
*/
}
