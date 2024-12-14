package br.com.ferry.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Agencia {

    private Integer id;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
}
