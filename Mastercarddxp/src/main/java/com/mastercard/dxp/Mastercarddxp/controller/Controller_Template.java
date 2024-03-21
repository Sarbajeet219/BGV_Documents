package com.mastercard.dxp.Mastercarddxp.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mastercard.dxp.Mastercarddxp.entity.Template;
import com.mastercard.dxp.Mastercarddxp.service.TemplateService;

/**
 * 
 * @author sarbajeet.singh
 * This is the Template_controller class
 *
 */


@RestController
@RequestMapping("/template")
public class Controller_Template{
	@Autowired
	TemplateService TempService;
	@GetMapping("/Showing")
    public List<Template> listmodule() {
        return TempService.listAllUserTemplate();
    }
	@GetMapping("/{id}")
    public ResponseEntity<Template> get(@PathVariable Integer id) {
       // try {
            Template temp =TempService.getUserTemplate(id);
            return new ResponseEntity<Template>(temp, HttpStatus.OK);
        //} catch (NoSuchElementException e) {
        	
        //    return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
           
       // }
    }
	@PostMapping("/posting")
    public String adding(@RequestBody Template temp) {
		TempService.saveTemplate(temp);
		return "Successfully added";
        
    }
	//@DeleteMapping("/{id}")
    //public void delete(@PathVariable Integer id) {

		//TempService.deleteUserTemplate(id);
    //}
	
		
    }