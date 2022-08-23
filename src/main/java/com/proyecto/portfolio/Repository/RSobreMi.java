
package com.proyecto.portfolio.Repository;

import com.proyecto.portfolio.Entity.SobreMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
//ademas de traer los metodos de jpaR crear dos metodos mas
 public interface RSobreMi extends JpaRepository<SobreMi, Integer> {
   public Optional<SobreMi> findByPerfil(String perfil);
   public boolean existsByPerfil(String perfil);
}

