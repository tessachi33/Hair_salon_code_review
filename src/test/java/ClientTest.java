import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNameAreTheSame() {
    Client firstClient = new Client ("mark");
    Client secondClient = new Client ("mark");
    assertTrue(firstClient.equals(secondClient));
  }

}
