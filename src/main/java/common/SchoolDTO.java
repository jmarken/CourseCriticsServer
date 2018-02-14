package common;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SchoolDTO {
    private String name;

    public SchoolDTO() {
    }

    public SchoolDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
