package br.com.ferry.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class Endereco {

    private Integer id;
    private String rua;
    private String logradouro;
    private String complemento;
    private Integer numero;
}
