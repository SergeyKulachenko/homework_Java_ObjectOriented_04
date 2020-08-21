package ru.netology.afishaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.afishaManager.AfishaManager;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();
    private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
    private PurchaseItem fourth = new PurchaseItem(4, 4, "fourth", 1, 1);
    private PurchaseItem fifth = new PurchaseItem(5, 5, "fifth", 1, 1);
    private PurchaseItem sixth = new PurchaseItem(6, 6, "sixth", 1, 1);
    private PurchaseItem seventh = new PurchaseItem(7, 7, "seventh", 1, 1);
    private PurchaseItem eighth = new PurchaseItem(8, 8, "eighth", 1, 1);
    private PurchaseItem ninth = new PurchaseItem(9, 9, "ninth", 1, 1);
    private PurchaseItem tenth = new PurchaseItem(10, 10, "tenth", 1, 1);
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "eleventh", 1, 1);
    private PurchaseItem twelfth = new PurchaseItem(12, 12, "twelfth", 1, 1);

    @BeforeEach
    public void setUp() {
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(fourth);
        afishaRepository.save(fifth);
        afishaRepository.save(sixth);
        afishaRepository.save(seventh);
        afishaRepository.save(eighth);
        afishaRepository.save(ninth);
        afishaRepository.save(tenth);
        afishaRepository.save(eleventh);
        afishaRepository.save(twelfth);
        //  afishaRepository.reverse();
    }

    @Test
    public void findAll() {     //- возвращает массив всех хранящихся в массиве объектов
        afishaRepository.reverse();
        PurchaseItem[] actual = afishaRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        PurchaseItem actual = afishaRepository.findById(3);
        PurchaseItem expected = third;
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNull() {
        PurchaseItem actual = afishaRepository.findById(13);
        PurchaseItem expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void removeById() {
        afishaRepository.removeById(5);
        PurchaseItem[] actual = afishaRepository.reverse();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll() {
        PurchaseItem[] actual = afishaRepository.removeAll();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(expected, actual);
    }
}