package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Dividas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DividasDAO {

    public void insert(Dividas divida) {
        String sql = "INSERT INTO DIVIDAS (IDDIVIDA, VALOR, DATAINICIO, DATAVENCIMENTO, DESCRICAO, PARCELAS, VALORPARCELAS, STATUSDIVIDA, CREDOR, " +
                "TAXAJUROS, FORMAPAGAMENTO, ORIGEMDIVIDA, IDUSUARIO, IDCONTA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, divida.getIdDivida());
            stmt.setDouble(2, divida.getValor());
            stmt.setString(3, divida.getDataInicio());
            stmt.setString(4, divida.getDataVencimento());
            stmt.setString(5, divida.getDescricao());
            stmt.setInt(6, divida.getParcelas());
            stmt.setDouble(7, divida.getValorParcelas());
            stmt.setString(8, divida.getStatusDivida());
            stmt.setString(9, divida.getCredor());
            stmt.setDouble(10, divida.getTaxaJuros());
            stmt.setString(11, divida.getFormaPagamento());
            stmt.setString(12, divida.getOrigemDivida());
            stmt.setInt(13, divida.getIdUsuario());
            stmt.setInt(14, divida.getIdConta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dívida: " + e.getMessage());
        }
    }

    public List<Dividas> getAll() {
        List<Dividas> lista = new ArrayList<>();
        String sql = "SELECT * FROM DIVIDAS";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dividas divida = new Dividas(
                        rs.getInt("IDDIVIDA"),
                        rs.getDouble("VALOR"),
                        rs.getString("DATAINICIO"),
                        rs.getString("DATAVENCIMENTO"),
                        rs.getString("DESCRICAO"),
                        rs.getInt("PARCELAS"),
                        rs.getDouble("VALORPARCELAS"),
                        rs.getString("STATUSDIVIDA"),
                        rs.getString("CREDOR"),
                        rs.getDouble("TAXAJUROS"),
                        rs.getString("FORMAPAGAMENTO"),
                        rs.getString("ORIGEMDIVIDA"),
                        rs.getInt("IDUSUARIO"),
                        rs.getInt("IDCONTA")
                );
                lista.add(divida);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar dívidas: " + e.getMessage());
        }

        return lista;
    }
}

