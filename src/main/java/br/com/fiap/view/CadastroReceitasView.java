package br.com.fiap.view;
import br.com.fiap.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class CadastroReceitasView {
        public static void main(String[] args) {
            try {
                Connection conexao = ConnectionFactory.getConnection();
                Statement stm = conexao.createStatement();
                stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) VALUES (seq_receitas.nextval, 1000.00, TO_DATE ('2025-03-26', 'YYYY-MM-DD'), 'Recebimento de Salário', 'Salário', 'Pix', 'Recebido',0001, 1 )");
                System.out.println("Produto cadastrado!");
                stm.close();
                conexao.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }



