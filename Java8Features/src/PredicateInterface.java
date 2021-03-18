import java.util.function.Predicate;

public class PredicateInterface {

	public static void main(String[] args) {
		/*Example 1
		 * Predicate<Integer> p=i->i>10; System.out.println(p.test(10));
		 * System.out.println(p.test(100));
		 */
		
		int[] arr= {10,20,30,40,59};
		Predicate<Integer> p1=i->i>10 ;
		Predicate<Integer> p2=i->i%2==0;
		System.out.println("the number greater than 10 arr");
		PredicateInterface p=new PredicateInterface();
		
		for(int x:arr) {
			p(p1.and(p2),x);
		}

	}

}
