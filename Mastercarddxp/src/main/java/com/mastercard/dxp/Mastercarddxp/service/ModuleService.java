package com.mastercard.dxp.Mastercarddxp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mastercard.dxp.Mastercarddxp.entity.Module;
import com.mastercard.dxp.Mastercarddxp.repository.ModuleRepository;
import com.mastercard.dxp.Mastercarddxp.repository.TemplateRepository;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author sarbajeet.singh
 * This is ModuleService class
 *
 */


@Service
public class ModuleService {
	@Autowired
    private ModuleRepository userRepository;
	
	@Autowired
	private TemplateRepository tempRepository;
	
	
	public ModuleService(ModuleRepository modurepo) {
		
		this.userRepository=modurepo;
		
	}
	public List<Module> listAllUserModule() {
        return userRepository.findAll();
    }
	public Module saveModule(Module user) {
        return userRepository.save(user);
    }
    public Module getUserModule(Integer id) {
        return userRepository.findById(id).get();
    }
    
	//public void deleteUserModule(Integer id) {	
		//userRepository.deleteById(id);
		
	//}
	
	//public Module assignTemplateToModule(Integer mid, Integer Tid) {
		
		//Set<com.mastercard.dxp.Mastercarddxp.entity.Template> templateSet=null;
		//Module module=userRepository.findById(mid).get();
		//com.mastercard.dxp.Mastercarddxp.entity.Template template=tempRepository.findById(Tid).get();
		//templateSet=module.getAssignedTemplates();
		//templateSet.add(template);
		//module.setAssignedTemplates(templateSet);
	    //return userRepository.save(module);
		
		
		
//	}
	
}
