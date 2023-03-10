package com.molife.demo.room.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.molife.demo.room.dao.PetroomDao;
import com.molife.demo.room.dto.PetroomRequest;
import com.molife.demo.room.model.PetroomVo;

@Component
public class PetroomServiceImpl implements PetroomService{
	
	//噴出log資訊 制式化寫法
	 private final static Logger log = LoggerFactory.getLogger(PetroomServiceImpl.class);
	
	@Autowired
	private PetroomDao petroomDao;

	@Override
	public Integer createPetroom(PetroomRequest petroomRequest) {
		
		//幫我把前端傳進來的房名對應進來
		PetroomVo petroomVo = petroomDao.getPetroomByName(petroomRequest.getRoomName());
		
		//判斷前端傳進來的房名是不是已被使用過，沒有才能使用
		if(petroomVo != null) {
			log.warn("該房名 {} 已註冊", petroomRequest.getRoomName());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return petroomDao.createPetroom(petroomRequest);
	}
	
	

	@Override
	public List<PetroomVo> getPetrooms() {
		
		return petroomDao.getPetrooms();
	}



	@Override
	public PetroomVo getPetroomById(Integer roomTypeId) {	
		
		return petroomDao.getPetroomById(roomTypeId);
	}



	@Override
	public void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest) {
		petroomDao.updatePetroom(roomTypeId, petroomRequest);
	}

}
