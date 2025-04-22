
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class TesteConta {
    public static void main(String[] args) {
        try (ContaDAO contaDAO = new ContaDAO()) {
            System.out.println("=== ÚLTIMAS CONTAS CADASTRADAS ===");
            System.out.println("ID | Nome | Banco | Saldo | Tipo Conta");
            System.out.println("--------------------------------------");

            List<Conta> contas = contaDAO.listar();

            // Ordena por ID decrescente e limita a 5 registros
            List<Conta> recentes = contas.stream()
                    .sorted((c1, c2) -> c2.getIdConta().compareTo(c1.getIdConta()))
                    .limit(5)
                    .collect(Collectors.toList());

            if (recentes.isEmpty()) {
                System.out.println("Nenhuma conta cadastrada recentemente.");
            } else {
                for (Conta c : recentes) {
                    System.out.printf("%-3d| %-10s| %-10s| R$%-8.2f| %s%n",
                            c.getIdConta(),
                            c.getNomeConta(),
                            c.getBanco(),
                            c.getSaldo(),
                            c.getTipoConta().getDescricao());
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco: " + e.getMessage());
        }
    }
}