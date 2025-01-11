import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.Constants.VOICE_CAT;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
        private Cat cat;

        @Mock
        Feline feline;

        @Before
        public void setUp() {
            cat = new Cat(feline);
        }

        @Test
        public void testGetSound() {
            String actual = cat.getSound();
            assertEquals("Голос не похож на кошачий",VOICE_CAT, actual);
        }

        @Test
        public void testGetFood() throws Exception {
            cat.getFood();
            Mockito.verify(feline).eatMeat();
        }
}
