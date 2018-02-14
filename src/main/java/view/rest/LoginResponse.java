package view.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResponse {
    private String username;
    private String success;

    public LoginResponse(String username, String success) {
        this.username = username;
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
