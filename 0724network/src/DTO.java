import java.util.Calendar;

public class DTO {
	private int num;
	private String name;
	private int score;
	private Calendar birth;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Calendar getBirth() {
		return birth;
	}
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	
	
	@Override
	public String toString() {
		return "DTO [num=" + num + ", name=" + name + ", score=" + score + ", birth=" + birth + "]";
	}
}