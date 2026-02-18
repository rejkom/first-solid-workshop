package edu.pg.qa.workshop.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Koszyk zakupowy przechowujący produkty.
 */
public class ShoppingCart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public List<String> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
