import java.util.function.Function;

public class FunctionInterface {

	public static void main(String[] args) {
		/*1
		 * Function<String,Integer> f= s->s.length();
		 * System.out.println(f.apply("alok"));
		 */
		/*2
		 * Function<String,String> f1=s->s.toUpperCase(); Function<String,String>
		 * f2=s->s.substring(0, 2);
		 * 
		 * System.out.println(f1.apply("alomishra"));
		 * System.out.println(f2.apply("alomishra"));
		 * System.out.println(f1.andThen(f2).apply("alomishra"));
		 * System.out.println(f1.compose(f2).apply("alomishra"));
		 */
		
		
		Function<Integer,Integer> f1=i->i+i; 
		Function<Integer,Integer> f2=i->i*i*i;
		  
		  System.out.println(f1.apply(2));
		  System.out.println(f2.apply(2));
		  System.out.println(f1.andThen(f2).apply(2));
		  System.out.println(f1.compose(f2).apply(2));
		 
	}

}
