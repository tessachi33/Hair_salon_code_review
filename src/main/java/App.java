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

         model.put("stylist", Stylist.all());
         model.put("template", "templates/home.vtl");
         model.put("client", Client.all());
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());
 }

 // post("/appointment", (request, response) -> {
 //    Map<String, Object> model = new HashMap<String, Object>();
 //    model.put("template", "templates/appointment_form.vtl");
 //    String name = request.queryParams("rName");
 //    int client_id = Integer.parseInt(request.queryParams("client_id"));
 //    String address = request.queryParams("rAddress");
 //    Stylist myStylist = new Stylist(name, client_id);
 //    myStylist.save();
 //    model.put("stylist", Stylist.all());
 //    model.put("client", Client.all());
 //    return new ModelAndView(model, layout);
 //  }, new VelocityTemplateEngine());
}
