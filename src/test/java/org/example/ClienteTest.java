package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido("PED-101", "Pendente");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanharPedido(pedido);
        pedido.atualizarStatus("Pago");
        assertEquals("Cliente 1, status atualizado para Pedido{codigo='PED-101', status='Pago'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido = new Pedido("PED-101", "Pendente");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanharPedido(pedido);
        cliente2.acompanharPedido(pedido);
        pedido.atualizarStatus("Pago");
        assertEquals("Cliente 1, status atualizado para Pedido{codigo='PED-101', status='Pago'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, status atualizado para Pedido{codigo='PED-101', status='Pago'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido("PED-101", "Pendente");
        Cliente cliente = new Cliente("Cliente 1");
        pedido.atualizarStatus("Pago");
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientePedidoA() {
        Pedido pedidoA = new Pedido("PED-101", "Pendente");
        Pedido pedidoB = new Pedido("PED-102", "Pendente");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanharPedido(pedidoA);
        cliente2.acompanharPedido(pedidoB);
        pedidoA.atualizarStatus("Pago");
        assertEquals("Cliente 1, status atualizado para Pedido{codigo='PED-101', status='Pago'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}