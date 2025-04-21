package br.com.fiap.view;

import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.model.Conta;
import br.com.fiap.dao.ContaDAO;

import java.math.BigDecimal;
import java.sql.SQLException;

public class PesquisarContaView {
    public static void main(String[] args) {
        try (ContaDAO dao = new ContaDAO()) {
            // Convertendo o valor literal para Long usando 'L' no final
            Conta conta = dao.pesquisar(1L); // Note o 'L' após o número

            System.out.println("Conta encontrada: " + conta);
        } catch (SQLException e) {
            System.err.println("Erro no banco: " + e.getMessage());
            e.printStackTrace();
        } catch (EntidadeNaoEncontrada e) {
            System.err.println("Conta não encontrada.");
        }
    }
}