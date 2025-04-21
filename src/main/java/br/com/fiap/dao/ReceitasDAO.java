package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Receitas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReceitasDAO {

    public void insert(Receitas receita) {
        String sql = "INSERT INTO RECEITA (VALOR, DATA, ORIGEM) VALUES (?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, receita.getValor());
            stmt.setString(2, receita.getData());
            stmt.setString(3, receita.getOrigem());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir receita: " + e.getMessage());
        }
    }

    public List<Receitas> getAll() {
        List<Receitas> lista = new ArrayList<>();
        String sql = "SELECT * FROM RECEITA";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                double valor = rs.getDouble("VALOR");
                String data = rs.getString("DATA");
                String origem = rs.getString("ORIGEM");

                lista.add(new Receitas(valor, data, origem));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar receitas: " + e.getMessage());
        }

        return lista;
    }
}
