package com.desafio.desafio.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseResource<T, I> {

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    ResponseEntity<T> buscar(@PathVariable("id") I id) ;

    @GetMapping
    ResponseEntity<List<T>> listar() ;

    @PostMapping
    ResponseEntity<T> salvar(@RequestBody @Valid T resource) ;

    @PutMapping("{id}")
    ResponseEntity<T> editar(@PathVariable("id") I id, @RequestBody @Valid T resource) ;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void remover(@PathVariable("id") I id);
}
