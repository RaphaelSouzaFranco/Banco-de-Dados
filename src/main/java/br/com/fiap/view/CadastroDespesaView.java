package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.model.Despesa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class CadastroDespesaView {
    public static void main (String[] args){
        try {
            DespesaDao dao = new DespesaDao();
            Despesa despesa = new Despesa(new BigDecimal("220.85"), Date.valueOf("2025-04-16"), Date.valueOf("2025-05-10"), "Vale Transporte",
                    "Transporte",
                    "PENDENTE",
                    'S',
                    1,
                    1
            );
            dao.cadastrar(despesa);
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir despesa: " + e.getMessage());
        }
    }
}