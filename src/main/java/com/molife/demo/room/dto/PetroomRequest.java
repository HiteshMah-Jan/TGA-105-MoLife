package com.molife.demo.room.dto;

public class PetroomRequest {
	
//	@NotBlank
	private String roomName;
//	@NotBlank
	private String roomDescription;
//	@NotNull
	private Integer petNumber;
//	@NotNull
	private Integer roomStatus;
//	@NotNull
	private Integer roomPrice;
	
	private byte[] roomPic1;
	
	private byte[] roomPic2;
	
	private byte[] roomPic3;
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public Integer getPetNumber() {
		return petNumber;
	}
	public void setPetNumber(Integer petNumber) {
		this.petNumber = petNumber;
	}
	public Integer getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(Integer roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public byte[] getRoomPic1() {
		return roomPic1;
	}
	public void setRoomPic1(byte[] roomPic1) {
		this.roomPic1 = roomPic1;
	}
	public byte[] getRoomPic2() {
		return roomPic2;
	}
	public void setRoomPic2(byte[] roomPic2) {
		this.roomPic2 = roomPic2;
	}
	public byte[] getRoomPic3() {
		return roomPic3;
	}
	public void setRoomPic3(byte[] roomPic3) {
		this.roomPic3 = roomPic3;
	}
	
	

}
