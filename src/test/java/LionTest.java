import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.Constants.*;
import static com.example.Constants.MALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE,
                feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> {lion = new Lion(USUPPORTED_SEX, feline);});
        assertThat(throwable).isInstanceOf(Exception.class).hasMessage(TEXT_EXCEPTION_1);
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
