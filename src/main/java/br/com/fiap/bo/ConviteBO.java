package br.com.fiap.bo;

import br.com.fiap.dao.ConviteDAO;
import br.com.fiap.to.ConviteTO;

import java.util.ArrayList;

public class ConviteBO {

    private ConviteDAO conviteDAO;

    public ArrayList<ConviteTO> findAll(){
        conviteDAO = new ConviteDAO();
        return conviteDAO.findAll();
    }

    public ConviteTO save(ConviteTO conviteTO){
        conviteDAO = new ConviteDAO();
        return conviteDAO.save(conviteTO);
    }

    public ConviteTO findConvite(String nomeConvite, String idConvite){
        conviteDAO = new ConviteDAO();
        return conviteDAO.findConvite(nomeConvite, idConvite);
    }

    public boolean delete(String idConvite){
        conviteDAO = new ConviteDAO();
        return conviteDAO.delete(idConvite);
    }

    public ConviteTO update(ConviteTO conviteTO){
        conviteDAO = new ConviteDAO();
        return conviteDAO.update(conviteTO);
    }

    public ConviteTO findConviteADM(String nomeConvite){
        conviteDAO = new ConviteDAO();
        return conviteDAO.findConviteADM(nomeConvite);
    }
}
