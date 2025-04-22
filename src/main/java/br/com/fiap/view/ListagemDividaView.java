package br.com.fiap.view;

import br.com.fiap.dao.DividaDAO;
import br.com.fiap.model.Divida;
import java.sql.SQLException;
import java.util.List;

public class ListagemDividaView {
    public static void main(String[] args) {
        DividaDAO dao = null;
        try {
            // Criando a instância do DAO
            dao = new DividaDAO();

            // Listar as dívidas
            List<Divida> dividas = dao.listar();

            // Exibir as dívidas
            if (dividas.isEmpty()) {
                System.out.println("Não há dívidas cadastradas.");
            } else {
                System.out.println("Dívidas cadastradas:");
                for (Divida divida : dividas) {
                    System.out.println(divida);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar dívidas: " + e.getMessage());
        } finally {
            try {
                // Fechar a conexão, se estiver aberta
                if (dao != null) {
                    dao.fecharConexao();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}

