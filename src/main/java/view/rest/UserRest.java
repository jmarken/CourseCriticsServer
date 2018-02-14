package view.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserRest {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}