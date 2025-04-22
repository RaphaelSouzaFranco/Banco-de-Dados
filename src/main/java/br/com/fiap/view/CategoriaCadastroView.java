package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

import java.util.List;

public class CategoriaCadastroView {
    public static void main(String[] args) {
        CategoriaDAO catDAO = new CategoriaDAO();

        Categoria cat1 = new Categoria("Sáude", "Crédito", "Vacina");
        Categoria cat2 = new Categoria("Transporte", "Débito", "Uber para o shopping");
        Categoria cat3 = new Categoria("Lazer", "Débito", "Piscina Domingo");
        Categoria cat4 = new Categoria("Alimentação", "Débito", "Comida BK");
        Categoria cat5 = new Categoria("Educação", "Crédito", "Boleto escola");

//        catDAO.adicionarCategoria(cat1);
//        catDAO.adicionarCategoria(cat2);
//        catDAO.adicionarCategoria(cat3);
//        catDAO.adicionarCategoria(cat4);
//        catDAO.adicionarCategoria(cat5);

        List<Categoria> cats;
        cats = catDAO.obterTodas();

        for (Categoria cat : cats) {
            System.out.println(cat.getNome());
        }
    }
}

