package com.singsong.singsong.service.room;

import java.util.List;

import com.singsong.singsong.dto.room.Room;

public interface RoomService {
    int writeroomDeatil(Room room);    
    List<Room> getList(String sr_o_id);
    Room getListByUser(String sr_u_id);
    int roomdelete(String sr_u_id);
}
