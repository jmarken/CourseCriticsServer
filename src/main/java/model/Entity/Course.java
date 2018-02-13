package model.Entity;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name="school_name")
    private School school;

    public Course() {
    }

    public Course(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
