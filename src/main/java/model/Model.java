package model;

import common.ErrorMessages;
import model.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

import static common.ErrorMessages.*;

public class Model{
    private Factory factory = new Factory();
    private SessionFactory sessionFactory = factory.getFactory();

    //FOR TESTING
    public static void main(String[] args) {
        Model model = new Model();
        DBOperations dbo = new DBOperations(model.factory, model.sessionFactory);

        //ExampleData ed = new ExampleData();
        //ed.enterStuff();



    }
}
