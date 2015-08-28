import java.util.List;
import org.sql2o.*;

public class Stylist {
  private int id;
  private int client_id;
  private String name;

public int getId() {
  return id;
}

public int getClient_id() {
  return client_id;
}

public String getName() {
  return name;
}

public Stylist(String name, int client_id){
  this.name = name;
  this.client_id = client_id;
}

@Override
 public boolean equals(Object otherStylist) {
   if(!(otherStylist instanceof Stylist)) {
     return false;
   } else {
  Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getId() == newStylist.getId() &&
             this.getClient_id() == newStylist.getClient_id();
  }
}

public static List<Stylist> all() {
     String sql ="SELECT * FROM Stylist";
     try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Stylist.class);
     }
   }

}
