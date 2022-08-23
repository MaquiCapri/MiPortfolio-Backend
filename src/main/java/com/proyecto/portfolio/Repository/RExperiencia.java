
package com.proyecto.portfolio.Repository;

import com.proyecto.portfolio.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//ademas de traer los metodos de jpaR crear dos metodos mas
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
   public Optional<Experiencia> findByFecha(String fecha);
   public boolean existsByFecha(String fecha);
}
