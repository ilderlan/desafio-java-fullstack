package com.desafio.desafio.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Estado {
    @Id
    private String id;
    private String nome;
    private String sigla;
}
