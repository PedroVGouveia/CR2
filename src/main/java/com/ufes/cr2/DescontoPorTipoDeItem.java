/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.cr2;

import java.util.List;

/**
 *
 * @author Pedro Vitor
 */
public class DescontoPorTipoDeItem implements IDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        double valorPedido = pedido.getValorPedido();
        List<Item> itens = pedido.getItens();

        boolean algumDescontoAplicado = (pedido.getDescontoAplicado() > 0);

        if (algumDescontoAplicado) {
            return 0.0;
        }

        double descontoTotal = 0.0;
        for (Item item : itens) {
            switch (item.getTipo()) {
                case "Alimentação" -> descontoTotal += item.getValorTotal() * 0.05;
                case "Educação" -> descontoTotal += item.getValorTotal() * 0.20;
                case "Lazer" -> descontoTotal += item.getValorTotal() * 0.15;
            }
        }
        return descontoTotal;
    }
}
