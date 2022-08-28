
public class Student_marks {

	public int sid;
	public int marks_1=0,marks_2=0,marks_3=0,sum=0;
	public String name;
	
	public Student_marks() {}
	
	public String next()
	{	
		return "output_marks";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getMarks_1() {
		return marks_1;
	}

	public void setMarks_1(int marks_1) {
		this.marks_1 = marks_1;
	}

	public int getMarks_2() {
		return marks_2;
	}

	public void setMarks_2(int marks_2) {
		this.marks_2 = marks_2;
	}

	public int getMarks_3() {
		return marks_3;
	}

	public void setMarks_3(int marks_3) {
		this.marks_3 = marks_3;
	}

	public int getSum() {
		sum=marks_1+marks_2+marks_3;
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
