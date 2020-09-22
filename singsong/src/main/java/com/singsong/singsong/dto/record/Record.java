package com.singsong.singsong.dto.record;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Record {
    int rid;
    String r_u_id;
    String r_name;
    String r_title;
    String r_url;
    int r_likes;
    int r_views;
    String r_date;
}
