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
    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(UserDTO userRequest) {
        try {
            controller.createUser(userRequest);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(UserDTO userRequest) {
        System.out.println(userRequest.getUsername() + " " + userRequest.getPassword());
        controller.login(userRequest);
        return controller.login(userRequest) ? new LoginResponse(userRequest.getUsername(), "Login Success") : new LoginResponse(userRequest.getUsername(), "Login Failure");
    }

    @POST
    @Path("/{username}/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public void createReview(@PathParam("username") String username, view.rest.ReviewDTO reviewRequest) {
        System.out.println(reviewRequest.toString());
        try {
            ReviewDTO reviewDTO = new ReviewDTO(
                    reviewRequest.getCourse(),
                    reviewRequest.getSchool(),
                    username,
                    Integer.parseInt(reviewRequest.getQuality()),
                    Integer.parseInt(reviewRequest.getRelevance()),
                    Integer.parseInt(reviewRequest.getDifficulty()),
                    Integer.parseInt(reviewRequest.getTeaching()),
                    reviewRequest.getComment(),
                    reviewRequest.getProgram(),
                    Boolean.parseBoolean(reviewRequest.getLecturesRequired()),
                    Boolean.parseBoolean(reviewRequest.getBookRequired()),
                    Boolean.parseBoolean(reviewRequest.getGroupWork()),
                    Integer.parseInt(reviewRequest.getTimeSpent())
            );
            System.out.println(reviewDTO.toString());
            controller.createReview(reviewDTO);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
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
    public void updateUser(UserDTO userRequest) {
        try {
            controller.updateUser(userRequest);
        } catch (Exception e) {
            throw new ServerError(e.getMessage());
        }
    }
}
