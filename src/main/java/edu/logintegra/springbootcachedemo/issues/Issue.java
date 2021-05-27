package edu.logintegra.springbootcachedemo.issues;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}