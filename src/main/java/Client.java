import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;

  public int getId() {
   return id;
   }

  public String getName(){
    return name;
  }

  public Client(String name) {
    this.name = name;
  }
public static List<Client> all() {
  String sql ="SELECT id, name FROM client";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Client.class);
  }
}
@Override
public boolean equals (Object otherClient) {
  if(!(otherClient instanceof Client)) {
    return false;
  } else {
    Client newClient = (Client) otherClient;
    return this.getName().equals(newClient.getName());
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql  ="INSERT INTO client (name) VALUES (:name)";
    this.id = (int) con.createQuery(sql, true)
    .addParameter("name", name)
    .executeUpdate()
    .getKey();
  }
}

}
