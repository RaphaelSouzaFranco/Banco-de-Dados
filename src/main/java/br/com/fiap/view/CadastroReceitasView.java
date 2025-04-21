package br.com.fiap.view;
import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroReceitasView {
        public static void main(String[] args) {
            try {
                Connection conexao = ConnectionFactory.getConnection();
                Statement stm = conexao.createStatement();
                stm.executeUpdate("INSERT INTO RECEITAS (idReceitas, valor , data_recebimento, descricao, categoria_receitas, forma_pagamento, status, conta) VALUES (seq_receitas.nextval, 1000.00, 26/03/2025, 'Recebimento de Salário', 'Pix', 'Recebido')");
                System.out.println("Produto cadastrado!");
                stm.close();
                conexao.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }


