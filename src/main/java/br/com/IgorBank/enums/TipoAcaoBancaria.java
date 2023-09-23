package br.com.IgorBank.enums;

public enum TipoAcaoBancaria {
    DEPOSITO(1L, "Deposito"),
    SAQUE(2L, "Saque"),
    CRIACAO_CONTA(3L, "Criação de conta"),
    FINANCIAMENTO(4L, "Financiamento"),
    APLICACAO(3L, "Aplicação");

    private Long codigo;
    private String acao;

    public String getAcao() {
        return acao;
    }

    public Long getCodigo() {
        return codigo;
    }

    TipoAcaoBancaria(Long codigo, String acao) {
        this.codigo = codigo;
        this.acao = acao;
    }
}
