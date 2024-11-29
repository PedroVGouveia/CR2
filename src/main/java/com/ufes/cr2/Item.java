/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.cr2;

/**
 *
 * @author Pedro Vitor
 */
public class Item {
private String nome;
    private String tipo; 
    private double valorUnitario;
    private int quantidade;

    public Item(String nome, double valorUnitario) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }
    
        @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", valor=" + valorUnitario +
                '}';
    }
}
