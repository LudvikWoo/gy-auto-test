package com.guoyasoft.gyautotest.topic.dataModel;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Answer answer1=new Answer();
		answer1.setAuthor("wuling");

		Answer answer2=new Answer();
		answer2.setAuthor("王凯");

		Picture picture=new Picture();
		picture.setPictureId("1");
		picture.getAnswers().add(answer1);
		picture.getAnswers().add(answer2);

		Exam exam=new Exam();
		exam.setExamId(1);
		exam.getPictures().add(picture);

		Interview interview=new Interview();
		interview.setInterviewId(1001);
		interview.setExam(exam);
	}
}
