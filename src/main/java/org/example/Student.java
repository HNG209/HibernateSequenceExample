package org.example;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table
@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "custom")
    @GenericGenerator(
            name = "custom",
            strategy = "org.example.CustomID"
    )
    private String Id;

    @Column
    private String name;

    @Column
    private int age;

    public Student() {}

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
}
