import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class TesteConta {
    public static void main(String[] args) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();

        contaDAO.cadastrar(new Conta(null, "João", "Banco A", new BigDecimal("1000.00"), Conta.TipoConta.CORRENTE));
        contaDAO.cadastrar(new Conta(null, "Maria", "Banco B", new BigDecimal("2500.00"), Conta.TipoConta.POUPANCA));
        contaDAO.cadastrar(new Conta(null, "Ana", "Banco C", new BigDecimal("500.00"), Conta.TipoConta.SALARIO));
        contaDAO.cadastrar(new Conta(null, "Carlos", "Banco D", new BigDecimal("1200.00"), Conta.TipoConta.CORRENTE));
        contaDAO.cadastrar(new Conta(null, "Fernanda", "Banco E", new BigDecimal("3000.00"), Conta.TipoConta.POUPANCA));

        List<Conta> contas = contaDAO.getAll();
        for (Conta c : contas) {
            System.out.println(c);
        }

        contaDAO.fecharConexao();
    }
}
