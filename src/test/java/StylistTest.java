import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
   assertEquals(Stylist.all().size(), 0);
  }

  @Test
   public void equals_returnsTrueIfNameAreTheSame() {
    Stylist firstStylist = new Stylist("Kelly", 1);
    Stylist secondStylist = new Stylist("Kelly", 1);
    assertTrue(firstStylist.equals(secondStylist));
    }

  @Test
    public void save_saveObjectIntoDatabase_true() {
     Stylist myStylist = new Stylist("Kelly", 1);
     myStylist.save();
     assertTrue(Stylist.all().get(0).equals(myStylist));
     }

  @Test
    public void save_assignsIdtoObject() {
     Stylist myStylist = new Stylist("Kelly", 1);
     myStylist.save();
     Stylist savedStylist = Stylist.all().get(0);
     assertEquals(myStylist.getId(), savedStylist.getId());
     }

  @Test
   public void find_findsStylistInDatabase_true() {
     Stylist myStylist = new Stylist("Kelly", 1);
     myStylist.save();
     //Stylist savedStylist = Stylist.all().get(0);
     Stylist savedStylist= Stylist.find(myStylist.getId());
     assertTrue(myStylist.equals(savedStylist));
     }

      //  @Test
      //  public void save_savesClient_idIntoDB_true() {
      //    Client myClient = new Client("jo");
      //    myClient.save();
    //      Stylist myStylist = new Stylist("Kelly", 1);
      //    savedStylist.save();
        //  Stylist savedStylist= Stylist.find(myStylist.getId());
      //    assertEquals(savedStylist.getClient_id(), myClient.getId());
      //  }
       //
      //  @Test
      //  public void update_updateRestaurantInfo() {
      //      Stylist myStylist = new Stylist("Kelly", 1);
      //    savedStylist.save();
      //    savedStylist.update
  //      Stylist myStylist = new Stylist("makr", 3);
    //    assertTrue(Stylist.all().get(0).equals(savedStylist));
      //  }
       //
      //  @Test
      //  public void delete_deleteStylistFromDatabase() {
      //    Stylist myStylist = new Stylist("kelly", 1);
      //    myStylist.save();
      //    myStylist.delete();
      //    assertEquals(stylist.all().size(), 0);
       //}


}
