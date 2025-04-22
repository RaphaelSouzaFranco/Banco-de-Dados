package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Divida;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DividaDAO {

    private Connection conexao;

    public DividaDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    // Inserir uma dívida
    public void inserir(Divida divida) throws SQLException {
        String sql = "INSERT INTO DIVIDA (VALOR, DATA_INICIO, DATA_VENCIMENTO, DESCRICAO, PARCELAS, VALOR_PARCELAS, " +
                "STATUS_DIVIDA, CREDOR, TAXA_JUROS, FORMA_PAGAMENTO, ORIGEM_DIVIDA, USUARIO_ID_USUARIO, CONTA_ID_CONTA) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, divida.getVALOR());
            stmt.setDate(2, Date.valueOf(divida.getDATA_INICIO()));
            stmt.setDate(3, Date.valueOf(divida.getDATA_VENCIMENTO()));
            stmt.setString(4, divida.getDESCRICAO());
            stmt.setInt(5, divida.getPARCELAS());
            stmt.setDouble(6, divida.getVALOR_PARCELAS());
            stmt.setString(7, divida.getSTATUS_DIVIDA());
            stmt.setString(8, divida.getCREDOR());
            stmt.setDouble(9, divida.getTAXA_JUROS());
            stmt.setString(10, divida.getFORMA_PAGAMENTO());
            stmt.setString(11, divida.getORIGEM_DIVIDA());
            stmt.setInt(12, divida.getUSUARIO_ID_USUARIO());
            stmt.setInt(13, divida.getCONTA_ID_CONTA());

            stmt.executeUpdate();
        }
    }

    // Buscar dívida pelo ID
    public Divida buscarPorId(int id) throws SQLException, EntidadeNaoEncontrada {
        String sql = "SELECT * FROM DIVIDA WHERE ID_DIVIDA = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearDivida(rs);
                } else {
                    throw new EntidadeNaoEncontrada("Dívida com ID " + id + " não encontrada.");
                }
            }
        }
    }

    // Listar as dívidas
    public List<Divida> listar() throws SQLException {
        String sql = "SELECT * FROM DIVIDA";
        List<Divida> dividas = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Debug para verificar os dados no ResultSet
                System.out.println("ID: " + rs.getInt("ID_DIVIDA"));
                System.out.println("Valor: " + rs.getDouble("VALOR"));
                // Imprimir todos os outros campos que você está recuperando...
                dividas.add(mapearDivida(rs));
            }
        }

        return dividas;
    }

    // Atualizar dívida
    public void atualizar(Divida divida) throws SQLException {
        String sql = "UPDATE DIVIDA SET VALOR = ?, DATA_INICIO = ?, DATA_VENCIMENTO = ?, DESCRICAO = ?, PARCELAS = ?, " +
                "VALOR_PARCELAS = ?, STATUS_DIVIDA = ?, CREDOR = ?, TAXA_JUROS = ?, FORMA_PAGAMENTO = ?, ORIGEM_DIVIDA = ?, " +
                "USUARIO_ID_USUARIO = ?, CONTA_ID_CONTA = ? WHERE ID_DIVIDA = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, divida.getVALOR());
            stmt.setDate(2, Date.valueOf(divida.getDATA_INICIO()));
            stmt.setDate(3, Date.valueOf(divida.getDATA_VENCIMENTO()));
            stmt.setString(4, divida.getDESCRICAO());
            stmt.setInt(5, divida.getPARCELAS());
            stmt.setDouble(6, divida.getVALOR_PARCELAS());
            stmt.setString(7, divida.getSTATUS_DIVIDA());
            stmt.setString(8, divida.getCREDOR());
            stmt.setDouble(9, divida.getTAXA_JUROS());
            stmt.setString(10, divida.getFORMA_PAGAMENTO());
            stmt.setString(11, divida.getORIGEM_DIVIDA());
            stmt.setInt(12, divida.getUSUARIO_ID_USUARIO());
            stmt.setInt(13, divida.getCONTA_ID_CONTA());
            stmt.setInt(14, divida.getID_DIVIDA());

            stmt.executeUpdate();
        }
    }

    private Divida mapearDivida(ResultSet rs) throws SQLException {
        return new Divida(
                rs.getInt("ID_DIVIDA"),
                rs.getDouble("VALOR"),
                rs.getDate("DATA_INICIO").toLocalDate(),
                rs.getDate("DATA_VENCIMENTO").toLocalDate(),
                rs.getString("DESCRICAO"),
                rs.getInt("PARCELAS"),
                rs.getDouble("VALOR_PARCELAS"),
                rs.getString("STATUS_DIVIDA"),
                rs.getString("CREDOR"),
                rs.getDouble("TAXA_JUROS"),
                rs.getString("FORMA_PAGAMENTO"),
                rs.getString("ORIGEM_DIVIDA"),
                rs.getInt("USUARIO_ID_USUARIO"),
                rs.getInt("CONTA_ID_CONTA")
        );
    }

    // Fechar a conexão
    public void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }
}
