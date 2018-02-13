package view.entrypoints;

import controller.Controller;
import view.rest.CourseRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
public class Courses {

    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(CourseRest courseRequest) {
        controller.createCourse(courseRequest);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseRest> getCourses() {
        return controller.getCourses();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseRest getCourse(@PathParam("name") String name) {
        return controller.getCourse(name);
    }

    @PUT
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateCourse(@PathParam("name") String name, CourseRest course) {
        controller.updateCourse(name, course);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseRest deleteCourse(@PathParam("name") String name) {
        return controller.deleteCourse(name);
    }
}
