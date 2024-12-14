package br.com.ferry.domain.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaHttp {

    private String nome;
    private String razaoSocial;
    private String cnpj;
    private SituacaoCadastral situacaoCadastral;
}
