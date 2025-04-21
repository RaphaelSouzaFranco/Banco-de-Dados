package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.exception.EntidadeNaoEncontrada;

import java.sql.SQLException;

public class RemocaoDespesaView {
    public static void main(String [] args) {
        try {
            DespesaDao dao = new DespesaDao();
            dao.remover(14);
            dao.fecharConexao();
            System.out.println("Despesa removida!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontrada e){
            System.err.println("Despesa não encontrada.");
        }
    }
}

