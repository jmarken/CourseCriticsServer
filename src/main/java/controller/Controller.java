package controller;

import common.CourseDTO;
import common.UserDTO;
import model.Model;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Model model = new Model();

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

}
