package marsbase.test;

public class StudyObject2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len=0, oldlen=0;
		Object[] a = new Object[0];
		try{
			for(;;){
				++len;
				Object[] temp = new Object[oldlen=len];
				System.out.println(temp.length);
				temp[0] =a;
				a=temp;
			}
		} catch(Error e){
			System.out.println(e+","+(oldlen==len));
		}

	}

}
