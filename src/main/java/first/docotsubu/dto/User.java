package first.docotsubu.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String pass;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
