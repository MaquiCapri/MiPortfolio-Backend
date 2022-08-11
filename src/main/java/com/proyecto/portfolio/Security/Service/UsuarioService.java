
package com.proyecto.portfolio.Security.Service;

import com.proyecto.portfolio.Security.Entity.Usuario;
import com.proyecto.portfolio.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    //va a comprobar si el nombre de usuario ya existe
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
       //si el email ya existe
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    //guarda un usuario nuevo
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
    
}
