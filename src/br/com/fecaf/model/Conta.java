package br.com.fecaf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private  int numeroConta;
    private String agencia = "2008-XX";
    String password, confirmPassword;
    private double saldo  = 0;
    private  Cliente cliente;

    List<Conta> listContas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void gerarConta (Cliente cliente) {
        System.out.println("/----------------------------- Gerando conta ------------------------/");
        numeroConta = (int) (Math.random()*10000);
        System.out.println("Informe uma senha: ");
        password = scanner.nextLine();

        do {
            System.out.print("Confirme a senha: ");
            confirmPassword = scanner.nextLine();

            if (password != confirmPassword) {
                System.out.println("Revise a senha: ");
            }

        } while (password != confirmPassword);

        System.out.println("/-----------------------------------------------------------------------/");

        this.cliente = cliente;
    }

    public  void realizarSaque (double valor) {
        boolean validaSaque  = avaliarSaque(valor);

        if (validaSaque) {
            this.saldo -= valor;

        } else {
            System.out.println("Imposível realizar o saque: ");
        }

        System.out.println("O saldo disponível na conta é: " + this.saldo);

    }

    public boolean avaliarSaque (double valor) {
        if (this.saldo >= valor) {
            return  true;
        }
        return false;
    }

    public void realizarDeposito (double valor) {
        this.saldo += valor;
        System.out.println("O saldo disponível na conta é:" + this.saldo);
    }

    public void consultarSaldo () {
        System.out.println("O saldo disponível na conta é:" + this.saldo);

    }

    public void adicionarList (Conta conta) {
        listContas.add(conta);
    }

    public  Conta pesquisarConta (Cliente cliente){
        for (Conta conta : listContas) {
            if (cliente == conta.cliente){
                return conta;
            }
        }
        return null;
    }

    public void exibirPerfil (Conta conta) {
        System.out.println("/---------------------------------------------------");
        System.out.println("Olá " + conta.cliente.getNome() + " !");
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Conta " + conta.getNumeroConta());
        System.out.println("/---------------------------------------------------");
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**public void transferir () {

    }**/
}
