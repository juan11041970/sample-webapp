import com.jda.SmartPhone
import org.junit.Test
import spock.lang.Ignore

@Ignore
class SmartPhoneTest {

    SmartPhone sp = new SmartPhone()

    @Test
    public void testPhone() {

        assert 'dialing 555-1234' == sp.dial('555-1234')

    }

    @Test
    public void testCamera() {
        assert 'taking picture' == sp.takePicture()
    }

}
