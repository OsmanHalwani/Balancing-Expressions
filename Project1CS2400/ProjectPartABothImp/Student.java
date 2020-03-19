
public class Student {

	private int StudentID;
	private String first_name;
	private String last_name;
	private String level;

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public Student(int studentID, String first_name, String last_name, String level) {

		if (level.equalsIgnoreCase("freshman") || level.equalsIgnoreCase("sophmore") || level.equalsIgnoreCase("junior")
				|| level.equalsIgnoreCase("senior")) {
			this.level = level;
			StudentID = studentID;
			this.first_name = first_name;
			this.last_name = last_name;
		}
	}

	public Student(Student s) {

		if (s.level.equalsIgnoreCase("freshman") || s.level.equalsIgnoreCase("sophomore")
				|| s.level.equalsIgnoreCase("junior") || s.level.equalsIgnoreCase("senior")) {

			this.level = s.level;
			this.first_name = s.first_name;
			this.StudentID = s.StudentID;
			this.first_name = s.first_name;
			this.last_name = s.last_name;
		}

	}

	public Student() {
		this.first_name = null;
		this.last_name = null;
		this.level = null;
		this.StudentID = 0;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLevel() {
		return level;
	}

}
