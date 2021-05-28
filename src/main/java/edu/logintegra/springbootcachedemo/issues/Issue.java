package edu.logintegra.springbootcachedemo.issues;

import edu.logintegra.springbootcachedemo.comments.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Issue {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true)
    String code;

    @Column(nullable = false)
    String title;

    @Column(columnDefinition = "TEXT")
    String content;

    @OneToMany(mappedBy = "issue")
    Set<Comment> comments;
}