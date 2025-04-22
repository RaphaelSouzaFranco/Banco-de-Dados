package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public List<Categoria> obterTodas() {
        List<Categoria> categorias = new ArrayList<>();
        String consulta = "SELECT NOME, TIPO, DESCRICAO FROM CATEGORIAS";

        try (Connection conexao = ConnectionFactory.getConnection(); Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("NOME"),
                        rs.getString("TIPO"),
                        rs.getString("DESCRICAO")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar categorias: " + e.getMessage());
            e.printStackTrace();
        }

        return categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        String inserir = "INSERT INTO CATEGORIAS (NOME, TIPO, DESCRICAO) VALUES (?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement pstmt = conexao.prepareStatement(inserir)) {
            pstmt.setString(1, categoria.getNome());
            pstmt.setString(2, categoria.getTipo());
            pstmt.setString(3, categoria.getDescricao());

            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Categoria cadastrada com sucesso: " + categoria.getNome());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar categoria: " + e.getMessage());
            e.printStackTrace();
        }
    }
}