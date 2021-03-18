interface Test1{
	public void m1();
}
public class Test {

	int x=888;
	public void m2() {
		Test1 i=new Test1(){
            int x=999;
			@Override
			public void m1() {
				System.out.println(this.x);
				
			}
			
		};
		i.m1();
		
	}
	/*
	 * Test1 t=()->{ int x=999; System.out.println(this.x); }; t.m1(); }
	 */
	public static void main(String[] args) {
		Test t2=new Test();
		t2.m2();
	}
}
