package view.entrypoints;

import common.ReviewDTO;
import common.UserDTO;
import controller.Controller;
import view.rest.LoginResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class Users {

    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(UserDTO userRequest) {
        controller.createUser(userRequest);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(UserDTO userRequest) {
        return controller.login(userRequest) ? new LoginResponse(userRequest.getUsername(), "Login Success") : new LoginResponse(userRequest.getUsername(), "Login Failure");
    }

    @GET
    @Path("/{username}/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewDTO> getReviews(@PathParam("username") String username) {
        return controller.getReviews(username);
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("username") String username, UserDTO userRequest) {
        controller.updateUser(userRequest);
    }

}
