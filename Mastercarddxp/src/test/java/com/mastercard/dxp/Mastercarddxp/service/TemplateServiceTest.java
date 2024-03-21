package com.mastercard.dxp.Mastercarddxp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mastercard.dxp.Mastercarddxp.entity.Template;
import com.mastercard.dxp.Mastercarddxp.repository.TemplateRepository;



@ExtendWith(MockitoExtension.class)

class TemplateServiceTest {
	
	
	
	@Mock
	private TemplateRepository temprepo;
	
	private TemplateService templateservice;




	@BeforeEach
	void setUp() throws Exception {
		
		
		this.templateservice=new TemplateService(this.temprepo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListAllUserTemplate() {
		templateservice.listAllUserTemplate();
		verify(temprepo).findAll();
	}

	@Test
	void testGetUserTemplate() {
		Template temp2=new Template();
		temp2.setTid(1);
		temp2.setTemplate_name("new userTemplate");
		when(temprepo.findById(1)).thenReturn(java.util.Optional.of(temp2));
		assertEquals("new userTemplate",templateservice.getUserTemplate(1).getTemplate_name());
	}

	@Test
	void testSaveTemplate() {
		Template temp=new Template();
		temp.setTid(1);
		temp.setTemplate_name("new Template");
		when(temprepo.save(temp)).thenReturn(temp);
		assertEquals(temp, templateservice.saveTemplate(temp));
		
		
		
		
	}

//	@Test
//	void testDeleteUserTemplate() {
//		fail("Not yet implemented");
//	}

}
