package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.model.Despesa;

import java.sql.SQLException;
import java.util.List;

public class ListagemDespesaView {
    public static void main(String[] args) {
        try {
            DespesaDao dao = new DespesaDao();
            List<Despesa> despesas = dao.listar();
            for (Despesa despesa : despesas) {
                System.out.println("|Descrição: " + despesa.getDescricao() + " |R$ " + despesa.getValor() + " | " + despesa.getCategoriaDespesa() + " | Paga em: " + despesa.getDataPagamento() + " | Com vencimento em: " + despesa.getVencimento() + " | " +
                        "| Status: " + despesa.getStatusDespesa() + " |Recorrente:   " + despesa.getRecorrente() + " | " + despesa.getUsuarioId() + " " + despesa.getContaId());
            }
            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}