import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;


    @BeforeEach
    void setUp() {
        // Создаем Cat с передачей мока Feline
        cat = new Cat(felineMock);
    }


    @Test
    public void getSound_ShouldReturnMeow() {
        boolean isValidReturnValue = cat.getSound().equals("Мяу");
        Assertions.assertTrue(isValidReturnValue, "Вернулось значение " + cat.getSound() + " вместо 'Мяу'");
    }


    @Test
    public void getFood_ShouldReturnFoodList() throws Exception {
        List<String> expectedFoodList = List.of("Meat", "Fish");
        when(felineMock.eatMeat()).thenReturn(expectedFoodList);
        List<String> actualFoodList = cat.getFood();
        Assertions.assertEquals(expectedFoodList, actualFoodList);
    }
}
