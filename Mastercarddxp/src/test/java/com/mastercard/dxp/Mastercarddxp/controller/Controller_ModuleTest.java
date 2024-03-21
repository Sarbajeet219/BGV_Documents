package com.mastercard.dxp.Mastercarddxp.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

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
import com.mastercard.dxp.Mastercarddxp.entity.Module;

import com.mastercard.dxp.Mastercarddxp.service.ModuleService;


@WebMvcTest(Controller_Module.class)
class Controller_ModuleTest {

	
	 @MockBean
	 ModuleService moduleService;
	    
	    @Autowired
	    MockMvc mockMvc;
	
	    private Module frontend;
	    private Module backend;
	    
 

 

	@BeforeEach
	void init()   {
		frontend = new Module();
		frontend.setMid(1);
		frontend.setModule_Name("newModule");
		
		backend =new Module();
		backend.setMid(2);
		backend.setModule_Name("newModule2");
		
	}

	 

	@Test
	void testListmodule() throws Exception {
		
		List<Module> list = new ArrayList<>();
		list.add(frontend);
		list.add(backend);
		
		when(moduleService.listAllUserModule()).thenReturn(list);
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/module/Show"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", is(list.size())));
		
		
	}

	@Test
	void testget()throws Exception {
	
		 when(moduleService.getUserModule(1)).thenReturn(frontend);
	        mockMvc.perform(MockMvcRequestBuilders.get("/module/{id}",1)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	               .andExpect(MockMvcResultMatchers.jsonPath("$.module_Name").value("newModule"));
		
		
	}

	
	@Test
	void testadd() throws JsonProcessingException, Exception{
		
		when(moduleService.saveModule( frontend)).thenReturn(frontend);
        mockMvc.perform(MockMvcRequestBuilders.post("/module/Add")
      		  .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(frontend)))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	}


