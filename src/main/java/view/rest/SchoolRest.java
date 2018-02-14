package view.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SchoolRest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}