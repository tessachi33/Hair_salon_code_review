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

       get("/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("stylist", Stylist.all());
          model.put("template", "templates/appointment_form.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/appointment_form", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/home.vtl");
          String name = request.queryParams("rName");
          int stylist_id = Integer.parseInt(request.queryParams("stylist_id"));
          Client myClient = new Client(name, stylist_id);
          myClient.save();
          model.put("client", Client.all());
          model.put("stylist", Stylist.all());
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
  }
}
