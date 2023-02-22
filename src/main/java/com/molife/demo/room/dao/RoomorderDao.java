package com.molife.demo.room.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.RoomderQueryParams;
import com.example.demo.dto.RoomorderRequest;
import com.example.demo.model.RoomorderVO;

public interface RoomorderDao {
	
	Integer countOrder(RoomderQueryParams roomderQueryParams);
	
	List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams);
	
	RoomorderVO getRoomorderById(Integer roomOrderId);
	
	List<RoomorderVO> getRoomorderByMemberId(Integer memberId);
	
	//創建訂單
	Integer createRoomorder(RoomorderRequest roomorderRequest);
	
	//同步進入訂單明細
	void createRoomOrderDetail(Integer roomOrderId,RoomorderRequest roomorderRequest);
	
	void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest);
	
	void deleteRoomOrder(Integer roomOrderId);
	
	//======================join============
	List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO);

}
