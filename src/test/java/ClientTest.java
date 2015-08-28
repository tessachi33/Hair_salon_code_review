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
  @Test
  public void save_savesIntoDatabase_true() {
    Client myClient = new Client("mark");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void find_findClientInDatabase_true() {
    Client myClient = new Client("Jr");
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertTrue(myClient.equals(savedClient));
  }
}
