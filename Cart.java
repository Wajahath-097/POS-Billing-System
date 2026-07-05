import java.util.ArrayList;

public class Cart {

    ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product p) {

        for (CartItem item : items) {
            if (item.product.id == p.id) {
                item.quantity++;
                return;
            }
        }

        items.add(new CartItem(p, 1));
    }

    public void decreaseItem(Product p) {

        for (int i = 0; i < items.size(); i++) {

            CartItem item = items.get(i);

            if (item.product.id == p.id) {

                item.quantity--;

                if (item.quantity <= 0) {
                    items.remove(i);
                }

                return;
            }
        }
    }

    public double getTotal() {

        double total = 0;

        for (CartItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    public double getGST() {
        return getTotal() * 0.025;
    }

    public double getCGST() {
        return getTotal() * 0.025;
    }

    public double getGrandTotal() {
        return getTotal() + getGST() + getCGST();
    }

    public void clear() {
        items.clear();
    }
}