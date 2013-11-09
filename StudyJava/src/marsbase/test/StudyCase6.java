package marsbase.test;

interface I {
	int x =0;
}

class T1 implements I{
	int x = 1;
}

class T2 extends T1{
	int x = 2;
}

class T3 extends T2{
	int x = 3;
	void test(){
		System.out.print(x); //3
		System.out.print(super.x); //2
		System.out.print(((T2)this).x); //2
		System.out.print(((T1)this).x);  //1
		System.out.print(((I)this).x); //0
	}
}
public class StudyCase6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new T3().test();

	}

}
