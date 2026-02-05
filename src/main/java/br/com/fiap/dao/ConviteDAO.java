package br.com.fiap.dao;

import br.com.fiap.to.ConviteTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConviteDAO {

    public ArrayList<ConviteTO> findAll(){
        ArrayList<ConviteTO> convites = new ArrayList<>();
        String sql = "SELECT * FROM T_LS_NM_CONVITE ORDER BY NM_CONVITE";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ConviteTO convite = new ConviteTO();
                convite.setIdConvite(rs.getString("ID_NM_CONVITE"));
                convite.setNomeConvite(rs.getString("NM_CONVITE"));
                convites.add(convite);
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar convites: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return convites;
    }

    public ConviteTO save(ConviteTO conviteTO){
        String sql = "INSERT INTO T_LS_NM_CONVITE (ID_NM_CONVITE, NM_CONVITE) VALUES (FN_GERAR_ID_CONVITE(), ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, conviteTO.getNomeConvite());
            if (ps.executeUpdate() > 0){
                return conviteTO;
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao salvar convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ConviteTO findConvite(String nomeConvite, String idConvite){
        ConviteTO conviteTO = new ConviteTO();
        String sql = "SELECT * FROM T_LS_NM_CONVITE WHERE NM_CONVITE = ? AND ID_NM_CONVITE = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, nomeConvite);
            ps.setString(2, idConvite);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                conviteTO.setIdConvite(rs.getString("ID_NM_CONVITE"));
                conviteTO.setNomeConvite(rs.getString("NM_CONVITE"));
            }else {
                return null;
            }
        }catch (SQLException e ){
            System.out.println("Erro ao buscar convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return conviteTO;
    }

    public boolean delete(String idConvite){
        String sql = "DELETE FROM T_LS_CONVIDADOS WHERE ID_NM_CONVITE = ?; DELETE FROM T_LS_NM_CONVITE WHERE ID_NM_CONVITE = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, idConvite);
            return ps.executeUpdate() > 0;
        }catch (SQLException e ){
            System.out.println("Erro ao deletar convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ConviteTO update(ConviteTO conviteTO){
        String sql = "UPDATE T_LS_NM_CONVITE SET NM_CONVITE = ? WHERE ID_NM_CONVITE = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, conviteTO.getNomeConvite());
            ps.setString(2, conviteTO.getIdConvite());
            if (ps.executeUpdate() > 0) {
                return conviteTO;
            } else {
                return null;
            }
        }catch (SQLException e ){
            System.out.println("Erro ao atualizar convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ConviteTO findConviteADM(String nomeConvite){
        ConviteTO conviteTO = new ConviteTO();
        String sql = "SELECT * FROM T_LS_NM_CONVITE WHERE NM_CONVITE = ? ORDER BY NM_CONVITE";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, nomeConvite);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                conviteTO.setIdConvite(rs.getString("ID_NM_CONVITE"));
                conviteTO.setNomeConvite(rs.getString("NM_CONVITE"));
            }else {
                return null;
            }
        }catch (SQLException e ){
            System.out.println("Erro ao buscar convite: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return conviteTO;
    }

}
