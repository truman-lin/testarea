package marsbase.test;

public class StudyCase4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [][][] arr = {
				{{},null},
				{{"1","2"},{"1",null,"3"}},
				{{},{"1",null}}
		};
		boolean b = false;
		String s = (b=!b)?(b=!b)?"Hello":"hello":(b=!b)?"world":"World";
		System.out.println(s);
		System.out.println(arr[1][2].length);
	}

}
