package com.stmanage.entity;

import lombok.Data;

@Data
public class Paylogs {
    private int payid;
    private String createtime;
    private int total;
    private String details;
    private int tmid;
    private int teamid;
    private String title;

    private String teamsname;
    private String name;
    private String gender;
    private String phone;
    private int remaintotal;
}
