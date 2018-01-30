/*
 * Overview: 
 * ---------
 * Develop a GUI application that allows a Centennial College 
 * student to calculate his/her GPA given the current GPA and total 
 * number of credit hours earned. The student should be allowed to 
 * enter as many courses as he/she wants. The program must 
 * calculate and display the GPA for that student.
 */
public class Program {

	public static void main(String[] args) {

		try {
			CalculateGPA frame = new CalculateGPA();
			frame.setTitle("Centennial College GPA Calculator");
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
