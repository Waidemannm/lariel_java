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
    private byte[] imagem;

    public RecadosAceitosTO(){

    }

    public RecadosAceitosTO(Long idRecadoAcetio, String mensagem, String nomeConvidados, byte[] imagem) {
        this.idRecadoAceito = idRecadoAcetio;
        this.mensagem = mensagem;
        this.nomeConvidados = nomeConvidados;
        this.imagem = imagem;
    }

    public Long getIdRecadoAceito() {
        return idRecadoAceito;
    }

    public void setIdRecadoAceito(Long idRecadoAceito) {
        this.idRecadoAceito = idRecadoAceito;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
