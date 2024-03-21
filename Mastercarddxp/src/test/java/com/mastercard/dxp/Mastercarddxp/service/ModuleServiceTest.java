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
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mastercard.dxp.Mastercarddxp.entity.Module;
import com.mastercard.dxp.Mastercarddxp.repository.ModuleRepository;



@ExtendWith(MockitoExtension.class)
class ModuleServiceTest {

	@Mock
	private ModuleRepository modurepo;
	
	
	private ModuleService moduleservice;
	

	@BeforeEach
	void setUp() throws Exception {
		this.moduleservice=new ModuleService(this.modurepo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListAllUserModule() {

		moduleservice.listAllUserModule();
		verify(modurepo).findAll();
		
	}

	@Test
	void testSaveModule() {
	Module module1=new Module();
	module1.setMid(1);
	module1.setModule_Name("NewUser Module");
	when(modurepo.save(module1)).thenReturn(module1);
	assertEquals(module1,moduleservice.saveModule(module1));
		
	}

	@Test
	void testGetUserModule() {
		Module module2=new Module();
		module2.setModule_Name("New Module");
		module2.setMid(1);
		when(modurepo.findById(1)).thenReturn(java.util.Optional.of(module2));
		assertEquals("New Module",moduleservice.getUserModule(1).getModule_Name());
	}


}
