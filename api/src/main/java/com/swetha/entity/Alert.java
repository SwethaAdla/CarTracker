package com.swetha.entity;

import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Entity
@NamedQueries({
		@NamedQuery(name = "Alert.findOne",
				query = "SELECT a1 FROM Alert a1 WHERE a1.vinNo=:paramVin"),
		@NamedQuery(name = "Alert.findRecentHighAlerts",
				query = "SELECT a2 FROM Alert a2 WHERE a2.alertStatus=:paramStatus")
})
public class Alert {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String id;

	private String vinNo;
	private String alertStatus;
	private String msg;
	private String timeAlertGenerated;

	public Alert() {
		this.id = UUID.randomUUID()
				.toString();
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStatus(String alertStatus) {
		this.alertStatus = alertStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTimeAlertGenerated() {
		return timeAlertGenerated;
	}

	public void setTimeAlertGenerated(String timeAlertGenerated) {
		this.timeAlertGenerated = timeAlertGenerated;
	}
}
