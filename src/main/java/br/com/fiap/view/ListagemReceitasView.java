package br.com.fiap.view;

import br.com.fiap.dao.ReceitasDAO;
import br.com.fiap.model.Receitas;

import java.sql.SQLException;
import java.util.List;

public class ListagemReceitasView {
    public static void main(String[] args) {
        try {
            ReceitasDAO dao = new ReceitasDAO();
            List<Receitas> receitas = dao.listar();
            for (Receitas receita : receitas) {
                System.out.println("|Descrição: " + receita.getDescricao() + " |R$ " + receita.getValor() + " |Categoria: " + receita.getCategoria_Receita() + " |Recebida em: " + receita.getData_Recebimento() + " |Forma de Pagamento: " + receita.getForma_Pagamento() + " |Status: " + receita.getStatus() + " |Usuário ID: " + receita.getUsuario_id_usuario() + " |Conta ID: " + receita.getConta_id_conta());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
