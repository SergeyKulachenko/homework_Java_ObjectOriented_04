package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.PurchaseItem;

@Data
public class CartManager {
    private int numberLast = 10;
    private PurchaseItem[] items = new PurchaseItem[0];
    private PurchaseItem[] reverseResult = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void reverse() {
        PurchaseItem[] result = new PurchaseItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        reverseResult = result;
    }

    public PurchaseItem[] showTheLast() {             //numberLast последних фильмов
        PurchaseItem[] tneLast = new PurchaseItem[numberLast];
        System.arraycopy(reverseResult, 0, tneLast, 0, numberLast);
        return tneLast;
    }

    public PurchaseItem[] showAll() {// "если фильмов меньше 10, то выдаёте столько, сколько есть."
        PurchaseItem[] showAll = new PurchaseItem[0];
        showAll = reverseResult;
        return showAll;
    }


}
