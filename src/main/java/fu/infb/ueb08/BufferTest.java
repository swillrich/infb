package fu.infb.ueb08;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE08)
public class BufferTest {

	public static void main(String[] args) {
		try {
			if (args.length != 1 && Integer.valueOf(args[0]) > 0) {
				new IllegalArgumentException();
			}
			new BufferTest().generateString(Integer.valueOf(args[0]));
		} catch (Exception e) {
			new Exception("wrong number of arguments or not an integer", e);
		}
	}

	// speichert den generierten String
	String str;
	// Objekt zur Ausfuehrung einzelner Tasks inklusive Stopuhr
	TaskExecutioner executer = new TaskExecutioner();

	// generiert einen String anhand der size, die angegeben wird. size = laenge
	// des Strings
	public void generateString(final int size) {
		executer.start("string generation with " + size + " characters",
				new Exe() {

					public void exe() {
						String str = new String();
						// durchlaeuft solange, bis der String generiert wurde
						for (int i = 0, charCounter = 0; i <= size; i++, charCounter++) {
							// fuegt characters hinzu zwischen A und Z und faengt
							// bei A wieder an, wenn Z vorbei ist.
							str += (char) (charCounter + 65);
							if (charCounter >= 25) {
								charCounter = 0;
							}
						}
						BufferTest.this.str = str;
						System.out.println("generated string: \n" + str);

					}
				});

	}

	// Aufgabe b
	public void invertByString() {
		executer.start("inverting by string", new Exe() {

			public void exe() {
				char[] strAsChar = BufferTest.this.str.toCharArray();
				String newString = new String();
				// Invertierung durch permantente String-Instanziierung
				for (int i = strAsChar.length - 1; i >= 0; i--) {
					newString += strAsChar[i];
				}
				System.out.println("string inverting results in: \n"
						+ newString);
			}
		});
	}

	// Aufgabe c
	public void invertByStringBuilder() {
		executer.start("inverting by stringbuilder", new Exe() {

			public void exe() {
				char[] strAsChar = BufferTest.this.str.toCharArray();
				StringBuilder newString = new StringBuilder();
				// Invertierung per StringBuilder
				for (int i = strAsChar.length - 1; i >= 0; i--) {
					newString.append(strAsChar[i]);
				}
				System.out.println("string inverting results in: \n"
						+ newString);
			}
		});
	}

	// Aufgabe d
	public void invertByStringBuffer() {
		executer.start("inverting by stringbuffer", new Exe() {

			public void exe() {
				StringBuffer newString = new StringBuffer(BufferTest.this.str);
				// Invertierung per Java API
				StringBuffer reverse = newString.reverse();
				System.out.println("string inverting results in: \n"
						+ reverse.toString());
			}
		});
	}

	// Klasse zur Ausfuehrung einzelner Aufgaben inklusive einer Stopuhr
	class TaskExecutioner {
		public void start(String desc, Exe exe) {
			System.out.println("=> task: " + desc);
			long start = System.nanoTime();
			exe.exe();
			long stop = System.nanoTime();
			System.out.println("execution time: " + (stop - start) / 1000);
			System.out.println();
		}
	}

	interface Exe {
		void exe();
	}

}
