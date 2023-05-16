package org.example;

public class Purchase {
    Product product;
    int quantity;

    Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getAmount() {
        return this.product.price * this.quantity;
    }

    public String toString() {
        return product.name + ", " + quantity + ", " + getAmount();
    }

}
