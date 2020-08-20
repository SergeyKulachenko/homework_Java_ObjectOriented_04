package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.PurchaseItem;

@Data
public class CartManager {
    private int numberLast = 10;
    private PurchaseItem[] items = new PurchaseItem[0];
    private PurchaseItem[] theLast = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public CartManager(int numberLast) {
        this.numberLast = numberLast;

        PurchaseItem[] temp = new PurchaseItem[0];
        int last = items.length;       //количество фильмов в ленте
        if (last <= numberLast) {
            temp = new PurchaseItem[last];
            System.arraycopy(items, 0, temp, 0, last);
        } else {
            if (numberLast == 10) {
                temp = new PurchaseItem[10];
                System.arraycopy(items, last - 10, temp, 0, 10);
            } else {
                temp = new PurchaseItem[numberLast];
                System.arraycopy(items, last - numberLast, temp, 0, numberLast);
            }

        }
        theLast = new PurchaseItem[temp.length];
        for (int i = 0; i < temp.length; i++) {
            int index = temp.length - i - 1;
            theLast[i] = temp[index];
        }
    }

    public void numLast(int numberLast) {
        this.numberLast = numberLast;

        PurchaseItem[] temp = new PurchaseItem[0];
        int last = items.length;       //количество фильмов в ленте
        if (last <= numberLast) {
            temp = new PurchaseItem[last];
            System.arraycopy(items, 0, temp, 0, last);
        } else {
            if (numberLast == 10) {
                temp = new PurchaseItem[10];
                System.arraycopy(items, last - 10, temp, 0, 10);
            } else {
                temp = new PurchaseItem[numberLast];
                System.arraycopy(items, last - numberLast, temp, 0, numberLast);
            }
        }
        theLast = new PurchaseItem[temp.length];
        for (int i = 0; i < temp.length; i++) {
            int index = temp.length - i - 1;
            theLast[i] = temp[index];
        }
    }


}
