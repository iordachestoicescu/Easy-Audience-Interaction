package com.endava.easyaudienceinteraction.entity;

import javax.persistence.*;

/**
 * @author Laurentiu Iordache
 */
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "content")
    private String content;

    @Column(name = "votes")
    private int votes;

    @Transient
    private final String ANNO = "Anonymous";

    public Question(String subject, String name, String email, String content, int votes) {
        this.subject = subject;
        this.name = name;
        this.email = email;
        this.content = content;
        this.votes = votes;
    }

    public Question(String subject, String content, int votes) {
        this.content = content;
        this.subject = subject;
        this.votes = votes;
        this.name = ANNO;
        this.email = ANNO;
    }

    public Question() {}

    public long getId(){
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", votes=" + votes +
                ", ANNO='" + ANNO + '\'' +
                '}';
    }
}
