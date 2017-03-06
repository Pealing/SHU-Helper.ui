package shuhelper.ui;

import javafx.beans.property.SimpleStringProperty;

public class ScoreClass {

	//成绩大表类
	
	private SimpleStringProperty CJ_ClassNum;
	private SimpleStringProperty CJ_ClassName;
	private SimpleStringProperty CJ_Credit;
	private SimpleStringProperty CJ_Score;
	private SimpleStringProperty CJ_GPA;

	public ScoreClass(String classnum,String classname,String credit,String score,String gpa)
	{
		CJ_ClassNum = new SimpleStringProperty(classnum);
		CJ_ClassName = new SimpleStringProperty(classname);
		CJ_Credit = new SimpleStringProperty(credit);
		CJ_Score = new SimpleStringProperty(score);
		CJ_GPA = new SimpleStringProperty(gpa);
		
		
	}

	public String getCJ_ClassNum() {
		return CJ_ClassNum.get();
	}

	public void setCJ_ClassNum(SimpleStringProperty cJ_ClassNum) {
		CJ_ClassNum = cJ_ClassNum;
	}

	public String getCJ_ClassName() {
		return CJ_ClassName.get();
	}

	public void setCJ_ClassName(SimpleStringProperty cJ_ClassName) {
		CJ_ClassName = cJ_ClassName;
	}

	public String getCJ_Credit() {
		return CJ_Credit.get();
	}

	public void setCJ_Credit(SimpleStringProperty cJ_Credit) {
		CJ_Credit = cJ_Credit;
	}

	public String getCJ_Score() {
		return CJ_Score.get();
	}

	public void setCJ_Score(SimpleStringProperty cJ_Score) {
		CJ_Score = cJ_Score;
	}

	public String getCJ_GPA() {
		return CJ_GPA.get();
	}

	public void setCJ_GPA(SimpleStringProperty cJ_GPA) {
		CJ_GPA = cJ_GPA;
	}
}
