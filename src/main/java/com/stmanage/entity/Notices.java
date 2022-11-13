package com.stmanage.entity;

import lombok.Data;

@Data
public class Notices {
    private int noid;
    private String title;
    private String detail;
    private String createtime;
    private int teamid;
    private String teamsname;
    private String status;
}
