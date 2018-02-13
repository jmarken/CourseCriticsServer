package view.entrypoints;

import common.CourseDTO;
import controller.Controller;
import view.rest.CourseRest;
import view.rest.ReviewRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/courses")
public class Courses {

    private Controller controller = new Controller();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(CourseRest courseRequest) {
        CourseDTO courseDTO = new CourseDTO(courseRequest.getName(), courseRequest.getSchool());
        controller.createCourse(courseDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseRest> getCourses() {
        List<CourseDTO> dtoList = controller.getCourses();
        List<CourseRest> courseRests = new ArrayList<CourseRest>();
        for(CourseDTO dto : dtoList)
            courseRests.add(new CourseRest(dto.getName(), dto.getSchool()));
        return courseRests;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseRest getCourse(@PathParam("name") String name) {
        CourseDTO courseDTO = controller.getCourse(name);
        return new CourseRest(courseDTO.getName(), courseDTO.getSchool());
    }

    @GET
    @Path("/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewRest> getReviews() {
        return controller.getReviews;
    }

    @PUT
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateCourse(@PathParam("name") String name, CourseRest course) {
        CourseDTO courseDTO = new CourseDTO(course.getName(), course.getSchool());
        controller.updateCourse(name, courseDTO);
    }

}
