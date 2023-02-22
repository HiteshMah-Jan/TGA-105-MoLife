package com.molife.demo.room.dao;

import java.util.List;

import com.example.demo.model.RoomOrderDeatilVo;

public interface RoomOrderDeatilDao {

	List<RoomOrderDeatilVo> getOrderDeatils();
	
//	RoomOrderDeatilVo getOrderDetailsByMemID(Integer memberId);
	
}
