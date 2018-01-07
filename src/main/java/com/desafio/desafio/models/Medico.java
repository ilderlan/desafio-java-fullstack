package com.desafio.desafio.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Medico {
    private String id;
    private String primeiroNome;
    private String segundoNome;
    private String email;
    private boolean ativo;
    private boolean ocupado;
}
