package com.molife.demo.room.service;

import java.util.List;
import java.util.Map;

import com.molife.demo.room.dto.RoomderQueryParams;
import com.molife.demo.room.dto.RoomorderRequest;
import com.molife.demo.room.model.RoomorderVO;

public interface RoomorderService {
	
	Integer countOrder(RoomderQueryParams roomderQueryParams);
	
	List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams);
	
	RoomorderVO getRoomorderById(Integer roomOrderId);
	
	List<RoomorderVO> getRoomorderByMemberId(Integer memberId);
	
	Integer createRoomorder(RoomorderRequest roomorderRequest);
	
	void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest);
	
	void deleteRoomOrder(Integer roomOrderId);
	
	//=============================
	List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO);


}
