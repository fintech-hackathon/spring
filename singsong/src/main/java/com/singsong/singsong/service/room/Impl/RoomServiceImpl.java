package com.singsong.singsong.service.room.Impl;


import java.util.List;

import com.singsong.singsong.dao.room.RoomDao;
import com.singsong.singsong.dto.room.Room;
import com.singsong.singsong.service.room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomdao;

	@Override
	public int writeroomDeatil(Room room) {

		return roomdao.writeroomDeatil(room);
	}

	@Override
	public List<Room> getList(String sr_o_id) {
		return roomdao.getList(sr_o_id);
	}

	@Override
	public Room getListByUser(String sr_u_id) {
		return roomdao.getListByUser(sr_u_id);
	}

	@Override
	public int roomdelete(String sr_u_id) {
		return roomdao.roomdelete(sr_u_id);
	}
    

}
