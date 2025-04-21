package br.com.fiap.view;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.model.Conta;
import java.math.BigDecimal;
import java.sql.SQLException;


public class AtualizarContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();

            Conta conta = dao.pesquisar(1L);

            if (conta == null) {
                throw new EntidadeNaoEncontrada();
            }

            conta.setNomeConta("Mikaela Freitas");
            conta.setBanco("Nubank");
            conta.setSaldo(new BigDecimal("30000.00"));
            conta.setTipoConta(Conta.TipoConta.POUPANCA); // Escolha uma opção válida

            Conta contaComIdLong = null;
            dao.atualizar(contaComIdLong);
            dao.fecharConexao();
            System.out.println("Conta atualizada!");
        } catch (EntidadeNaoEncontrada e) {
            System.err.println("Conta não encontrada.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
