package com.desafio.desafio.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@Document(collection = "medicos")
public class Medico {
    @Id
    private String id;
    private String primeiroNome;
    private String segundoNome;
    private String email;
    private boolean ativo;
    private boolean ocupado;
}
