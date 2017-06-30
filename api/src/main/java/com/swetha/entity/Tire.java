package com.swetha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.UUID;

@Entity
public class Tire {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String id;

	//@JoinColumn (name = "reference_vinNo" , table = "Vehicle")
	private String vinNo;
	private float frontLeft;
	private float frontRight;
	private float rearLeft;
	private float rearRight;

	public Tire() {
		this.id = UUID.randomUUID()
				.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public float getFrontLeft() {
		return frontLeft;
	}
	public void setFrontLeft(float frontLeft) {
		this.frontLeft = frontLeft;
	}
	public float getFrontRight() {
		return frontRight;
	}
	public void setFrontRight(float frontRight) {
		this.frontRight = frontRight;
	}
	public float getRearLeft() {
		return rearLeft;
	}
	public void setRearLeft(float rearLeft) {
		this.rearLeft = rearLeft;
	}
	public float getRearRight() {
		return rearRight;
	}
	public void setRearRight(float rearRight) {
		this.rearRight = rearRight;
	}

}
