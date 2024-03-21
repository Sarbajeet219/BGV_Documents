package com.mastercard.dxp.Mastercarddxp.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author sarbajeet.singh
 * This is the Module Entity class
 *
 */



@Table
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;
	private String module_Name;	
	
	@ManyToMany
	@JoinTable(name="module_template",
	joinColumns = @JoinColumn(name="module_id"),
	inverseJoinColumns = @JoinColumn(name="template_id"))
	
	
	private Set<Template> assignedTemplates= new HashSet<>();
	
	
	
}
