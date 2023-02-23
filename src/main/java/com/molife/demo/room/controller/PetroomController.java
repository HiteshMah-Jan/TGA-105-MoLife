package com.molife.demo.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.molife.demo.room.dto.PetroomRequest;
import com.molife.demo.room.model.PetroomVo;
import com.molife.demo.room.service.PetroomService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PetroomController {

	@Autowired
	private PetroomService petroomService;

	// 新增房型
	@PostMapping("/petrooms/createroom")
	public ResponseEntity<PetroomVo> createPetroom(@RequestBody @Valid PetroomRequest petroomRequest) {

		Integer roomTypeId = petroomService.createPetroom(petroomRequest);

		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		return ResponseEntity.status(HttpStatus.CREATED).body(petroomVo);
	}

	// 修改房型
	@PutMapping("/petrooms/{roomTypeId}")
	public ResponseEntity<PetroomVo> updatePetroom(@PathVariable Integer roomTypeId,
			@RequestBody  PetroomRequest petroomRequest) {

		// 先查詢這房型是否存在
		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		if (petroomVo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// 修改房型的詳細數據
		petroomService.updatePetroom(roomTypeId, petroomRequest);

		PetroomVo updatePetroom = petroomService.getPetroomById(roomTypeId);

		return ResponseEntity.status(HttpStatus.OK).body(updatePetroom);
	}

	// 查詢所有房型
	@GetMapping("/petrooms")
	public ResponseEntity<List<PetroomVo>> getPetrooms() {
		
		List<PetroomVo> petroomList = petroomService.getPetrooms();
		
		return ResponseEntity.status(HttpStatus.OK).body(petroomList);

	}

	// 查詢單筆房型詳細
	@GetMapping("/petrooms/{roomTypeId}")
	public ResponseEntity<PetroomVo> getPetroom(@PathVariable Integer roomTypeId) {

		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		if (petroomVo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(petroomVo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	// 查詢房型圖片
	@GetMapping("/image1/{roomTypeId}")
	public void showImg(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic1());
		res.getOutputStream().close();

	}

	@GetMapping("/image2/{roomTypeId}")
	public void showImg2(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic2());
		res.getOutputStream().close();

	}

	@GetMapping("/image3/{roomTypeId}")
	public void showImg3(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic3());
		res.getOutputStream().close();

	}

}
