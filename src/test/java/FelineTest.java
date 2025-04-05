import com.example.Feline;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();


    @Test
    public void eatMeat_ShouldReturnValidListOfFood() throws Exception {
       List<String> actualFoodList = feline.eatMeat();
       List<String> expectedFoodList = Arrays.asList("Животные,Птицы,Рыба".split(","));
       Assertions.assertEquals(expectedFoodList, actualFoodList, "Вернулся список: " + actualFoodList + " вместо " + expectedFoodList);
   }


    @Test
    public void getFamily_ShouldReturnKittensFamily() {
        boolean isValidReturnValue = feline.getFamily().equals("Кошачьи");
        Assertions.assertTrue(isValidReturnValue, "Вернулось значение " + feline.getFamily() + " вместо 'Кошачьи'");
    }


    @Test
    public void getKittens_ShouldReturnOneKitten() {
        boolean isValidReturnValue = feline.getKittens() == 1;
        Assertions.assertTrue(isValidReturnValue, "Вернулось значение " + feline.getKittens() + " вместо 1");
    }


    @Test
    public void getKittens_ShouldReturnKittensCount() {
        boolean isValidReturnValue = feline.getKittens(3) == 3;
        Assertions.assertTrue(isValidReturnValue, "Вернулось значение " + feline.getKittens(3) + " вместо 3");
    }
}
