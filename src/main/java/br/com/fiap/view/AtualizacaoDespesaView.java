package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.model.Despesa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class AtualizacaoDespesaView {
    public static void main (String [] args) {
        try {
            DespesaDao dao = new DespesaDao();
            Despesa despesa = dao.pesquisar(13);
            despesa.setDescricao("Gasolina");
            despesa.setCategoriaDespesa("Transporte");
            despesa.setValor(new BigDecimal("300.96"));
            despesa.setDataPagamento(Date.valueOf("2025-03-18"));
            despesa.setVencimento(Date.valueOf("2025-03-25"));
            despesa.setStatusDespesa("PAGA");
            despesa.setRecorrente('S');
            dao.atualizar(despesa);
            dao.fecharConexao();
            System.out.println("Despesa atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontrada e) {
            System.err.println("Despesa não localizada.");
        }
    }
}
