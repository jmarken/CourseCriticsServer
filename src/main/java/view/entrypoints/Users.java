package view.entrypoints;

import controller.Controller;
import view.rest.CourseRest;
import view.rest.ReviewRest;
import view.rest.UserPrivateRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class Users {

    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(CourseRest courseRequest) {
        controller.createUser(courseRequest);
    }

    @GET
    @Path("/{username}/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewRest> getReviews(@PathParam("username") String username) {
        return controller.getReviews(username);
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateCourse(@PathParam("username") String username, UserPrivateRest userRequest) {
        controller.updateUser(username, userRequest);
    }

}
