import com.example.Lion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Spy;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LionTest {

    @Spy
    Lion lionSpy = new Lion("Самец");

    @Mock
    Lion lionMock = mock(Lion.class);

    public LionTest() throws Exception {
    }

    //Тест на отсутствие ошибки при создании валидного объекта класса Lion
    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void lionConstructor_ValidSexDoesNotThrowException(String validSex) {
        assertDoesNotThrow(() -> new Lion(validSex));
    }


    //Тест на ошибку при создании невалидного объекта класса Lion
    @ParameterizedTest
    @ValueSource(strings = {"Львенок", "", "Львица"})
    void lionConstructor_InvalidSexThrowsException(String invalidSex) {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion(invalidSex),
                "Для пола '" + invalidSex + "' должно быть исключение"
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage()
        );
    }



    //Далее будут тест на проверку методов
    @Test
    public void getKittens_ShouldCallMethodWithoutArguments() {
        lionMock.getKittens();
        verify(lionMock).getKittens();
    }


    @Test
    public void getKittens_ShouldReturn1() {
        boolean isCorrectReturnValue = lionSpy.getKittens() == 1;
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + lionSpy.getKittens() + " вместо 1");
    }

    @Test
    public void getKittens_ShouldCallMethodWithArguments() {
        lionMock.getKittens(3);
        verify(lionMock).getKittens(3);
    }

    @Test
    public void getKittens_ShouldReturnKittensCount() {
        boolean isCorrectReturnValue = lionSpy.getKittens(3) == 3;
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + lionSpy.getKittens(3) + " вместо 3");
    }


    @Test
    public void doesHaveMane_ReturnTrueIfLionIsMail() throws Exception {
        Lion lion = new Lion("Самец");
        Assertions.assertTrue(lion.doesHaveMane(), "Должно вернуться значение 'Самец' вместо " + lion.doesHaveMane());
    }


    @Test
    public void doesHaveMane_ReturnFalseIfLionIsFemail() throws Exception {
        Lion lion = new Lion("Самка");
        Assertions.assertFalse(lion.doesHaveMane(), "Должно вернуться значение 'Самка' вместо " + lion.doesHaveMane());
    }


    @Test
    public void getFood_ShouldCallMethod() throws Exception {
        lionMock.getFood("Хищник");
        verify(lionMock).getFood("Хищник");
    }


    @Test
    public void getFood_ShouldReturnListOfFelineFood() throws Exception {
        List<String> expectedResult = lionSpy.getFood();
        List<String> actualResult = Arrays.asList("Животные", "Птицы", "Рыба");
        boolean isEqualIgnoreOrder = expectedResult.size() == actualResult.size()
                && expectedResult.containsAll(actualResult);
        Assertions.assertTrue(isEqualIgnoreOrder, "Вернулся список: " + actualResult + " вместо " + expectedResult);
    }


    @Test
    public void eatMeat_ShouldCallMethod() throws Exception {
        lionMock.eatMeat();
        verify(lionMock).eatMeat();
    }


    @Test
    public void eatMeat_ShouldReturnListOfFelineFood() throws Exception {
        List<String> expectedResult = lionSpy.eatMeat();
        List<String> actualResult = Arrays.asList("Животные", "Птицы", "Рыба");
        boolean isEqualIgnoreOrder = expectedResult.size() == actualResult.size()
                && expectedResult.containsAll(actualResult);
        Assertions.assertTrue(isEqualIgnoreOrder, "Вернулся список: " + actualResult + " вместо " + expectedResult);
    }
}