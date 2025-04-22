package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastrarContaView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO DE CONTA ===");

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Banco: ");
        String banco = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        BigDecimal saldo = new BigDecimal(scanner.nextLine());

        System.out.print("Tipo de conta (1-Corrente, 2-Poupança, 3-Salário): ");
        int tipo = scanner.nextInt();
        Conta.TipoConta tipoConta = switch (tipo) {
            case 1 -> Conta.TipoConta.CORRENTE;
            case 2 -> Conta.TipoConta.POUPANCA;
            case 3 -> Conta.TipoConta.SALARIO;
            default -> Conta.TipoConta.CORRENTE;
        };

        try (ContaDAO dao = new ContaDAO()) {
            Conta conta = new Conta(null, titular, banco, saldo, tipoConta);
            dao.cadastrar(conta);

            System.out.println("\nConta cadastrada com sucesso!");


        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar conta: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}