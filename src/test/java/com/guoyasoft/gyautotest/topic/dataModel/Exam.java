package com.guoyasoft.gyautotest.topic.dataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exam {
	private int examId;
	private Date examTime;
	private int progress;
	private List<Picture> pictures =new ArrayList<Picture>();
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

}
