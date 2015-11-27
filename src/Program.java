
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
