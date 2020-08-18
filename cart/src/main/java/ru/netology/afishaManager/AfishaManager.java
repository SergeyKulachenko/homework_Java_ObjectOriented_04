package ru.netology.afishaManager;

import ru.netology.afishaRepository.AfishaRepository;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;


public class AfishaManager {

    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] reverse() {
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findAll() {
        repository.findAll();
    }

    }
