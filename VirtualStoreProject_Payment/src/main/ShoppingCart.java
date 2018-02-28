package main;

import data.Item;
import data.Product;

import java.util.*;

public class ShoppingCart {

    private final List<Item> itensList;

    public ShoppingCart(){
        itensList = new ArrayList<>();
    }

    public void addItemAtList(Product product, int quantityItem){
        final Optional<Item> item = itensList.stream()
                .filter(i -> i.getProductItem().equals(product))
                .findFirst();
        if (item.isPresent()){
            item.get().increment(quantityItem);
        }else {
            itensList.add(new Item(quantityItem, product));
        }
    }

    public List<Item> getItensList() {
        return Collections.unmodifiableList(itensList);
    }

    public double getTotal() {
        return itensList.stream().mapToDouble(Item::getSubtotal).sum();
    }
}
