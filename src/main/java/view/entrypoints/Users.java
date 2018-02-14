package view.entrypoints;

import common.ReviewDTO;
import common.ServerError;
import common.UserDTO;
import controller.Controller;
import view.rest.LoginResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class Users {
    //@Inject
    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO createUser(UserDTO userRequest) {
        try {
            controller.createUser(userRequest);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
        return userRequest;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(UserDTO userRequest) {
        return controller.login(userRequest) ? new LoginResponse(userRequest.getUsername(), "Login Success") : new LoginResponse(userRequest.getUsername(), "Login Failure");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO test() {
        return new UserDTO();
    }

    @GET
    @Path("/{username}/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewDTO> getReviews(@PathParam("username") String username) {
        return controller.getUsersReviews(username);
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("username") String username, UserDTO userRequest) {
        try {
            controller.updateUser(userRequest);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
    }
}
