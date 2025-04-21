package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import java.sql.SQLException;

public class RemoverContaView {
    public static void main(String[] args) {
        try (ContaDAO dao = new ContaDAO()) {
             dao.remover(1L);
             System.out.println("Conta removida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        } catch (EntidadeNaoEncontrada e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}