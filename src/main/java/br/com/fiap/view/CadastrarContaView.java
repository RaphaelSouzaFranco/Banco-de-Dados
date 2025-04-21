package br.com.fiap.view;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import java.math.BigDecimal;
import java.sql.SQLException;


public class CadastrarContaView {
    public static void main(String[] args) {
        // Forma correta com try-with-resources
        try (ContaDAO dao = new ContaDAO()) {
            Conta conta = new Conta(
                    null, // ID será gerado pela sequência
                    "Mikaela Freitas",
                    "Nubank",
                    new BigDecimal("30000.00"),
                    Conta.TipoConta.CORRENTE
            );
            dao.cadastrar(conta);
            System.out.println("Conta cadastrada!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar conta: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}