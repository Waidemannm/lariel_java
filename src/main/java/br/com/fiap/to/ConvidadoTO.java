package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ConvidadoTO {
    private Long idConvidado;
    @Size(max = 7, message = "O id do convite deve ter no máximo 7 caracteres")
    private String idConvite;
    @NotBlank(message = "O nome do convidado é obrigatório")
    private String nomeConvidado;
    @NotBlank(message = "O status é obrigatório")
    private String status;

    public ConvidadoTO(){}

    public ConvidadoTO(Long idConvidado, String idConvite, String nomeConvidado, String status) {
        this.idConvidado = idConvidado;
        this.idConvite = idConvite;
        this.nomeConvidado = nomeConvidado;
        this.status = status;
    }

    public Long getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(Long idConvidado) {
        this.idConvidado = idConvidado;
    }

    public String getIdConvite() {
        return idConvite;
    }

    public void setIdConvite(String idConvite) {
        this.idConvite = idConvite;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
