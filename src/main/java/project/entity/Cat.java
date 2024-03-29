package project.entity;

import jakarta.persistence.*;
import org.hibernate.engine.jdbc.env.internal.LobTypes;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.util.Base64;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String description;
    @Lob
    @Column(columnDefinition="longblob")
    private byte[] image;

    public String getDescription() {
        return description;
    }
    public Cat()
    {

    }
    public Cat(String name, int age, String description, byte[] image) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConvertImage() throws UnsupportedEncodingException {
        byte[] encodeBase64 = Base64.getEncoder().encode(image);
        return new String(encodeBase64, "UTF-8");
    }
    public byte[] getImage() {

        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
