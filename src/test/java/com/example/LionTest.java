package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeDependsOnSex(String sex, boolean expected) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(sex, feline);

        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    void constructorShouldThrowExceptionForInvalidSex() {
        Feline feline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @Test
    void getKittensShouldDelegateToFeline() throws Exception{
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        int count = lion.getKittens();

        assertEquals(3, count);
        verify(feline).getKittens();
    }

    @Test
    void getFoodShouldCallFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();

        assertEquals(List.of("Мясо"), food);
        verify(feline).getFood("Хищник");
    }
}