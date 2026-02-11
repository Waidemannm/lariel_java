package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RecadosAceitosTO {
    private Long idRecadoAceito;
    @Size(max = 1000, message = "A mensagem deve ter no máximo 1000 caracteres")
    private String mensagem;
    @NotBlank
    @Size(max = 300, message = "O nome deve ter no máximo 300 caracteres")
    private String nomeConvidados;

    public RecadosAceitosTO(){

    }

    public RecadosAceitosTO(Long idRecadoPendente, String mensagem, String nomeConvidados) {
        this.idRecadoAceito = idRecadoPendente;
        this.mensagem = mensagem;
        this.nomeConvidados = nomeConvidados;
    }

    public Long getIdRecadoPendente() {
        return idRecadoAceito;
    }

    public void setIdRecadoPendente(Long idRecadoPendente) {
        this.idRecadoAceito = idRecadoPendente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeConvidados() {
        return nomeConvidados;
    }

    public void setNomeConvidados(String nomeConvidados) {
        this.nomeConvidados = nomeConvidados;
    }
}
