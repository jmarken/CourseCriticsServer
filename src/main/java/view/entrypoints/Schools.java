package view.entrypoints;

import common.SchoolDTO;
import controller.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/schools")
public class Schools {

    private Controller controller = new Controller();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SchoolDTO> getSchools() {
        return controller.getSchools();
    }

}
