package br.com.fiap.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RecadosAceitosTO {
    private Long idRecadoAceito;
    @Size(max = 1000, message = "A mensagem deve ter no máximo 1000 caracteres")
    private String mensagem;
    @NotBlank
    @Size(max = 300, message = "O nome deve ter no máximo 300 caracteres")
    private String nomeConvidados;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataMensagem;

    public RecadosAceitosTO(){

    }

    public RecadosAceitosTO(Long idRecadoAcetio, String mensagem, String nomeConvidados, LocalDate dataMensagem) {
        this.idRecadoAceito = idRecadoAcetio;
        this.mensagem = mensagem;
        this.nomeConvidados = nomeConvidados;
        this.dataMensagem = dataMensagem;
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

    public LocalDate getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(LocalDate dataMensagem) {
        this.dataMensagem = dataMensagem;
    }
}
