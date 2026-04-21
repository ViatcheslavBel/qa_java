import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Test
    void getSoundShouldReturnMeow() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldCallEatMeat() throws Exception {
        Feline feline = mock(Feline.class);

        when(feline.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(feline);

        List<String> result = cat.getFood();

        assertEquals(List.of("Мясо"), result);
        verify(feline).eatMeat();
    }
}