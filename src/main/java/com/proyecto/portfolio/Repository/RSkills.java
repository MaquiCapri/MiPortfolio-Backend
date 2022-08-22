
package com.proyecto.portfolio.Repository;

import com.proyecto.portfolio.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer> {
   public Optional<Skills> findByPorcentaje(int porcentaje);
   public boolean existsByPorcentaje(int porcentaje); 
    
}
