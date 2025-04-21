package br.com.fiap.view;

import br.com.fiap.model.Conta;

import java.math.BigDecimal;
import java.util.List;

    public class TesteConta {
        public static void main(String[] args) {
            ContaDAO contaDAO = new ContaDAO();

            // Inserindo 5 contas
            contaDAO.insert(new Conta("João", new BigDecimal("1000.00"), "Banco A", "001", "12345-6", Conta.TipoConta.CORRENTE));
            contaDAO.insert(new Conta("Maria", new BigDecimal("2500.00"), "Banco B", "002", "23456-7", Conta.TipoConta.POUPANCA));
            contaDAO.insert(new Conta("Ana", new BigDecimal("500.00"), "Banco C", "003", "34567-8", Conta.TipoConta.SALARIO));
            contaDAO.insert(new Conta("Carlos", new BigDecimal("1200.00"), "Banco D", "004", "45678-9", Conta.TipoConta.CORRENTE));
            contaDAO.insert(new Conta("Fernanda", new BigDecimal("3000.00"), "Banco E", "005", "56789-0", Conta.TipoConta.POUPANCA));

            // Recuperando e exibindo todas as contas
            List<Conta> contas = contaDAO.getAll();
            for (Conta c : contas) {
                System.out.println(c);
            }
        }
    }


