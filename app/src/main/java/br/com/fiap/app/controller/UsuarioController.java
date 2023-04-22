package br.com.fiap.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.app.model.Usuario;
import br.com.fiap.app.repository.UsuarioRepository;
import lombok.var;

@RequestMapping("/docker")
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public List<Usuario> home(){
        return repository.findAll();
    }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario u){
        repository.save(u);

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable long id){

        var usuario = repository.findById(id);

        if(usuario.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(usuario.get());

        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario u, @PathVariable long id){
        var usuario = repository.findById(id);

        if(usuario.isEmpty()) return ResponseEntity.notFound().build();

        repository.save(u);

        return ResponseEntity.ok().body(u);
    }
}
