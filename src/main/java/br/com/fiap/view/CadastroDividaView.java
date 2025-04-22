package br.com.fiap.view;

import br.com.fiap.dao.DividaDAO;
import br.com.fiap.model.Divida;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastroDividaView {
    public static void main(String[] args) {
        try {
            DividaDAO dao = new DividaDAO();

            Divida divida = new Divida(
                    0,
                    1000.50, //valor
                    LocalDate.parse("2025-04-16"), //data de início
                    LocalDate.parse("2025-05-10"), //data de vencimento
                    "Empréstimo pessoal", //descrição
                    12, //parcelas
                    100.05, // valor parcelas
                    "PENDENTE", //Status
                    "Banco XYZ", //Credor
                    5.0, // Taxa de juros
                    "Boleto", //forma de pagamento
                    "Empréstimo pessoal", //origem da dívida
                    1, //ID do usuário
                    1  //ID da conta
            );


            dao.inserir(divida);
            System.out.println("Dívida cadastrada com sucesso!");

            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dívida: " + e.getMessage());
        }
    }
}

