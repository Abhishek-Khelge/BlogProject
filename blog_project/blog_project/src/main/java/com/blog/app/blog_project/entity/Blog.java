package com.blog.app.blog_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Blog {
    @Id
    Integer blogId;
    //    String blogCategory;
    String blogDescription;

    @ManyToOne
    @JsonBackReference
    User user;

    @ManyToOne
    @JsonBackReference
    Categories categories;

    @OneToMany(mappedBy = "blog")
    @JsonManagedReference
    List<Comment> comment = new ArrayList<>();

    public List<Comment> getComment() {
        return comment;
    }

    public void addComment(Comment comment) {
        this.comment.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comment.remove(comment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
}
