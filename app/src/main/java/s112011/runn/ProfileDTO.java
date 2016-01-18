package s112011.runn;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Niko on 12-01-2016.
 *
 */

public class ProfileDTO implements Serializable {

    private int    id;
    private String username;
    private String password;
    private String email;
    private int    level;
    private long   dateCreated;
    private String description;
    private double posLong;
    private double posLat;

    public ProfileDTO()
    {

    }

    public ProfileDTO(int id, String username, String password, String email, int level, long dateCreated, String description, double posLat, double posLong)
    {
        this.id          = id;
        this.username    = username;
        this.password    = password;
        this.email       = email;
        this.level       = level;
        this.dateCreated = dateCreated;
        this.description = description;
        this.posLat      = posLat;
        this.posLong     = posLong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPosLong() {
        return posLong;
    }

    public void setPosLong(double posLong) {
        this.posLong = posLong;
    }

    public double getPosLat() {
        return posLat;
    }

    public void setPosLat(double posLat) {
        this.posLat = posLat;
    }

}