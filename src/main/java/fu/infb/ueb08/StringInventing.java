package fu.infb.ueb08;

public class StringInventing {
	String str;
	TaskExecutioner executer = new TaskExecutioner();

	public void generateString(final int size) {
		executer.start("string generation with " + size + " characters",
				new Exe() {

					public void exe() {
						String str = new String();
						for (int i = 0, charCounter = 0; i <= size; i++, charCounter++) {
							str += (char) (charCounter + 65);
							if (charCounter >= 25) {
								charCounter = 0;
							}
						}
						StringInventing.this.str = str;
						System.out.println("generated string: \n" + str);

					}
				});

	}

	public void invertByString() {
		executer.start("invertion by string", new Exe() {

			public void exe() {
				char[] strAsChar = StringInventing.this.str.toCharArray();
				String newString = new String();
				for (int i = strAsChar.length - 1; i >= 0; i--) {
					newString += strAsChar[i];
				}
				System.out.println("string inverting results in: \n"
						+ newString);
			}
		});
	}

	public void invertByStringBuilder() {
		executer.start("invertion by stringbuilder", new Exe() {

			public void exe() {
				char[] strAsChar = StringInventing.this.str.toCharArray();
				StringBuilder newString = new StringBuilder();
				for (int i = strAsChar.length - 1; i >= 0; i--) {
					newString.append(strAsChar[i]);
				}
				System.out.println("string inverting results in: \n"
						+ newString);
			}
		});
	}

	public void invertByStringBuffer() {
		executer.start("invertion by stringbuffer", new Exe() {

			public void exe() {
				StringBuffer newString = new StringBuffer(
						StringInventing.this.str);
				StringBuffer reverse = newString.reverse();
				System.out.println("string inverting results in: \n"
						+ reverse.toString());
			}
		});
	}

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
