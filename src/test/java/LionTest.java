import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    private Lion maleLion;
    private Lion femaleLion;


    @BeforeEach
    void setUp() throws Exception {
        maleLion = new Lion("Самец", felineMock);
        femaleLion = new Lion("Самка", felineMock);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void lionConstructor_ValidSexDoesNotThrowException(String validSex) {
        assertDoesNotThrow(() -> new Lion(validSex, felineMock));
    }


    @ParameterizedTest
    @ValueSource(strings = {"Львенок", "", "Львица"})
    void lionConstructor_InvalidSexThrowsException(String invalidSex) {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion(invalidSex, felineMock),
                "Для пола '" + invalidSex + "' должно быть исключение"
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @Test
    public void getKittens_ShouldReturnOneKitten() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(1, femaleLion.getKittens());
    }


    @Test
    public void getKittens_ShouldReturnKittensCount() throws Exception {
        when(felineMock.getKittens(3)).thenReturn(3);
        assertEquals(3, femaleLion.getKittens(3));
    }


    @Test
    public void doesHaveMane_ReturnTrueIfLionIsMale() {
        assertTrue(maleLion.doesHaveMane());
    }


    @Test
    public void doesHaveMane_ReturnFalseIfLionIsFemale() {
        assertFalse(femaleLion.doesHaveMane());
    }


    @Test
    public void getFood_ShouldReturnListOfFood() throws Exception {
        List<String> expectedFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFoodList);
        List<String> actualFoodList = maleLion.getFood();
        assertEquals(expectedFoodList, actualFoodList);
    }
}