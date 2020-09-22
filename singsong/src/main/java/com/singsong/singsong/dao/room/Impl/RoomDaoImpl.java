package com.singsong.singsong.dao.room.Impl;


import java.util.List;

import com.singsong.singsong.dao.room.RoomDao;
import com.singsong.singsong.dto.room.Room;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	SqlSession sqlsession;

	@Override
	public int writeroomDeatil(Room room) {

		return sqlsession.insert("roommapper.writedetail", room);
	}

	@Override
	public List<Room> getList(String sr_o_id) {
		return sqlsession.selectList("roommapper.getList",sr_o_id);
	}

	@Override
	public Room getListByUser(String sr_u_id) {
		return sqlsession.selectOne("roommapper.getListByUser",sr_u_id);
	}

	@Override
	public int roomdelete(String sr_u_id) {
		return sqlsession.delete("roommapper.roomdelete",sr_u_id);
	}
    

}
