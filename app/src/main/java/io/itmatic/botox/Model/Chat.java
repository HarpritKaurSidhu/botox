package io.itmatic.botox.Model;

import java.security.Timestamp;

/**
 * Created by Manoj on 5/16/2017.
 */

public class Chat {

    private int id;
    private Provider sender;
    private Patient recipient;
    private String message;
    private String createdAt;
    private boolean isSendByMe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getSender() {
        return sender;
    }

    public void setSender(Provider sender) {
        this.sender = sender;
    }

    public Patient getRecipient() {
        return recipient;
    }

    public void setRecipient(Patient recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSendByMe() {
        return isSendByMe;
    }

    public void setSendByMe(boolean sendByMe) {
        isSendByMe = sendByMe;
    }
}
