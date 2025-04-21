package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Despesa;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDao {

    private Connection conexao;

    public DespesaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Despesa despesa) throws SQLException {
        PreparedStatement stm;
        stm = conexao.prepareStatement("INSERT INTO DESPESA (ID_DESPESA, VALOR, DATA_PAGAMENTO, VENCIMENTO, DESCRICAO, CATEGORIA_DESPESA, STATUS_DESPESA, RECORRENTE, USUARIO_ID_USUARIO, CONTA_ID_CONTA) VALUES (seq_despesa.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setBigDecimal(1, despesa.getValor());
        stm.setDate(2, despesa.getDataPagamento());
        stm.setDate(3, despesa.getVencimento());
        stm.setString(4, despesa.getDescricao());
        stm.setString(5, despesa.getCategoriaDespesa());
        stm.setString(6, despesa.getStatusDespesa());
        stm.setString(7, java.lang.String.valueOf(despesa.getRecorrente()));
        stm.setInt(8, despesa.getUsuarioId());
        stm.setInt(9, despesa.getContaId());

        stm.executeUpdate();
        System.out.println("Despesa inserida com sucesso!");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }


    private Despesa parseDespesa(ResultSet result) throws SQLException{
        Long id = result.getLong("id_despesa");
        BigDecimal valor = result.getBigDecimal("VALOR");
        Date dataPagamento = result.getDate("DATA_PAGAMENTO");
        Date vencimento = result.getDate("VENCIMENTO");
        String descricao = result.getString("DESCRICAO");
        String categoria = result.getString("CATEGORIA_DESPESA");
        String status = result.getString("STATUS_DESPESA");
        char recorrente = result.getString("RECORRENTE").charAt(0);
        int usuarioId = result.getInt("USUARIO_ID_USUARIO");
        int contaId = result.getInt("CONTA_ID_CONTA");
        return new Despesa(id.intValue(), valor, dataPagamento, vencimento, descricao, categoria, status, recorrente, usuarioId, contaId);
    }

    public List<Despesa> listar () throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM despesa");
        ResultSet result = stm.executeQuery();
        List<Despesa> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseDespesa(result));
        }
        return lista;
    }

    public void remover(int idDespesa) throws SQLException, EntidadeNaoEncontrada {
        PreparedStatement stm = conexao.prepareStatement("DELETE from despesa where id_despesa = ? ");
        stm.setInt(1, idDespesa);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontrada("Despesa não encontrada para ser removida.");
    }
}
