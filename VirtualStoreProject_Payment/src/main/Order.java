package main;

import data.Client;
import data.Item;

import java.time.LocalDateTime;
import java.util.*;

public class Order {

    private LocalDateTime orderDate;
    private final List<Item> itens;

    public Order(List<Item> itens) {
        this.itens = new ArrayList<>(itens);
        this.orderDate  = LocalDateTime.now();
    }

    public double getTotal() {
        return itens.stream().mapToDouble(Item::getSubtotal).sum();
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
