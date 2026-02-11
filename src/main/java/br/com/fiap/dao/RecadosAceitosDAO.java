package br.com.fiap.dao;

import br.com.fiap.to.RecadosAceitosTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecadosAceitosDAO {
    public ArrayList<RecadosAceitosTO> findAll(){
        ArrayList<RecadosAceitosTO> recadosPendentesTO = new ArrayList<>();
        String sql = "SELECT * FROM T_LS_RECADOS_ACEITOS";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                RecadosAceitosTO recadoPendenteTO = new RecadosAceitosTO();
                recadoPendenteTO.setIdRecadoPendente(rs.getLong("ID_RECADO_ACEITO"));
                recadoPendenteTO.setNomeConvidados(rs.getString("NOME_CONVIDADOS"));
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

    public RecadosAceitosTO save(RecadosAceitosTO recadosAceitosTO){
        String sql = "INSERT INTO T_LS_RECADOS_ACEITOS (MENSAGEM, NM_CONVIDADOS) VALUES (?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, recadosAceitosTO.getMensagem());
            ps.setString(2, recadosAceitosTO.getNomeConvidados());
            if (ps.executeUpdate() > 0){
                return recadosAceitosTO;
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

    public boolean delete(Long idRecadoAceito){
        String sql = "DELETE FROM T_LS_RECADOS_ACEITOS WHERE ID_RECADO_ACEITO = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, idRecadoAceito);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro ao deletar recado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

}
