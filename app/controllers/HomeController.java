package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import exceptions.CreateException;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    private final HomeFacade homeFacade;

    @Inject
    public HomeController(HomeFacade homeFacade) {
        this.homeFacade = homeFacade;
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result addEditFurOrder() {
        homeFacade.addEditFurOrder(request().body().asJson());
        return ok();
    }

    public Result getFur() {
        return  ok(views.html.fur.render());
    }
    public Result getAllFur() {
        /*"draw": 1,
                "recordsTotal": 57,
                "recordsFiltered": 57,
                "data":*/
        ObjectNode response = Json.newObject();
        response.set("data", homeFacade.getAllFur());
        return ok(response);
    }
}
