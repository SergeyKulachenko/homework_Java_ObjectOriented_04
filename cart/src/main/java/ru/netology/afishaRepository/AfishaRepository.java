package ru.netology.afishaRepository;

import ru.netology.domain.PurchaseItem;

public class AfishaRepository {

    private PurchaseItem[] purchaseItem = new PurchaseItem[0];

    public void save(PurchaseItem item) {         // добавляет объект в массив
        int length = purchaseItem.length + 1;
        PurchaseItem[] temp = new PurchaseItem[length];
        System.arraycopy(purchaseItem, 0, temp, 0, purchaseItem.length);
        int a = temp.length - 1;
        temp[a] = item;
        purchaseItem = temp;
    }

    private PurchaseItem[] reverseResult = new PurchaseItem[0];

    public PurchaseItem[] reverse() {
        PurchaseItem[] result = new PurchaseItem[purchaseItem.length];
        for (int i = 0; i < result.length; i++) {
            int index = purchaseItem.length - i - 1;
            result[i] = purchaseItem[index];
        }
        reverseResult = result;
        return reverseResult;
    }

    public PurchaseItem[] findAll() {      //- возвращает массив всех хранящихся в массиве объектов

        return reverseResult;//purchaseItem;
    }

    public Object findById(int id) {     // - возвращает объект по идентификатору (либо null, если такого объекта нет)
        PurchaseItem find = new PurchaseItem();
        int a = -1;
        for (PurchaseItem item : this.purchaseItem) {
            a++;
            if (id == item.getId()) {
                find = purchaseItem[a];
                return find;
            }
        }
        return null;
    }

    public void removeById(int id) {   //- удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
        PurchaseItem[] temp = new PurchaseItem[purchaseItem.length - 1];
        int a = 0, b = -1;
        for (PurchaseItem item : purchaseItem) {
            b++;
            if (id != item.getId()) {
                temp[a] = purchaseItem[b];
                a++;
            }
        }
        purchaseItem = temp;
       // return purchaseItem;
    }

    public PurchaseItem[] removeAll() { // - полностью вычищает репозиторий
        PurchaseItem[] removeAll = new PurchaseItem[0];
        purchaseItem = removeAll;
        return purchaseItem;
    }
}
