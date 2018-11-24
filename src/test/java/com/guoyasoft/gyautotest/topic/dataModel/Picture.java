package com.guoyasoft.gyautotest.topic.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Picture {
	private String pictureId;
	private String picUrl;
	private List<Answer> answers =new ArrayList<Answer>();



	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
