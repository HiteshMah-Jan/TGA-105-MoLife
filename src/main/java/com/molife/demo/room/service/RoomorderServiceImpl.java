package com.molife.demo.room.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.molife.demo.room.dao.PetroomDao;
import com.molife.demo.room.dao.RoomorderDao;
import com.molife.demo.room.dto.RoomderQueryParams;
import com.molife.demo.room.dto.RoomorderRequest;
import com.molife.demo.room.model.PetroomVo;
import com.molife.demo.room.model.RoomOrderDeatilVo;
import com.molife.demo.room.model.RoomorderVO;

@Component
public class RoomorderServiceImpl implements RoomorderService{
	
	@Autowired
	private RoomorderDao roomorderDao;
	
	@Autowired
	private PetroomDao petroomDao;
	
	
	@Override
	public List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams) {
		
		return roomorderDao.getRoomorders(roomderQueryParams);
	}
	
	
	
	@Override
	public RoomorderVO getRoomorderById(Integer roomOrderId) {
		return roomorderDao.getRoomorderById(roomOrderId);
	}
	
	@Override
	public List<RoomorderVO> getRoomorderByMemberId(Integer memberId) {
		return roomorderDao.getRoomorderByMemberId(memberId);
	}


	//創建訂單需要分成兩部分
	@Transactional //新增交易控制避免數據不一致
	@Override
	public Integer createRoomorder(RoomorderRequest roomorderRequest) {
		//新增一個List 去裝傳進來得數值
		List<RoomOrderDeatilVo> roomOrderDeatilList = new ArrayList<>();
		
		PetroomVo petroomVo = petroomDao.getPetroomById(roomorderRequest.getRoomTypeId());
		
		
		//創建訂單
		Integer roomOrderId = roomorderDao.createRoomorder(roomorderRequest);//先在roomorder table新增資料
		
		roomorderDao.createRoomOrderDetail(roomOrderId,roomorderRequest);//同時要去room order detail表新增
		
		return roomOrderId;
	}


	@Override
	public void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest) {
		roomorderDao.updateRoomorder(roomOrderId, roomorderRequest);
		
	}


	@Override
	public void deleteRoomOrder(Integer roomOrderId) {
		
		roomorderDao.deleteRoomOrder(roomOrderId);
	}



	@Override
	public List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO) {
		
		return roomorderDao.getRoomorderPages(roomorderVO);
	}



	@Override
	public Integer countOrder(RoomderQueryParams roomderQueryParams) {
		
		return roomorderDao.countOrder(roomderQueryParams);
	}

	
	}


	
	


