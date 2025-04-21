import br.com.fiap.dao.DespesaDao;
import br.com.fiap.model.Despesa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) throws SQLException {
        DespesaDao dao = new DespesaDao();

        // cadastro de 5 despesas
        dao.cadastrar(new Despesa(new BigDecimal("300.96"), Date.valueOf("2025-03-18"), Date.valueOf("2025-03-25"), "Gasolina", "Transporte", "PAGO", 'N', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("76.95"), Date.valueOf("2025-03-18"), Date.valueOf("2025-03-25"), "Água", "Moradia", "PAGO", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("450.95"), Date.valueOf("2025-04-16"), Date.valueOf("2025-03-20"), "Luz", "Moradia", "PAGO", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("550.95"), Date.valueOf("2025-04-18"), Date.valueOf("2025-04-25"), "Aluguel", "Moradia", "PAGA", 'S', 1, 1));
        dao.cadastrar(new Despesa(new BigDecimal("300.00"), Date.valueOf("2025-04-25"), Date.valueOf("2025-04-25"), "Curso Inglês", "Educação", "PENDENTE", 'N', 1, 1));

        // consultando todas as despesas
        List<Despesa> despesas = dao.listar();
        for (Despesa d : despesas) {
            System.out.println("ID: " + d.getIdDespesa()
                    + " | Descrição: " + d.getDescricao()
                    + " | Categoria: " + d.getCategoriaDespesa()
                    + " | Valor: " + d.getValor()
                    + " | Status: " + d.getStatusDespesa());
        }
    }
}