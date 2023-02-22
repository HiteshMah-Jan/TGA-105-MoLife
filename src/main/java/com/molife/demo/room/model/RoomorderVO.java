package com.molife.demo.room.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //將null值過濾掉
@JsonIgnoreProperties(ignoreUnknown = true)//將多出來的key給忽略掉

public class RoomorderVO {
	
	private Integer roomOrderId;
	private Integer memberId;
	private Integer roomTotalAmount;
	private Integer roomOrderStatus;
	private Integer totalOfPet;
	private Date roomCheckInDate;
	private Date roomCheckOutDate;
	private String payerName;
	private String payerPhone;
	private Timestamp roomCheckDate;
	private Integer orderStatus;
	 
	 private String roomComment;
	 
	 
	 //join用
	 private String roomName;
	 private Integer roomTypeId;

	 
	

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@Override
	public String toString() {
		return "RoomorderVO [roomOrderId=" + roomOrderId + ", memberId=" + memberId + ", roomTotalAmount="
				+ roomTotalAmount + ", roomOrderStatus=" + roomOrderStatus + ", totalOfPet=" + totalOfPet
				+ ", roomCheckInDate=" + roomCheckInDate + ", roomCheckOutDate=" + roomCheckOutDate + ", payerName="
				+ payerName + ", payerPhone=" + payerPhone + ", roomCheckDate=" + roomCheckDate + ", orderStatus="
				+ orderStatus + "]";
	}

	public Integer getRoomOrderId() {
		return roomOrderId;
	}

	public void setRoomOrderId(Integer roomOrderId) {
		this.roomOrderId = roomOrderId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getRoomTotalAmount() {
		return roomTotalAmount;
	}

	public void setRoomTotalAmount(Integer roomTotalAmount) {
		this.roomTotalAmount = roomTotalAmount;
	}

	public Integer getRoomOrderStatus() {
		return roomOrderStatus;
	}

	public void setRoomOrderStatus(Integer roomOrderStatus) {
		this.roomOrderStatus = roomOrderStatus;
	}

	public Integer getTotalOfPet() {
		return totalOfPet;
	}

	public void setTotalOfPet(Integer totalOfPet) {
		this.totalOfPet = totalOfPet;
	}

	public Date getRoomCheckInDate() {
		return roomCheckInDate;
	}

	public void setRoomCheckInDate(Date roomCheckInDate) {
		this.roomCheckInDate = roomCheckInDate;
	}

	public Date getRoomCheckOutDate() {
		return roomCheckOutDate;
	}

	public void setRoomCheckOutDate(Date roomCheckOutDate) {
		this.roomCheckOutDate = roomCheckOutDate;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerPhone() {
		return payerPhone;
	}

	public void setPayerPhone(String payerPhone) {
		this.payerPhone = payerPhone;
	}

	public Timestamp getRoomCheckDate() {
		return roomCheckDate;
	}

	public void setRoomCheckDate(Timestamp roomCheckDate) {
		this.roomCheckDate = roomCheckDate;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomComment() {
		return roomComment;
	}

	public void setRoomComment(String roomComment) {
		this.roomComment = roomComment;
	}


	
	
	
	
}
