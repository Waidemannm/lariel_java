package br.com.fiap.dao;

import br.com.fiap.to.ConvidadoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConvidadoDAO {
    public ArrayList<ConvidadoTO> findAll(){
        ArrayList<ConvidadoTO> convidados = new ArrayList<>();
        String sql = "SELECT * FROM T_LS_CONVIDADOS ORDER BY NM_CONVIDADO";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ConvidadoTO convidado = new ConvidadoTO();
                convidado.setIdConvidado(rs.getLong("ID_CONVIDADO"));
                convidado.setIdConvite(rs.getString("ID_NM_CONVITE"));
                convidado.setNomeConvidado(rs.getString("NM_CONVIDADO"));
                convidado.setStatus(rs.getString("ST_PRESENCA"));
                convidados.add(convidado);
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar convidados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return convidados;
    }

    public ConvidadoTO save(ConvidadoTO convidadoTO){
        String sql = "INSERT INTO T_LS_CONVIDADOS (ID_NM_CONVITE, NM_CONVIDADO, ST_PRESENCA) VALUES (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, convidadoTO.getIdConvite().toUpperCase());
            ps.setString(2, convidadoTO.getNomeConvidado());
            ps.setString(3, convidadoTO.getStatus().toUpperCase());
            if (ps.executeUpdate() > 0){
                return convidadoTO;
            }else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao salvar convidado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ConvidadoTO findByName(String nomeConvidado){
        ConvidadoTO convidado = new ConvidadoTO();
        String sql = "SELECT * FROM T_LS_CONVIDADOS WHERE NM_CONVIDADO = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, nomeConvidado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                convidado.setIdConvidado(rs.getLong("ID_CONVIDADO"));
                convidado.setIdConvite(rs.getString("ID_NM_CONVITE"));
                convidado.setNomeConvidado(rs.getString("NM_CONVIDADO"));
                convidado.setStatus(rs.getString("ST_PRESENCA"));
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao consulta convidado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return convidado;
    }

    public boolean delete(Long idConvidado){
        String sql = "DELETE FROM T_LS_CONVIDADOS WHERE ID_CONVIDADO = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, idConvidado);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro ao deletar convidado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ConvidadoTO update(ConvidadoTO convidadoTO){
        String sql = "UPDATE T_LS_CONVIDADOS SET NM_CONVIDADO = ?, ST_PRESENCA = ? WHERE ID_CONVIDADO = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, convidadoTO.getNomeConvidado());
            ps.setString(2, convidadoTO.getStatus().toUpperCase());
            ps.setLong(3, convidadoTO.getIdConvidado());
            if (ps.executeUpdate() > 0) {
                return convidadoTO;
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar convidado: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ConvidadoTO updateStatus(ConvidadoTO convidadoTO){
        String sql = "UPDATE T_LS_CONVIDADOS ST_PRESENCA = ? WHERE ID_CONVIDADO = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, convidadoTO.getStatus().toUpperCase());
            ps.setLong(2, convidadoTO.getIdConvidado());
            if (ps.executeUpdate() > 0) {
                return convidadoTO;
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar status: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ArrayList<ConvidadoTO> findByIdConvite(String idConvite){
        ArrayList<ConvidadoTO> convidados = new ArrayList<>();
        String sql = "SELECT * FROM T_LS_CONVIDADOS WHERE ID_NM_CONVITE = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, idConvite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ConvidadoTO convidado = new ConvidadoTO();
                convidado.setIdConvidado(rs.getLong("ID_CONVIDADO"));
                convidado.setIdConvite(rs.getString("ID_NM_CONVITE"));
                convidado.setNomeConvidado(rs.getString("NM_CONVIDADO"));
                convidado.setStatus(rs.getString("ST_PRESENCA"));
                convidados.add(convidado);
            }
        }catch (SQLException e){
            System.out.println("Erro ao procurar convidados deste convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return convidados;
    }
}
