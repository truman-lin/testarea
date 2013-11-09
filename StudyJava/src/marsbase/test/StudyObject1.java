package marsbase.test;

public class StudyObject1 {
	static String mountain = "Everest.";
	StudyObject1(){
		System.out.println("Constructer.");
	}
	static StudyObject1 favorite(){
		System.out.print("Mount ");
		return new StudyObject1();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(favorite().mountain);
	}

}
