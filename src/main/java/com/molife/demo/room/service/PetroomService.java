package com.molife.demo.room.service;

import java.util.List;

import com.molife.demo.room.dto.PetroomRequest;
import com.molife.demo.room.model.PetroomVo;

public interface PetroomService {
	
	List<PetroomVo> getPetrooms();
	
	PetroomVo getPetroomById(Integer roomTypeId);
	
	Integer createPetroom(PetroomRequest petroomRequest);
	
	void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest);
	
	
	
}
