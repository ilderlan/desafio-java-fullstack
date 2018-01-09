package com.desafio.desafio.services;

import java.util.List;

public interface BaseService<T, I> {

    T buscar(I id);

    List<T> listar() ;

    T salvar(T entity) ;

    T editar(I id, T entity);

    void remover(I id) ;

}