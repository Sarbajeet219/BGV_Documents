package com.mastercard.dxp.Mastercarddxp.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mastercard.dxp.Mastercarddxp.entity.Template;

import com.mastercard.dxp.Mastercarddxp.repository.TemplateRepository;


/**
 * 
 * @author sarbajeet.singh
 * This is TemplateService class
 *
 */


@Service
public class TemplateService {
	
		
	@Autowired
TemplateRepository temprepo;
	public TemplateService(TemplateRepository temprepo2) {
		this.temprepo=temprepo2;
		
	}

	public List<Template> listAllUserTemplate() {
		
		return temprepo.findAll();
	}

	public Template getUserTemplate(Integer id) {
		return temprepo.findById(id).get();
	}

	public Template saveTemplate(Template temp) {
	return	temprepo.save(temp);
		
	}

	//public void deleteUserTemplate(Integer id) {
		//temprepo.deleteById(id);
		
	//}
	

}
