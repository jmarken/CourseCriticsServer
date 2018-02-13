package view.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseRest {
    private String name;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
