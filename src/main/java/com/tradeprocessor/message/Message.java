package com.tradeprocessor.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	private String execId;
	private String securityId;
	private int securityIdSource;
	private String account;
	private int lastShares;
	private double avgPx;
	private String side;

	// Default constructor for Jackson
	public Message() {
	}

	// Constructor for parsing FIX message string
	@JsonCreator
	public Message(@JsonProperty("execId") String execId,
				   @JsonProperty("securityId") String securityId,
				   @JsonProperty("securityIdSource") int securityIdSource,
				   @JsonProperty("account") String account,
				   @JsonProperty("lastShares") int lastShares,
				   @JsonProperty("avgPx") double avgPx,
				   @JsonProperty("side") String side) {
		this.execId = execId;
		this.securityId = securityId;
		this.securityIdSource = securityIdSource;
		this.account = account;
		this.lastShares = lastShares;
		this.avgPx = avgPx;
		this.side = side;
	}

	public String getExecId() {
		return execId;
	}

	public void setExecId(String execId) {
		this.execId = execId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public int getSecurityIdSource() {
		return securityIdSource;
	}

	public void setSecurityIdSource(int securityIdSource) {
		this.securityIdSource = securityIdSource;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getLastShares() {
		return lastShares;
	}

	public void setLastShares(int lastShares) {
		this.lastShares = lastShares;
	}

	public double getAvgPx() {
		return avgPx;
	}

	public void setAvgPx(double avgPx) {
		this.avgPx = avgPx;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Message{" +
				"execId='" + execId + '\'' +
				", securityId='" + securityId + '\'' +
				", securityIdSource=" + securityIdSource +
				", account='" + account + '\'' +
				", lastShares=" + lastShares +
				", avgPx=" + avgPx +
				", side='" + side + '\'' +
				'}';
	}
}