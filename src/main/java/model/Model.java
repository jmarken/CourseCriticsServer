package model;

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

    public Boolean verifyUser(UserDTO verifyUser){
        User dbUser = dbo.getUser(verifyUser.getUsername());
        if(dbUser == null){
            return false;
        }else{
            return dbUser.getPassword().equals(verifyUser.getPassword());
        }
    }
}
