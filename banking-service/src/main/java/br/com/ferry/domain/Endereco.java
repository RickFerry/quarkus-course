package br.com.ferry.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String logradouro;
    private String complemento;
    private Integer numero;
}
