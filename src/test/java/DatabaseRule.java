import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM Client *;";
      String sqlRestaurant = "DELETE FROM Stylist *;";
      con.createQuery(sql).executeUpdate();
      con.createQuery(sqlRestaurant).executeUpdate();


    }
  }
}
