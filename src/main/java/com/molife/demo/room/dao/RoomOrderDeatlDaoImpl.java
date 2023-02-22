package com.molife.demo.room.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.PetroomVo;
import com.example.demo.model.RoomOrderDeatilVo;
import com.example.demo.rowmapper.PetroomRowMapper;
import com.example.demo.rowmapper.RoomOrderDetailRowMapper;

@Component
public class RoomOrderDeatlDaoImpl implements RoomOrderDeatilDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<RoomOrderDeatilVo> getOrderDeatils() {
		String sql = "SELECT roomorder_detail_id, room_type_id, roomorder_id FROM room_order_detail";
		Map<String, Object> map = new HashMap<>();
		List<RoomOrderDeatilVo> roomOrderDeatilList = namedParameterJdbcTemplate.query(sql, map, new RoomOrderDetailRowMapper());
		return roomOrderDeatilList;
	}

//	@Override
//	public RoomOrderDeatilVo getOrderDetailsByMemID(Integer memberId) {
//		String sql = "SELECT roomorder_detail_id, room_type_id, roomorder_id FROM room_order_detail WHERE";
//
//		return null;
//	}
//	
	


}
