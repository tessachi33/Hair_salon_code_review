import java.util.List;
import org.sql2o.*;

public class Stylist {
  private int id;
  private String name;

  public int getId() {
   return id;
   }

  public String getName(){
    return name;
  }

  public Stylist(String name) {
    this.name = name;
  }
public static List<Stylist> all() {
  String sql ="SELECT id, name FROM stylist";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Stylist.class);
  }
}
@Override
public boolean equals (Object otherStylist) {
  if(!(otherStylist instanceof Stylist)) {
    return false;
  } else {
    Stylist newStylist = (Stylist) otherStylist;
    return this.getName().equals(newStylist.getName());
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql  ="INSERT INTO stylist (name) VALUES (:name)";
    this.id = (int) con.createQuery(sql, true)
    .addParameter("name", name)
    .executeUpdate()
    .getKey();
  }
}

public static Stylist find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql ="SELECT * FROM stylist WHERE id=:id";
    Stylist stylist = con.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetchFirst(Stylist.class);
    return stylist;
  }
}

}
