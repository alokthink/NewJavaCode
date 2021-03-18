interface Multiply{
	public void m1(int i);
}
public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		
		Multiply m=(int i)->System.out.println(i*i);
		m.m1(2);
	}

}
