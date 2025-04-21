package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;

import java.sql.SQLException;
import java.util.List;

public class ListarContasView {

    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            List<Conta> contas = dao.getAll();

            for (Conta c : contas) {
                System.out.println(c);
            }

            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println("Erro ao listar contas: " + e.getMessage());
        }
    }
}
