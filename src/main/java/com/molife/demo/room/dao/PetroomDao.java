package com.molife.demo.room.dao;

import java.util.List;

import com.molife.demo.dto.PetroomRequest;
import com.molife.demo.room.model.PetroomVo;

public interface PetroomDao {
	
	List<PetroomVo> getPetrooms();
	
	PetroomVo getPetroomById(Integer roomTypeId);
	
	PetroomVo getPetroomByName(String roomName);
	
	Integer createPetroom(PetroomRequest petroomRequest);
	
	void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest);


}
