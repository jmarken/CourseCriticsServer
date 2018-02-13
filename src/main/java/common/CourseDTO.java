package common;

public class CourseDTO {
    private String name;
    private String school;

    public CourseDTO() {
    }

    public CourseDTO(String name, String school) {
        this.name = name;
        this.school = school;
    }

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

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
