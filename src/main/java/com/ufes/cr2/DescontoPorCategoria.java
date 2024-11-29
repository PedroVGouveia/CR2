/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.cr2;

/**
 *
 * @author Pedro Vitor
 */

public class DescontoPorCategoria implements IDesconto {

        @Override
    public double calcularDesconto(Pedido pedido) {
        String categoriaCliente = pedido.getCliente().getTipo();
        double valorPedido = pedido.getValorPedido();

        if ("Ouro".equalsIgnoreCase(categoriaCliente)) {
            return valorPedido * 0.30;
        } else if ("Prata".equalsIgnoreCase(categoriaCliente)) {
            return valorPedido * 0.20;
        } else if ("Bronze".equalsIgnoreCase(categoriaCliente)) {
            return valorPedido * 0.10;
        }
        return 0.0;
    }
}