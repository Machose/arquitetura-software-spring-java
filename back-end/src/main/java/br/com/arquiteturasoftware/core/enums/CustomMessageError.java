package br.com.arquiteturasoftware.core.enums;

public enum CustomMessageError {

    NOT_FOUND("Nenhum registro encontrado"),
    BAD_REQUEST("Erro no envio de dados");

    private String descricao;

    CustomMessageError(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
