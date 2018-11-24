package com.guoyasoft.gyautotest.topic.extendsAndImpl;

public class Girl {

	public Girl(String mother,String father){
		this.mother=mother;
		this.father=father;
	}

	public String name;
	public String birthday;
	public String sex;
	public String weight;
	public String welcomeWord;
	private String mother;
	private String father;

	public String getMother() {
		return mother;
	}
	public String getFather() {
		return father;
	}


	@Override
	public String toString() {
		return "Girl [name=" + name + ", birthday=" + birthday + ", sex=" + sex
				+ ", weight=" + weight + ", welcomeWord=" + welcomeWord
				+ ", mother=" + mother + ", father=" + father + "]";
	}
	public static void main(String[] args) {
		Girl baby=new Girl("至尊宝", "紫霞");
		baby.birthday="2018-04-13 09:12:30";
		baby.name="初夏";
		baby.sex="女";
		baby.weight="8.8";
		baby.welcomeWord="八阿哥";
		System.out.println(baby.toString());
	}
}
