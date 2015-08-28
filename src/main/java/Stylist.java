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
public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql ="INSERT INTO stylist (name, client_id) VALUES (:name, :client_id)";
    this.id = (int) con.createQuery(sql, true)
    .addParameter("name", this.name)
    .addParameter("client_id", this.client_id)
    .executeUpdate()
    .getKey();
  }
}
public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylist WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void update(String name) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE stylist SET name = :name WHERE id=:id";
    con.createQuery(sql)
      .addParameter("id", id)
      .addParameter("name", name)
      .executeUpdate();
  }
}
//
// public String getClientName() {
//   try(Connection con = DB.sql2o.open()){
//     String sql = "SElECT name FROM client WHERE id = :id;";
//     return con.createQuery(sql)
//     .addParameter("id", client_id)
//     .executeAndFetchFirst(String.class);
//   }
// }
//
// public void delete() {
//   try(Connection con = DB.sql2o.open()){
//     String sql = "DELETE FROM stylist WHERE id = :id;";
//     con.createQuery(sql)
//     .addParameter("id", id)
//     .executeUpdate();
//   }
// }



}
