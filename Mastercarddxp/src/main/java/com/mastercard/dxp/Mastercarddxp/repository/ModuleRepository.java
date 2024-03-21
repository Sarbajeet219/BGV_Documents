package com.mastercard.dxp.Mastercarddxp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mastercard.dxp.Mastercarddxp.entity.Module;

/**
 * 
 * @author sarbajeet.singh
 * This is ModuleRepository class
 *
 */

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
