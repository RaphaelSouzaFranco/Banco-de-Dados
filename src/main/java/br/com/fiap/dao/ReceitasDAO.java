package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Receitas;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitasDAO {

    private Connection conexao;

    public ReceitasDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Receitas receita) throws SQLException {
        PreparedStatement stmt;
        stmt = conexao.prepareStatement("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_Pagamento, status, conta_id_conta, usuario_id_usuario) VALUES (seq_receitas.nextval, ?, ?, ?, ?, ?, ?, ? , ? )");
        stmt.setDouble(1, receita.getValor());
        stmt.setDate(2, receita.getData_Recebimento());
        stmt.setString(3, receita.getDescricao());
        stmt.setString(4, receita.getCategoria_Receita());
        stmt.setString(5, receita.getForma_Pagamento());
        stmt.setString(6, receita.getStatus());
        stmt.setInt(7, receita.getConta_id_conta());
        stmt.setInt(8, receita.getUsuario_id_usuario());
        stmt.executeUpdate();
        System.out.println("Receita cadastrada com sucesso!");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public Receitas pesquisar(long codigo) throws SQLException, EntidadeNaoEncontrada {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM RECEITAS WHERE id_Receitas = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntidadeNaoEncontrada("Receita não encontrada.");
        }
        return parseReceitas(result);
    }

    private Receitas parseReceitas(ResultSet result) throws SQLException {
        Long id = result.getLong("ID RECEITAS");
        Date data_recebimento = result.getDate("DATA");
        double valor = result.getDouble("VALOR"); // Alterado para 'double' (primitivo)
        String descricao = result.getString("DESCRIÇÃO");
        String categoria_receita = result.getString("CATEGORIA");
        String forma_pagamento = result.getString("FORMA DE PAGAMENTO");
        String status = result.getString("STATUS");
        int conta_id_conta = result.getInt("CONTA_ID_CONTA");
        int usuario_id_usuario = result.getInt("USUÁRIO_ID_USUÁRIO");


        return new Receitas(valor, data_recebimento, id.intValue(), categoria_receita, descricao, status, forma_pagamento, conta_id_conta, usuario_id_usuario);
    }

    public List<Receitas> listar () throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM RECEITAS");
        ResultSet result = stm.executeQuery();
        List<Receitas> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseReceitas(result));
        }
        return lista;
    }
    public void atualizar (Receitas receitas) throws SQLException,EntidadeNaoEncontrada{
    PreparedStatement stm = conexao.prepareStatement("UPDATE RECEITAS SET descricao = ? ");
    stm.setDouble(1, receitas.getValor());
    stm.setDate(2, receitas.getData_Recebimento());
    stm.setString(3, receitas.getDescricao());
    stm.setString(4, receitas.getCategoria_Receita());
    stm.setString(5, receitas.getForma_Pagamento());
    stm.setString(6, receitas.getStatus());
    stm.setInt(7, receitas.getConta_id_conta());
    stm.setInt(8, receitas.getUsuario_id_usuario());
    }
}
