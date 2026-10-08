package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private String codigo;
    private String status;

    public Pedido(String codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}