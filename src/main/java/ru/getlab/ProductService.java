package ru.getlab;

public class ProductService { // класс сервис работы с продуктами
    private static final ProductFactory productFactory = new ProductFactory(); // инжектим нашу фабрику для работы с продуктами

    public Product selectProduct(int productChoice) { // метод для выбора продукта

        switch (productChoice) { // блок свич кейса для выбора продукта
            case 1 -> {
                return productFactory.getProduct(0);
            }
            case 2 -> {
                return productFactory.getProduct(1);
            }
            case 3 -> {
                return productFactory.getProduct(2);
            }
            case 4 -> {
                return productFactory.getProduct(3);
            }
            case 5 -> {
                return productFactory.getProduct(4);
            }
            default -> {
                System.out.println("Неверный выбор продукта.");
                return null; // вернуть нал если неправильный выбор был
            }
        }
    }

    public void getProductList() { // метод для получения списка продуктов
        productFactory.getProductList(); // запрашиваем у фабрики список продуктов
    }

    public double getTotalPrice(Product product, int quantity) { // метод для просчета общей суммы
        return product.getPrice() * quantity; // высчитываем и возвращаем значение общей суммы
    }
}