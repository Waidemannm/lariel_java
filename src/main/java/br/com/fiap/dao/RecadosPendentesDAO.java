package br.com.fiap.dao;

import br.com.fiap.to.RecadosPendentesTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecadosPendentesDAO {
    public ArrayList<RecadosPendentesTO> findAll(){
        ArrayList<RecadosPendentesTO> recadosPendentesTO = new ArrayList<>();
        String sql = "SELECT * FROM T_LS_RECADOS_PENDENTES";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                RecadosPendentesTO recadoPendenteTO = new RecadosPendentesTO();
                recadoPendenteTO.setIdRecadoPendente(rs.getLong("ID_RECADO_PENDENTE"));
                recadoPendenteTO.setNomeConvidados(rs.getString("NM_CONVIDADOS"));
                recadoPendenteTO.setMensagem(rs.getString("MENSAGEM"));
                recadosPendentesTO.add(recadoPendenteTO);
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar recados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recadosPendentesTO;
    }

    public RecadosPendentesTO save(RecadosPendentesTO recadosPendentesTO){
        String sql = "INSERT INTO T_LS_RECADOS_PENDENTES (MENSAGEM, NM_CONVIDADOS) VALUES (?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, recadosPendentesTO.getMensagem());
            ps.setString(2, recadosPendentesTO.getNomeConvidados());
            if (ps.executeUpdate() > 0){
                return recadosPendentesTO;
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao salvar recado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long idRecadoPendente){
        String sql = "DELETE FROM T_LS_RECADOS_PENDENTES WHERE ID_RECADO_ACEITO = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, idRecadoPendente);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro ao deletar recado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

}
