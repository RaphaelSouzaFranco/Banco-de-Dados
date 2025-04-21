package br.com.fiap.view;

import br.com.fiap.dao.ReceitasDAO;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Receitas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CadastroReceitasView {

    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            Statement stm = conexao.createStatement();

            System.out.println("Cadastrando receitas...");

            stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) " +
                    "VALUES (seq_receitas.nextval, 1000.00, TO_DATE('2025-03-26', 'YYYY-MM-DD'), 'Recebimento de Salário', 'Salário', 'Pix', 'Recebido', 1, 1)");

            stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) " +
                    "VALUES (seq_receitas.nextval, 250.50, TO_DATE('2025-03-28', 'YYYY-MM-DD'), 'Freelancer de design', 'Freelancer', 'Transferência', 'Recebido', 1, 1)");

            stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) " +
                    "VALUES (seq_receitas.nextval, 120.75, TO_DATE('2025-03-30', 'YYYY-MM-DD'), 'Venda de produtos', 'Venda', 'Dinheiro', 'Recebido', 1, 1)");

            stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) " +
                    "VALUES (seq_receitas.nextval, 300.00, TO_DATE('2025-04-01', 'YYYY-MM-DD'), 'Reembolso viagem', 'Reembolso', 'TED', 'Recebido', 1, 1)");

            stm.executeUpdate("INSERT INTO RECEITAS (id_Receitas, valor , data_recebimento, descricao, categoria_receita, forma_pagamento, status, conta_id_conta, usuario_id_usuario) " +
                    "VALUES (seq_receitas.nextval, 500.00, TO_DATE('2025-04-05', 'YYYY-MM-DD'), 'Aluguel recebido', 'Aluguel', 'Pix', 'Recebido', 1, 1)");

            System.out.println("Todas as receitas foram cadastradas com sucesso!");

            stm.close();
            conexao.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
