package com.mastercard.dxp.Mastercarddxp.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author sarbajeet.singh
 * This is the Template Entity class
 *
 */



@Table(name="Temp")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Template {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Tid;
	private String template_name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "assignedTemplates")
	
	private Set<Module> Moduleset =new HashSet<>();
	
	
}
