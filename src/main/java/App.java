import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
         Map<String, Object> model = new HashMap<String,Object>();

         model.put("client", Client.all());
         model.put("template", "templates/home.vtl");
         model.put("stylist", Stylist.all());
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

 post("/appointment_form", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/appointment_form.vtl");
    String name = request.queryParams("rName");
    int client_id = Integer.parseInt(request.queryParams("stylist_id"));
    Client myClient = new Client(name, 2);
    myClient.save();
    model.put("clients", Client.all());
    model.put("stylists", Stylist.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
 }
}
