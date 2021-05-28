package edu.logintegra.springbootcachedemo.comments;

import edu.logintegra.springbootcachedemo.issues.Issue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    Long id;

    @Column(columnDefinition = "TEXT")
    String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "issue_id", nullable = false)
    Issue issue;
}
