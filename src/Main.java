public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 10, ProductType.EXPIRABLE, false, true, 200);
        Product biscuits = new Product("Biscuits", 100, 10, ProductType.EXPIRABLE, false, true, 700);
        Product scratchCard = new Product("Scratch Card", 50, 10, ProductType.NON_EXPIRABLE, false, false, 0.0);

        Customer customer = new Customer("Yasmeen", 1000);
        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(scratchCard, 1);

        Checkout service = new Checkout();
        service.checkout(customer, cart);
    }
}
