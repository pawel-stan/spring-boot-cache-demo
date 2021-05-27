package edu.logintegra.springbootcachedemo.issues;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IssueMap implements Serializable {

    String code;
    String title;
    String content;
    Integer numberOfComments;
    Boolean resolved;

    IssueMap(Issue issue) {
        this.code = issue.code;
        this.title = issue.title;
        this.content = issue.content;
        this.numberOfComments = 0;
        this.resolved = false;
    }
}
