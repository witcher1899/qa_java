import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline felineMock;

    @Spy
    Feline felineSpy;

    @Test
    public void eatMeat_ShouldCallMethod() throws Exception {
        felineMock.eatMeat();
        verify(felineMock).eatMeat();
    }


    @Test
    public void eatMeat_ShouldReturnListOfFelineFood() throws Exception {
        List<String> expectedResult = felineSpy.eatMeat();
        List<String> actualResult = Arrays.asList("Животные", "Птицы", "Рыба");
        boolean isEqualIgnoreOrder = expectedResult.size() == actualResult.size()
                && expectedResult.containsAll(actualResult);
        Assertions.assertTrue(isEqualIgnoreOrder, "Вернулся список: " + actualResult + " вместо " + expectedResult);
    }


    @Test
    public void getFamily_ShouldCallMethod() {
        felineMock.getFamily();
        verify(felineMock).getFamily();
    }


    @Test
    public void getFamily_ShouldReturnKittensFamily() {
        boolean isCorrectReturnValue = felineSpy.getFamily().equals("Кошачьи");
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + felineSpy.getFamily() + " вместо 'Кошачьи'");
    }


    @Test
    public void getKittens_ShouldCallMethodWithoutArguments() {
        felineMock.getKittens();
        verify(felineMock).getKittens();
    }


    @Test
    public void getKittens_ShouldReturn1() {
        boolean isCorrectReturnValue = felineSpy.getKittens() == 1;
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + felineSpy.getKittens() + " вместо 1");
    }


    @Test
    public void getKittens_ShouldCallMethodWithArguments() {
        felineMock.getKittens(3);
        verify(felineMock).getKittens(3);
    }

    @Test
    public void getKittens_ShouldReturnKittensCount() {
        boolean isCorrectReturnValue = felineSpy.getKittens(3) == 3;
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + felineSpy.getKittens(3) + " вместо 3");
    }
}
