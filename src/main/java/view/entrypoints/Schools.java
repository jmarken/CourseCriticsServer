package view.entrypoints;

import controller.Controller;
import view.rest.SchoolRest;
import view.rest.ReviewRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/schools")
public class Schools {

    private Controller controller = new Controller();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SchoolRest> getSchools() {
        return controller.getSchools();
    }

}
