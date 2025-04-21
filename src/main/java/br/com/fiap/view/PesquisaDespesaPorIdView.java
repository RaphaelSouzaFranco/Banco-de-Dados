package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import br.com.fiap.model.Despesa;

import java.sql.SQLException;

public class PesquisaDespesaPorIdView {

    public static void main (String [] args) {
        try {
            DespesaDao dao = new DespesaDao();
            Despesa despesa = dao.pesquisar(10);
            System.out.println(despesa.getDescricao() + " R$ " + despesa.getValor() + " " + despesa.getCategoriaDespesa() + " paga em: " + despesa.getDataPagamento() + " com vencimento em: " + despesa.getVencimento() + " " +
                    "despesa está: " + despesa.getStatusDespesa() + "\n  " + despesa.getRecorrente() + " " + despesa.getUsuarioId() + " " + despesa.getContaId());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontrada e) {
            System.err.println("ID não existe na tabela");
        }
    }
}