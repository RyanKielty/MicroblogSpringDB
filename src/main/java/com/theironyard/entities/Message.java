package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ryankielty on 1/21/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;
    @Column(nullable = false)
    String text;

    public Message(String text) {
        this.id = id;
        this.text = text;
    }

    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}