package controller;

import common.CourseDTO;
import common.ReviewDTO;
import common.SchoolDTO;
import common.UserDTO;
import model.Entity.User;
import model.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @Inject
    Model model = new Model();

    public Controller() {
        model.getCourse("");
    }

    public void createUser(UserDTO registerUser) throws Exception{
        try {
            model.createUser(registerUser);
        }catch (Exception ex){
            throw ex;
        }

    }

    public Boolean login(UserDTO userDTO){
        return model.login(userDTO);
    }

    public void createCourse(CourseDTO courseDTO) throws Exception{
        try{
            model.createCourse(courseDTO);
        }catch (Exception e){
            throw e;
        }
    }

    public List<CourseDTO> getCourses(){
        return model.getCourses();
    }

    public CourseDTO getCourse(String name){
        return model.getCourse(name);
    }

    public List<ReviewDTO> getCourseReviews(String courseName){
        return model.getCourseReviews(courseName);
    }

    public List<SchoolDTO> getSchools(){
        return model.getSchools();
    }

    public List<ReviewDTO> getUsersReviews(String userName){
        return model.getUsersReviews(userName);
    }

    public void updateUser(UserDTO userDTO) throws Exception{
        try{
            model.updateUser(userDTO);
        }catch (Exception e){
            throw e;
        }
    }
    public void createReview(ReviewDTO reviewDTO) throws Exception{
        try{
            model.createReview(reviewDTO);
        }catch (Exception e){
            throw e;
        }
    }
}
