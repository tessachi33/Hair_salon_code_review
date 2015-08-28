import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private int stylist_id;

public int getId() {
  return id;
}

public int getStylist_id() {
  return stylist_id;
}

public String getName() {
  return name;
}

public Client(String name, int stylist_id){
  this.name = name;
  this.stylist_id = stylist_id;
}

@Override
 public boolean equals(Object otherClient) {
   if(!(otherClient instanceof Client)) {
     return false;
   } else {
  Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getId() == newClient.getId() &&
             this.getStylist_id() == newClient.getStylist_id();
  }
}

public static List<Client> all() {
     String sql ="SELECT * FROM client";
     try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Client.class);
     }
   }
public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql ="INSERT INTO client (name, stylist_id) VALUES (:name, :stylist_id)";
    this.id = (int) con.createQuery(sql, true)
    .addParameter("name", name)
    .addParameter("stylist_id", stylist_id)
    .executeUpdate()
    .getKey();
  }
}
public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM client WHERE id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void update(String name, int stylist_id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE stylist SET name = :name WHERE id=:id";
    con.createQuery(sql)
      .addParameter("id", id)
      .addParameter("name", name)
      .addParameter("stylist_id", stylist_id)
      .executeUpdate();
  }
}

public String getStylistName() {
  try(Connection con = DB.sql2o.open()){
    String sql = "SElECT name FROM stylist WHERE id = :id;";
    return con.createQuery(sql)
    .addParameter("id", stylist_id)
    .executeAndFetchFirst(String.class);
  }
}

public void delete() {
  try(Connection con = DB.sql2o.open()){
    String sql = "DELETE FROM client WHERE id = :id;";
    con.createQuery(sql)
    .addParameter("id", id)
    .executeUpdate();
  }
}



}
