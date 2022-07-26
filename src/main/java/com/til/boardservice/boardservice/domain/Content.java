package com.til.boardservice.boardservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Content {

    private Date date;
    private Long id;

    private String writer;
    private String title;
    private String text;


    public Content(){}

    public Content(String title, String text, String writer){
        this.title = title;
        this.writer = writer;
        this.text = text;
    }

}
