package com.GLAB309_7_1.SpringCRUD.model;

import jakarta.persistence.*;



/*– @Entity annotation indicates that the class is a persistent Java
class. @Entity is used to mark that this POJO is used as an entity in
the database.
– @Table annotation provides the table that maps this entity.
– @Id annotation is for the primary key.
– @GeneratedValue annotation is used to define the generation strategy
for the primary key. GenerationType.AUTO means Auto Increment field.
– @Column annotation is used to define the column in the database
that maps the annotated field.
*/

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published")
    private boolean published;
    public Tutorial() {
    }
    public Tutorial(String title, String description, boolean published)
    {
        this.title = title;
        this.description = description;
        this.published = published;
    }
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isPublished() {
        return published;
    }
    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }
    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" +
                description + ", published=" + published + "]";
    }
}
