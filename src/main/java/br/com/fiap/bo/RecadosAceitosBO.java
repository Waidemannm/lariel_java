package br.com.fiap.bo;

import br.com.fiap.dao.RecadosAceitosDAO;
import br.com.fiap.to.RecadosAceitosTO;

import java.util.ArrayList;

public class RecadosAceitosBO {

    private RecadosAceitosDAO recadosAceitosDAO;

    public ArrayList<RecadosAceitosTO> findAll(){
        recadosAceitosDAO = new RecadosAceitosDAO();
        return recadosAceitosDAO.findAll();
    }

    public RecadosAceitosTO save(RecadosAceitosTO recadosAceitosTO){
        recadosAceitosDAO = new RecadosAceitosDAO();
        return recadosAceitosDAO.save(recadosAceitosTO);
    }

    public boolean delete(Long idRecadoAceito){
        recadosAceitosDAO = new RecadosAceitosDAO();
        return recadosAceitosDAO.delete(idRecadoAceito);
    }
}
