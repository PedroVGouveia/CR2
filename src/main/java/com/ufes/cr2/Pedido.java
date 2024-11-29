/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.cr2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pedro Vitor
 */
public class Pedido {
private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoDeCupom;
    private final List<Item> itens = new ArrayList<>();
    private final Map<String, Double> codigosDeDesconto;
    private double descontoAplicado;

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        if (taxaEntrega < 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }

        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.descontoAplicado = 0;

        this.codigosDeDesconto = Map.of(
            "DESC10", 0.10,
            "DESC20", 0.20,
            "DESC30", 0.30
        );
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double getValorPedido() {
        double valorPedido = 0.0;
        for (Item item : itens) {
            valorPedido += item.getValorTotal();
        }
        return valorPedido + taxaEntrega;
    }

    public void setCodigoDeCupom(String codigoDeCupom) {
        this.codigoDeCupom = codigoDeCupom;
    }

    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }

    public Map<String, Double> getCodigosDeDesconto() {
        return codigosDeDesconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    public void setDescontoAplicado(double descontoAplicado) {
        this.descontoAplicado = descontoAplicado;
    }

    public double calcularDesconto() {
        IDesconto descontoPorCategoria = new DescontoPorCategoria();
        IDesconto descontoPorCupom = new DescontoPorCupom(codigosDeDesconto); 
        IDesconto descontoPorTipoDeItem = new DescontoPorTipoDeItem();


        double desconto = descontoPorCupom.calcularDesconto(this);
        if (desconto > 0) {
            setDescontoAplicado(desconto);
            return desconto;
        }


        desconto = descontoPorCategoria.calcularDesconto(this);
        if (desconto > 0) {
            setDescontoAplicado(desconto);
            return desconto;
        }

        desconto = descontoPorTipoDeItem.calcularDesconto(this);
        setDescontoAplicado(desconto);
        return desconto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "taxaEntrega=" + taxaEntrega +
                ", cliente=" + cliente + 
                ", itens=" + itens +     
                '}';
    }
}

