/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.cr2;

import java.util.Map;

/**
 *
 * @author Pedro Vitor
 */
public class DescontoPorCupom implements IDesconto {
    private Map<String, Double> codigosDeDesconto;

    public DescontoPorCupom(Map<String, Double> codigosDeDesconto) {
        this.codigosDeDesconto = codigosDeDesconto;
    }

    @Override
    public double calcularDesconto(Pedido pedido) {
        String codigoDeCupom = pedido.getCodigoDeCupom();
        double valorPedido = pedido.getValorPedido();
        
        if (codigoDeCupom != null && codigosDeDesconto.containsKey(codigoDeCupom)) {
            return valorPedido * codigosDeDesconto.get(codigoDeCupom);
        }
        return 0.0;
    }
}