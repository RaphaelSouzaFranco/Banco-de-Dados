package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.exception.EntidadeNaoEncontrada;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoverContaView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REMOÇÃO DE MÚLTIPLAS CONTAS ===");
        System.out.println("\nDigite os IDs das contas que deseja remover (separados por vírgula):");
        String input = scanner.nextLine();


        if (!input.matches("\\d+(\\s*,\\s*\\d+)*")) {
            System.out.println("\nFormato inválido! Use números separados por vírgula (ex: 1, 2, 3)");
            scanner.close();
            return;
        }

        System.out.println("\nVocê está prestes a remover as contas: " + input);
        System.out.print("Confirmar operação? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Operação cancelada.");
            scanner.close();
            return;
        }

        String[] ids = input.split(",");
        int sucessos = 0;
        int falhas = 0;

        try (ContaDAO dao = new ContaDAO()) {
            System.out.println("\nIniciando processo de remoção...");

            for (String idStr : ids) {
                try {
                    long id = Long.parseLong(idStr.trim());

                    try {
                        dao.remover(id);
                        System.out.println("✓ Conta ID " + id + " removida com sucesso");
                        sucessos++;
                    } catch (EntidadeNaoEncontrada e) {
                        System.out.println("✗ Conta ID " + id + " não encontrada");
                        falhas++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✗ ID inválido: " + idStr);
                    falhas++;
                }
            }

            System.out.println("\n=== RESUMO DA OPERAÇÃO ===");
            System.out.println("Contas removidas com sucesso: " + sucessos);
            System.out.println("Falhas na remoção: " + falhas);
            System.out.println("Total processado: " + (sucessos + falhas));

        } catch (SQLException e) {
            System.err.println("\nErro grave ao acessar o banco de dados: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}