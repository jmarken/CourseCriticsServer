package view.entrypoints;

import common.CourseDTO;
import common.ReviewDTO;
import controller.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
public class Courses {

    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(CourseDTO courseRequest) {
        controller.createCourse(courseRequest);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseDTO> getCourses() {
        return controller.getCourses();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseDTO getCourse(@PathParam("name") String name) {
        return controller.getCourse(name);
    }

    @GET
    @Path("/{name}/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewDTO> getReviews(@PathParam("name") String name) {
        return controller.getCourseReviews(name);
    }

}
