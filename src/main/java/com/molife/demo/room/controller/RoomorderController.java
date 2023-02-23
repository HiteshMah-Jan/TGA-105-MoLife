package com.molife.demo.room.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.molife.demo.room.dto.RoomderQueryParams;
import com.molife.demo.room.dto.RoomorderRequest;
import com.molife.demo.room.model.RoomorderVO;
import com.molife.demo.room.service.RoomorderService;
import com.molife.demo.room.util.Page;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated //加上這個註解 @Max @Min才會生效
public class RoomorderController {
	
	@Autowired
	private RoomorderService roomorderService;
	
	//==============後台訂單頁面join查詢=================
//	@GetMapping("/getOrderpagebyId/{roomOrderId}")
	@GetMapping("/getOrderpage")
	public ResponseEntity<List<Map<String, Object>>> getorderPage(){
//		System.out.println("=======驗證==========" + roomOrderId);
		
		RoomorderVO roomorderVO = new RoomorderVO();
		
		List<Map<String, Object>> roomorderList = roomorderService.getRoomorderPages(roomorderVO);

		return ResponseEntity.status(HttpStatus.OK).body(roomorderList);
	}
	
	
	//=========查詢全部訂單==========
	@GetMapping("/roomorders")                                           //代表非必填項目
	public ResponseEntity<Page<RoomorderVO>> getRoomorder(@RequestParam(required = false) String search,//中文字查詢
			@RequestParam(required = false) Integer searchStatus,//根據入住狀態查詢
			@RequestParam(defaultValue = "room_check_date") String orderBy,//根據什麼欄位排序
			@RequestParam(defaultValue = "desc") String sort,
			//分頁功能 預設取得5筆                 //最大不能撈超過1000筆 最小不能小於0
			@RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
			@RequestParam(defaultValue = "0") @Min(0) Integer offset				
			){ //根據升續或是降序
		
		//新增模糊查詢 把前端獲取到的參數送進來
		RoomderQueryParams roomderQueryParams = new RoomderQueryParams();
		roomderQueryParams.setSearch(search);
		roomderQueryParams.setSearchStatus(searchStatus);
		roomderQueryParams.setOrderBy(orderBy);
		roomderQueryParams.setSort(sort);
		roomderQueryParams.setLimit(limit);
        roomderQueryParams.setOffset(offset);
		
        //表示取得訂單清單的數據
		List<RoomorderVO> roomorderList = roomorderService.getRoomorders(roomderQueryParams);
		
		//根據傳進去的參數去確認訂單總數有多少筆
        Integer total = roomorderService.countOrder(roomderQueryParams);
		
		//需要回傳目前總筆數
		Page<RoomorderVO> page = new Page<RoomorderVO>();
		 page.setLimit(limit);
	     page.setOffset(offset);
	     page.setTotal(total);
	     page.setResults(roomorderList);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(page);
		
	}
	
	
	//=====================查詢訂單中某筆訂單===========================
	@GetMapping("/roomorders/{roomOrderId}")
	public ResponseEntity<RoomorderVO> getRoomorder(@PathVariable Integer roomOrderId){
		RoomorderVO roomorderVO = roomorderService.getRoomorderById(roomOrderId);
		
		
		if(roomorderVO != null) {
			return ResponseEntity.status(HttpStatus.OK).body(roomorderVO);
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//===============查詢會員訂單詳細(目前有異常)====================
//	@GetMapping("/roomorderDetial/{memberId}")
//	public ResponseEntity<List<RoomorderVO>> getOrderDetailsByMemID(@PathVariable Integer memberId){
//		
//		List<RoomorderVO> memberOrderList = roomorderService.getRoomorderByMemberId(memberId);
		
		
		
//		if(memberOrderList != null) {
//			
//			return ResponseEntity.status(HttpStatus.OK).body(memberOrderList);
//			
//		}else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
		
//	}
	
	//====================新增訂單================================
	
	@PostMapping("/roomorders")//建立在會員已存在的情況下訂單才有意義
	public ResponseEntity<RoomorderVO> createRoomorder(	@RequestBody @Valid RoomorderRequest roomorderRequest){
		
		
		
		Integer roomOrderId = roomorderService.createRoomorder(roomorderRequest);
		
		RoomorderVO roomorderVO = roomorderService.getRoomorderById(roomOrderId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(roomorderVO);
		
		
	}
	
	//================修改訂單==============
	@PutMapping("/roomorders/{roomOrderId}")
	public ResponseEntity<RoomorderVO> updateRoomorder(@PathVariable Integer roomOrderId,
														@RequestBody @Valid RoomorderRequest roomorderRequest){
		//檢查訂單是否存在
		RoomorderVO roomorderVO = roomorderService.getRoomorderById(roomOrderId);
		
//		//不存在返回404
		if(roomorderVO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		//修改訂單數據
		
		roomorderService.updateRoomorder(roomOrderId, roomorderRequest);
		
		RoomorderVO updateRoomorder = roomorderService.getRoomorderById(roomOrderId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateRoomorder);
		
	}
	
	//==================刪除訂單==================
	@DeleteMapping("/roomorders/{roomOrderId}")
	public ResponseEntity<?> deleteRoomOrder(@PathVariable Integer roomOrderId){
		roomorderService.deleteRoomOrder(roomOrderId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	

}
