
public class Qust1 {
	/*
	 * private static String str2 = null; public static void changeStr(String str) {
	 * str = "welcome"; } public static void main(String[] args) { String str =
	 * "1234"; str2 = "5678"; changeStr(str); changeStr(str2);
	 * System.out.println(str); System.out.println(str2); }
	 */
	/*
	 * static boolean foo(char c) { System.out.print(c); return true; } public
	 * static void main(String[] argv) { int i = 0; for (foo('A'); foo('B') && (i <
	 * 2); foo('C')) { i++; foo('D'); } }
	 */
	/* public class Something { */
		void printString() {
			private String s = "OK";
			System.out.print(s);
		}
		private abstract String donotPrintString (){}
		final int i;
		public void printInt() {
			System.out.println("i = " + i);
		}

		public int addInt(final int x) {
			return ++x;
		}
		public void addObject(final MyInteger o) {
			o.i++;
		}
		class MyInteger {
			public int i;
		}

}

	


