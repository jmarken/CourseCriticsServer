package model;

import common.*;
import model.Entity.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Model{
    private Factory factory = new Factory();
    private SessionFactory sessionFactory = factory.getFactory();
    DBOperations dbo = new DBOperations(factory, sessionFactory);


    //FOR TESTING
    public static void main(String[] args) {
        Model model = new Model();


        //ExampleData ed = new ExampleData();
        //ed.enterStuff();

    }

    public void createUser(UserDTO registerUser) throws Error.SaveUserException{
        try{
            User newUser = new User(registerUser.getUsername(), registerUser.getPassword());
            dbo.saveUser(newUser);
        }catch(Error.SaveUserException sue){
            throw sue;
        }
    }

    public Boolean login(UserDTO userDTO){
        User dbUser = dbo.getUser(userDTO.getUsername());
        if(dbUser == null){
            return false;
        }else{
            return dbUser.getPassword().equals(userDTO.getPassword());
        }
    }

    public void createCourse (CourseDTO courseDTO) throws Error.SaveCourseException{
        School school = new School(courseDTO.getSchool());
        dbo.saveSchool(school);
        school = dbo.getSchool(courseDTO.getSchool());
        Course course = new Course(courseDTO.getName(), school);
        System.out.println(school);
        System.out.println(course);
        try{
            dbo.saveCourse(course);
        }catch (Error.SaveCourseException sce){
            throw sce;
        }
    }

    public List<CourseDTO> getCourses(){
        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        for(Course c : dbo.getAllCourses()){
            CourseDTO tempDTO = new CourseDTO(c.getName(),
                                              c.getSchool().getName());
            courseDTOList.add(tempDTO);
        }
        return courseDTOList;
    }

    public CourseDTO getCourse(String name){
        Course course = dbo.getCourse(name);
        if(course == null){
            return null;
        }
        else {
            CourseDTO courseDTO = new CourseDTO(course.getName(), course.getSchool().getName());
            return courseDTO;
        }
    }

    public List<ReviewDTO> getCourseReviews(String courseName){
        List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
        for(Review review : dbo.getCourseReviews(courseName)){
            ReviewDTO reviewDTO = new ReviewDTO(review.getCourse().getName(),
                                                review.getUser().getUsername(),
                                                review.getQuality(),
                                                review.getRelevance(),
                                                review.getDifficulty(),
                                                review.getTeaching(),
                                                review.getComment());
            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }

    public List<SchoolDTO> getSchools(){
        List<SchoolDTO> schoolDTOList = new ArrayList<SchoolDTO>();
        for(School school : dbo.getAllScools()){
            SchoolDTO schoolDTO = new SchoolDTO(school.getName());
            schoolDTOList.add(schoolDTO);
        }
        return schoolDTOList;
    }

    public List<ReviewDTO> getUsersReviews(String userName){
        List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
        for(Review review : dbo.getUsersReviews(userName)){
            ReviewDTO reviewDTO = new ReviewDTO(review.getCourse().getName(),
                                                review.getUser().getUsername(),
                                                review.getQuality(),
                                                review.getRelevance(),
                                                review.getDifficulty(),
                                                review.getTeaching(),
                                                review.getComment());
            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }
}
