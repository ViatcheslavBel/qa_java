import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void getFamilyShouldReturnCorrectValue() {
        Feline feline = new Feline();

        String family = feline.getFamily();

        assertEquals("Кошачьи", family);
    }

    @Test
    void getKittensDefaultShouldReturnOne() {
        Feline feline = new Feline();

        int count = feline.getKittens();

        assertEquals(1, count);
    }

    @Test
    void getKittensWithParamShouldReturnGivenValue() {
        Feline feline = new Feline();

        int count = feline.getKittens(7);

        assertEquals(7, count);
    }
}
