import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
public class test
{
    public static void main( String[] args )
    {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}