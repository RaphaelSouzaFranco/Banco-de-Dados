import br.com.fiap.model.Divida;
import br.com.fiap.dao.DividaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteDivida {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Divida divida = new Divida();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Entrada de dados
            System.out.print("Informe o ID da dívida: ");
            divida.setID_DIVIDA(sc.nextInt());

            System.out.print("Informe o valor da dívida: ");
            divida.setVALOR(sc.nextDouble());

            sc.nextLine(); // Limpar o buffer

            System.out.print("Informe a data de início (ex: yyyy-MM-dd): ");
            String dataInicioStr = sc.nextLine();
            LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
            divida.setDATA_INICIO(dataInicio);

            System.out.print("Informe a data de vencimento (ex: yyyy-MM-dd): ");
            String dataVencimentoStr = sc.nextLine();
            LocalDate dataVencimento = LocalDate.parse(dataVencimentoStr, formatter);
            divida.setDATA_VENCIMENTO(dataVencimento);

            System.out.print("Informe a descrição da dívida: ");
            divida.setDESCRICAO(sc.nextLine());

            System.out.print("Informe o número de parcelas: ");
            divida.setPARCELAS(sc.nextInt());

            System.out.print("Informe o valor das parcelas: ");
            divida.setVALOR_PARCELAS(sc.nextDouble());

            sc.nextLine(); // Limpar o buffer

            System.out.print("Informe o status da dívida (ex: Paga, Em Aberto): ");
            divida.setSTATUS_DIVIDA(sc.nextLine());

            System.out.print("Informe o credor: ");
            divida.setCREDOR(sc.nextLine());

            System.out.print("Informe a taxa de juros (ex: 2 para 2%): ");
            divida.setTAXA_JUROS(sc.nextDouble());

            sc.nextLine(); // Limpar o buffer

            System.out.print("Informe a forma de pagamento: ");
            divida.setFORMA_PAGAMENTO(sc.nextLine());

            System.out.print("Informe a origem da dívida (ex: Cartão de Crédito, Financiamento): ");
            divida.setORIGEM_DIVIDA(sc.nextLine());

            System.out.print("Informe o ID do usuário: ");
            divida.setUSUARIO_ID_USUARIO(sc.nextInt());

            System.out.print("Informe o ID da conta: ");
            divida.setCONTA_ID_CONTA(sc.nextInt());

            // Cadastrar no banco
            DividaDAO dao = new DividaDAO();
            dao.inserir(divida);

            System.out.println("\nDívida cadastrada com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: entrada inválida. Por favor, verifique os dados digitados.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar a dívida: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

