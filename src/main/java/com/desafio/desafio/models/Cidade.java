package com.desafio.desafio.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Cidade {
    @Id
    private String id;
    private Estado estado;
    private String nome;
}
