interface interf {
	public void m1();
}

public class AnnonymusInnerClass {

	int x = 10;

	public void m2() {
		interf i = new interf() {
			int x=99;
			@Override
			public void m1() {
             System.out.println(this.x);
			}

		};
		i.m1();
	}

	public static void main(String[] args) {
		AnnonymusInnerClass t=new AnnonymusInnerClass();
		t.m2();

	}

}
