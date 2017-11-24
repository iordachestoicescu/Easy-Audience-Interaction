package com.endava.easyaudienceinteraction.dto;

/**
 * @author Laurentiu Iordache
 */
public class MailRequest {
    private String username;
    private String password;
    private String receiver;
    private String subject;
    private String content;

    public MailRequest() {
    }

    public MailRequest(String username, String password, String receiver, String subject, String content) {
        this.username = username;
        this.password = password;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

