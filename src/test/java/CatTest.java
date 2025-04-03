import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Spy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatTest {

    private Feline feline;
    @Spy
    Cat catSpy = new Cat(feline);

    @Mock
    Cat catMock = mock(Cat.class);

    @Test
    public void getSound_ShouldCallMethodWithoutArguments() {
        catMock.getSound();
        verify(catMock).getSound();
    }

    @Test
    public void getSound_ShouldReturnString() {
        boolean isCorrectReturnValue = catSpy.getSound().equals("Мяу");
        Assertions.assertTrue(isCorrectReturnValue, "Вернулось значение " + catSpy.getSound() + " вместо 'Мяу'");
    }

    @Test
    public void getFood_ShouldCallMethodWithoutArguments() throws Exception {
        catMock.getFood();
        verify(catMock).getFood();
    }
}
