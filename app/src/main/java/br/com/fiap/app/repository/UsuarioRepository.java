package br.com.fiap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    
}
