package s112011.runn;

import java.util.Date;

/**
 * Created by Niko on 12-01-2016.
 *
 */

public class ProfileDTO {

    private int    id;
    private String name;
    private String password;
    private String email;
    private int    level;
    private long   dateCreated;

    public ProfileDTO()
    {

    }

    public ProfileDTO(int id, String name, String password, String email, int level, long dateCreated)
    {
        this.id          = id;
        this.name        = name;
        this.password    = password;
        this.email       = email;
        this.level       = level;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getDateCreated() {
        return null;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = 34;
    }
}
