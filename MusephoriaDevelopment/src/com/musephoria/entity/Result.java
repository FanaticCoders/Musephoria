package com.musephoria.entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class Result implements java.io.Serializable {

	private List<?> resultList;
	private int resultCount;
	private int statusCode;
	private String statusMessage;

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
