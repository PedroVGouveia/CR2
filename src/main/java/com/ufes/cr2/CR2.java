/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes.cr2;
import java.time.LocalDate;

/**
 *
 * @author Pedro Vitor
 */
public class CR2 {

    public static void main(String[] args) {
        

        Cliente cliente = new Cliente("Pedro Vitor", "Ouro");


        Item item1 = new Item("Alimentação", 35.0);
        Item item2 = new Item("Lazer", 50.0);
        Item item3 = new Item("Educação", 50.0);


        Pedido pedido = new Pedido(135.0, LocalDate.now(), cliente);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);

        pedido.setCodigoDeCupom("DESC20");


        System.out.println(pedido.toString());
        /*System.out.println("Valor Total (sem desconto): R$ " + String.format("%.2f", pedido.getValorPedido()));
        double desconto = pedido.calcularDesconto();
        System.out.println("Desconto aplicado: R$ " + String.format("%.2f", desconto));
        System.out.println("Valor Total (com desconto): R$ " + String.format("%.2f", pedido.getValorPedido() - desconto));*/
    }
    
}
