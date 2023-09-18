package org.example.enums;

import org.example.domain.Aplicacao;

public enum AplicacaoCID {
    MAGAZINELUIZA(0.05),
    PETROBRAS(0.06),
    TESLA(0.1),
    IGOR_ENTERPRISE(2D);

    private Double porcentagemAplicacao;

    AplicacaoCID(Double porcentagemAplicacao){
        this.porcentagemAplicacao = porcentagemAplicacao;
    }

    public Double getPorcentagemAplicacao() {
        return porcentagemAplicacao;
    }
}
