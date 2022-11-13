package com.stmanage.entity;

import lombok.Data;

@Data
public class Payment {
    private int pmid;
    private String title;
    private String createtime;
    private int total;
    private String details;
    private int teamid;
    private int tmid;
    private String teamsname;
}
