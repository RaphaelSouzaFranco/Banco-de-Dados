package br.com.fiap.dao;

import br.com.fiap.model.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

        private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        private static final String USUARIO = "seu_usuario";
        private static final String SENHA = "sua_senha";

        public List<Conta> getAll() {
            List<Conta> contas = new ArrayList<>();
            String sql = "SELECT * FROM CONTAS";

            try (Connection conn = conectar ();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Conta conta = new Conta();
                    conta.setNome(rs.getString("NOME"));
                    conta.setSaldo(rs.getBigDecimal("SALDO"));
                    conta.setBanco(rs.getString("BANCO"));
                    conta.setAgencia(rs.getString("AGENCIA"));
                    conta.setConta(rs.getString("CONTA"));
                    conta.setTipoConta(Conta.TipoConta.valueOf(rs.getString("TIPO_CONTA")));
                    contas.add(conta);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao consultar contas: " + e.getMessage());
                e.printStackTrace();
            }

            return contas;
        }

        public void insert(Conta conta) {
            String sql = "INSERT INTO CONTAS (NOME, SALDO, BANCO, AGENCIA, CONTA, TIPO_CONTA) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = conectar ();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, conta.getNome());
                pstmt.setBigDecimal(2, conta.getSaldo());
                pstmt.setString(3, conta.getBanco());
                pstmt.setString(4, conta.getAgencia());
                pstmt.setString(5, conta.getConta());
                pstmt.setString(6, conta.getTipoConta().name()); // Usa o name do enum

                pstmt.executeUpdate();
                System.out.println("org.example.Conta inserida com sucesso: " + conta.getNome());


            } catch (SQLException e) {
                System.out.println("Erro ao inserir conta: " + e.getMessage());
                e.printStackTrace();
            }
        }
        private Connection conectar() throws SQLException {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }

    }

