package com.mastercard.dxp.Mastercarddxp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mastercard.dxp.Mastercarddxp.entity.Template;

import com.mastercard.dxp.Mastercarddxp.service.TemplateService;

@WebMvcTest(Controller_Template.class)
class Controller_TemplateTest {

	
	 @MockBean
	 TemplateService templateService;
	    
	    @Autowired
	    MockMvc mockMvc;
	
	    private  Template frontend;
	    private Template backend;
	
	
	
	
	
	
	@BeforeEach
	void init()   {
		frontend = new Template();
		frontend.setTid(1);
		frontend.setTemplate_name("newTemplate");
		
		backend =new Template();
		backend.setTid(2);
		backend.setTemplate_name("newModule2");
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListmodule() throws Exception {
		List<Template> list = new ArrayList<>();
		list.add(frontend);
		list.add(backend);
		
		when(templateService.listAllUserTemplate()).thenReturn(list);
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/template/Showing"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", is(list.size())));
	}

	@Test
	void testGet() throws Exception {
		 when(templateService.getUserTemplate(1)).thenReturn(frontend);
	        mockMvc.perform(MockMvcRequestBuilders.get("/template/{id}",1)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.template_name").value("newTemplate"));
			
			
		}

	@Test
	void testAdding() throws JsonProcessingException, Exception {
		when(templateService.saveTemplate( frontend)).thenReturn(frontend);
        mockMvc.perform(MockMvcRequestBuilders.post("/template/posting")
      		  .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(frontend)))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}

}
