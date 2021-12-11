package zoo.animal;

import java.time.LocalDate;

import zoo.Sex;

public class Animal {
	private AnimalType animalType;
	private String nickname;
	private LocalDate birthday;
	private Sex sex;
	
	public Animal(AnimalType animalType, String nickname, LocalDate birthday, Sex sex) {
		this.animalType = animalType;
		this.nickname = nickname;
		this.birthday = birthday;
		this.sex = sex;
	}
	public AnimalType getAnimalType() {
		return animalType;
	}
	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}

}
