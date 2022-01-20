package edu.dnslab.boardpractice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Article {
    private int id;
    private String name;
    private String content;
}
