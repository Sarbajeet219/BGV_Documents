package com.mastercard.dxp.Mastercarddxp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mastercard.dxp.Mastercarddxp.entity.Template;

/**
 * 
 * @author sarbajeet.singh
 * This is TemplateRepository class
 *
 */

@Repository
public interface TemplateRepository extends JpaRepository<Template, Integer>{

}
