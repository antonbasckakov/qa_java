import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.Constants.*;
import static com.example.Constants.CAT_COUNTS;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        assertEquals("Не семейство кошачьих", ANIMAL_CAT, actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(CAT_COUNT);
        assertEquals("Количество кошачьих отличается",
                CAT_COUNT, actual);
    }

    @Test
    public void testTestGetKittens() {
        int actual = feline.getKittens(CAT_COUNTS);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Количество кошачьих отличается",
                CAT_COUNTS, actual);
    }
}
