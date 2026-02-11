package br.com.fiap.bo;

import br.com.fiap.dao.RecadosPendentesDAO;
import br.com.fiap.to.RecadosPendentesTO;

import java.util.ArrayList;

public class RecadosPendetesBO {

    private RecadosPendentesDAO recadosPendentesDAO;

    public ArrayList<RecadosPendentesTO> findAll(){
        recadosPendentesDAO = new RecadosPendentesDAO();
        return recadosPendentesDAO.findAll();
    }

    public RecadosPendentesTO save(RecadosPendentesTO recadosPendentesTO){
        recadosPendentesDAO = new RecadosPendentesDAO();
        return recadosPendentesDAO.save(recadosPendentesTO);
    }

    public boolean delete(Long idRecadoPendente){
        recadosPendentesDAO = new RecadosPendentesDAO();
        return recadosPendentesDAO.delete(idRecadoPendente);
    }
}
