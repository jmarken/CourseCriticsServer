package controller;

import common.UserDTO;
import model.Model;

public class Controller {
    Model model = new Model();

    public void registerUser(UserDTO registerUser) throws Exception{
        try {
            model.registerUser(registerUser);
        }catch (Exception ex){
            throw ex;
        }

    }

    public Boolean verifyUser(UserDTO verifyUser){
        return model.verifyUser(verifyUser);
    }
}
