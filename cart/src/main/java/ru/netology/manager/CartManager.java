package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.PurchaseItem;

@Data
public class CartManager {
    private int numberLast = 10;
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public CartManager(int numberLast) {
        if (numberLast > 0) {
            this.numberLast = numberLast;
        }

    }

    public PurchaseItem[] numLastW() {
        int askedFilms = items.length;   //количество фильмов в ленте

        if (numberLast < items.length) {
            askedFilms = numberLast;
        }

        PurchaseItem[] result = new PurchaseItem[askedFilms];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


}
