package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ConviteTO {
    @NotBlank
    @Size(max = 7, message = "O id do convite deve ter no máximo 7 caracteres")
    private String idConvite;
    @NotBlank(message = "O nome do convite é obrigatório")
    @Size(max = 300, message = "O nome do convite deve ter no máximo 300 caracteres")
    private String nomeConvite;


    public ConviteTO(){}

    public ConviteTO(String idConvite, String nomeConvite) {
        this.idConvite = idConvite;
        this.nomeConvite = nomeConvite;
    }

    public String getIdConvite() {
        return idConvite;
    }

    public void setIdConvite(String idConvite) {
        this.idConvite = idConvite;
    }

    public String getNomeConvite() {
        return nomeConvite;
    }

    public void setNomeConvite(String nomeConvite) {
        this.nomeConvite = nomeConvite;
    }
}
