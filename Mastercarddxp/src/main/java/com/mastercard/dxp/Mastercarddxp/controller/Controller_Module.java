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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mastercard.dxp.Mastercarddxp.entity.Module;
import com.mastercard.dxp.Mastercarddxp.repository.ModuleRepository;
import com.mastercard.dxp.Mastercarddxp.service.ModuleService;

/**
 * 
 * @author sarbajeet.singh
 * This is the Module_controller class
 *
 */


@RestController
@RequestMapping("/module")
public class Controller_Module{
	@Autowired
	ModuleService userService;
	
	
	@GetMapping("/Show")
    public List<Module> listmodule() {
        return userService.listAllUserModule();
    }
	@GetMapping("/{id}")
    public ResponseEntity<Module> get(@PathVariable Integer id) {
        //try {
            Module user = userService.getUserModule(id);
            return new ResponseEntity<Module>(user, HttpStatus.OK);
     //   } catch (NoSuchElementException e) {
        	
          //  return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
           
     //   }
    }
	@PostMapping("/Add")
    public String add(@RequestBody Module user) {
        userService.saveModule(user);
		return "Successfully added";
        
    }
	//@DeleteMapping("/{id}")
    //public void delete(@PathVariable Integer id) {

      //  userService.deleteUserModule(id);
    //}
	
	
	//@PutMapping("/{mid}/mapping/{Tid}")
//public Module assignTemplateToModule(
		//@PathVariable Integer mid,
		//@PathVariable Integer Tid)
//{
	//return userService.assignTemplateToModule(mid,Tid);
		
//}
 }
	

