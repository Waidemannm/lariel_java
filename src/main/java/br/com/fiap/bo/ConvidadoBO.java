package br.com.fiap.bo;

import br.com.fiap.dao.ConvidadoDAO;
import br.com.fiap.to.ConvidadoTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConvidadoBO {

    private ConvidadoDAO convidadoDAO;

    public ArrayList<ConvidadoTO> findAll(){
        convidadoDAO = new ConvidadoDAO();
        return  convidadoDAO.findAll();
    }

    public ConvidadoTO save(ConvidadoTO convidadoTO){
        convidadoDAO = new ConvidadoDAO();
        String status = convidadoTO.getStatus().trim().toUpperCase();
        List<String> tiposStatus = List.of("C", "P", "A");
        if (!tiposStatus.contains(status)){
            throw new RuntimeException("Tipo de status inválido. Valores aceitos: " + tiposStatus);
        }
        return convidadoDAO.save(convidadoTO);
    }

    public ConvidadoTO findByName(String nomeConvidado){
        convidadoDAO = new ConvidadoDAO();
        return  convidadoDAO.findByName(nomeConvidado);
    }

    public boolean delete(Long idConvidado){
        convidadoDAO = new ConvidadoDAO();
        return convidadoDAO.delete(idConvidado);
    }

    public ConvidadoTO update(ConvidadoTO convidadoTO){
        convidadoDAO = new ConvidadoDAO();
        String status = convidadoTO.getStatus().trim().toUpperCase();
        List<String> tiposStatus = List.of("C", "P", "A");
        if (!tiposStatus.contains(status)){
            throw new RuntimeException("Tipo de status inválido. Valores aceitos: " + tiposStatus);
        }
        return convidadoDAO.update(convidadoTO);
    }

    public ConvidadoTO updateStatus(ConvidadoTO convidadoTO){
        convidadoDAO = new ConvidadoDAO();
        String status = convidadoTO.getStatus().trim().toUpperCase();
        List<String> tiposStatus = List.of("C", "P", "A");
        if (!tiposStatus.contains(status)){
            throw new RuntimeException("Tipo de status inválido. Valores aceitos: " + tiposStatus);
        }
        return convidadoDAO.updateStatus(convidadoTO);
    }

    public ArrayList<ConvidadoTO> findByIdConvite(String idConvite){
        System.out.println("BO idConvite=" + idConvite);
        convidadoDAO = new ConvidadoDAO();
        return  convidadoDAO.findByIdConvite(idConvite);
    }
}
