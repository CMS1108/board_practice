package edu.dnslab.boardpractice.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int id;
    private String name;
    private String content;
}
