import br.com.fiap.dao.DespesaDao;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.model.Despesa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TesteDespesa {

    public static void main(String[] args) {
        DespesaDao dao = null;

        try {
            dao = new DespesaDao();

            setup(dao); // limpa antes
            cadastrarDespesas(dao);
            listarDespesas(dao);

        } catch (SQLException e) {
            System.err.println("Erro ao acessar banco de dados: " + e.getMessage());
        } finally {
            try {
                if (dao != null) dao.fecharConexao();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // limpa as despesas da base (setup)
    private static void setup(DespesaDao dao) throws SQLException {
        System.out.println("==> Limpando tabela de despesas (setup)...");
        List<Despesa> despesas = dao.listar();
        for (Despesa d : despesas) {
            try {
                dao.remover(d.getIdDespesa());
            } catch (EntidadeNaoEncontrada e) {
                throw new RuntimeException(e);
            }
        }
    }

    // insere despesas
    private static void cadastrarDespesas(DespesaDao dao) throws SQLException {
        System.out.println(" |Cadastrando despesas...");
        dao.cadastrar(new Despesa(new BigDecimal("300.96"), Date.valueOf("2025-03-18"), Date.valueOf("2025-03-25"), "Gasolina", "Transporte", "PAGO", 'N', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("76.95"), Date.valueOf("2025-03-18"), Date.valueOf("2025-03-25"), "Água", "Moradia", "PAGO", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("450.95"), Date.valueOf("2025-04-16"), Date.valueOf("2025-03-20"), "Luz", "Moradia", "PAGO", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("550.95"), Date.valueOf("2025-04-18"), Date.valueOf("2025-04-25"), "Aluguel", "Moradia", "PAGA", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("300.00"), Date.valueOf("2025-04-25"), Date.valueOf("2025-04-25"), "Curso Inglês", "Educação", "PENDENTE", 'N', 1, 1));
    }

    // lista despesas
    private static void listarDespesas(DespesaDao dao) throws SQLException {
        System.out.println(" |Listando despesas...");
        List<Despesa> despesas = dao.listar();
        if (despesas.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
            return;
        }

        System.out.println(" |LISTAGEM DE DESPESAS ");
        for (Despesa d : despesas) {
            System.out.printf("ID: %d | Descrição: %s | Categoria: %s | Valor: R$ %.2f | Status: %s%n",
                    d.getIdDespesa(), d.getDescricao(), d.getCategoriaDespesa(), d.getValor(), d.getStatusDespesa());
        }
    }
}