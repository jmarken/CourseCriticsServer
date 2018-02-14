package model;

import common.CourseDTO;
import common.ErrorMessages;
import common.UserDTO;
import model.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

import static common.ErrorMessages.*;

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

    public void registerUser(UserDTO registerUser) throws Error.SaveUserException{
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


}
