package com.singsong.singsong.dto.room;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Room {
    int sr_id;
    String sr_o_id;
    String sr_u_id;
    int sr_song;
    String sr_date;
    int sr_room;
}
