package ru.netology.afishaManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.afishaRepository.AfishaRepository;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository afishaRepository;
    @InjectMocks
    private AfishaManager afishaManager;
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
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
        afishaManager.add(fourth);
        afishaManager.add(fifth);
        afishaManager.add(sixth);
        afishaManager.add(seventh);
        afishaManager.add(eighth);
        afishaManager.add(ninth);
        afishaManager.add(tenth);
        afishaManager.add(eleventh);
        afishaManager.add(twelfth);
    }

    @Test
    public void removeById() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, sixth, seventh,
                eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(afishaRepository).findAll();
        doNothing().when(afishaRepository).removeById(5);

        afishaManager.removeById(5);
        PurchaseItem[] actual = afishaManager.reverse();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(afishaRepository).removeById(5);
    }

    @Test
    public void findAll() {     //- возвращает массив всех хранящихся в массиве объектов
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth,
                seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(afishaRepository).findAll();

        afishaManager.findAll();
        PurchaseItem[] actual = afishaManager.reverse();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}