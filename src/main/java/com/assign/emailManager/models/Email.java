package com.assign.emailManager.models;

import javax.persistence.*;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;

    @Column(nullable = false)
    private String receivedFrom;

    @Column(nullable = false)
    private String sendTo;

    private String subject;
    private String body;

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", receivedFrom='" + receivedFrom + '\'' +
                ", sendTo='" + sendTo + '\'' +
                ", Subject='" + subject + '\'' +
                ", Body='" + body + '\'' +
                '}';
    }
}
