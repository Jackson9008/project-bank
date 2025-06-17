package br.com.fecaf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    // Encapsulamento
    private String nome;
    private long cpf, rg, telefone;

    // Instanciar Scanner
    Scanner scanner = new Scanner(System.in);

    // List
    List<Cliente> listClientes = new ArrayList<>();

    public void cadastrarClientes () {
        System.out.println("/------------------- Cadastrar Cliente---------------------/");
        System.out.println("Informe o nome: ");
        nome = scanner.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = scanner.nextLong();
        System.out.println("Informe o RG: ");
        rg = scanner.nextLong();
        System.out.println("Informe o Telefone: ");
        telefone = scanner.nextLong();
        scanner.nextLine();
        System.out.println("/----------------------------------------------------------/");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void adicionarClientes (Cliente cliente){
        listClientes.add(cliente);
    }

    public void listarClientes () {
        for (Cliente cliente : listClientes) {
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
        }
    }

    public Cliente pesquisarCliente (long cpf) {
        for (Cliente cliente : listClientes) {
            long cpfCliente = cliente.getCpf();

            if (cpfCliente == cpf) {
                return cliente;
            }
        }
        return null;
    }
}
