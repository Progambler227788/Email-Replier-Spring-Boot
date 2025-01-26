package com.talha.emailreplier.entities;


import lombok.Data;

@Data  // for automatic getters/setters/args constructor
public class EmailRequest {

    private String emailContent;
    private String tone;

}
