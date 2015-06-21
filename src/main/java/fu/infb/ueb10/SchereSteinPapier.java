package fu.infb.ueb10;

import java.util.Random;
import java.util.Scanner;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
public class SchereSteinPapier {
	public static void main(String[] args) {
		// instantiating ScherSteinPapier will start the game
		new SchereSteinPapier();
	}

	public SchereSteinPapier() {
		// instantiate two players, i) a human player and ii) a computer player
		Player user = new HumanPlayer();
		Player computer = new ComputerPlayer();

		// let they play against each other
		go(user, computer);
	}

	private void go(Player user, Player computer) {
		// first show how the game works
		StringBuilder b = new StringBuilder();
		b.append("Optionen:\n");
		b.append("s = schere\n");
		b.append("t = stein\n");
		b.append("p = papier\n");
		b.append("q = quit\n");
		System.out.println(b.toString());

		// the came is infinite until the user decide to cancel it
		while (true) {
			// first the human user can play
			user.play();
			// if the user want to cancel the game
			if (user.isWantCancel()) {
				break;
				// if the user choice is invalid, e.g. 'asnsds'. Then retry!
			} else if (user.getCurrentChoice() == null) {
				continue;
			}
			// after the user has played, the computer is up
			computer.play();
			// if user and computer choice is equal, a standoff is reached.
			if (user.getCurrentChoice() == computer.getCurrentChoice()) {
				System.out.println("Choices are equal :-) Retry!");
				user.standoff();
				computer.standoff();
				continue;
			}
			// if the choices are not equal, so compare the choices
			boolean userWins = Handzeichen.compare(user.getCurrentChoice(),
					computer.getCurrentChoice());
			// if the user has win the game, point for him
			if (userWins) {
				user.wins();
				computer.los();
			} else {
				computer.wins();
				user.los();
			}
		}
		System.out.println("Game over.");
		System.out.println("Statistik:");
		System.out.println("User: " + user.getStatistik());
		System.out.println("Computer: " + computer.getStatistik());
	}

	// abstract class that represents common behavior and structure of human and
	// computer players
	private static abstract class Player {
		// for storing statistik values
		private int winnings;
		private int defeats;
		private int standoff;

		// for storing the current 'Handzeichen' choice
		Handzeichen currentChoice;

		// if the player want to quit the game, the value is true
		boolean wantCancel = false;

		public String getStatistik() {
			return this.getWinnings() + " wins, " + this.getStandoff()
					+ " standoff, " + this.getDefeats() + " defeats";
		}

		public boolean isWantCancel() {
			return wantCancel;
		}

		public Handzeichen getCurrentChoice() {
			return currentChoice;
		}

		public void wins() {
			System.out.println(this.getClass().getSimpleName() + " wins");
			winnings = winnings + 1;
		}

		public void los() {
			defeats = defeats + 1;
		}

		public void standoff() {
			standoff = standoff + 1;
		}

		public int getDefeats() {
			return defeats;
		}

		public int getStandoff() {
			return standoff;
		}

		public int getWinnings() {
			return winnings;
		}

		public abstract void play();
	}

	private static class HumanPlayer extends Player {
		Scanner scanner = new Scanner(System.in);

		// control the user entry and results in setting currentChoice
		// if the user input is invalid, currentChoice is null.
		// the user can also decice to quit the game.
		@Override
		public void play() {
			System.out.println("Enter your choice:");
			String userInput = scanner.nextLine();
			if (userInput.equals("q")) {
				wantCancel = true;
				currentChoice = null;
				System.out.println("User want cancel.");
			} else if (userInput.equals("s")) {
				currentChoice = Handzeichen.Schere;
			} else if (userInput.equals("t")) {
				currentChoice = Handzeichen.Stein;
			} else if (userInput.equals("p")) {
				currentChoice = Handzeichen.Papier;
			} else {
				currentChoice = null;
				System.out.println("Misentry!");
			}
		}
	}

	private static class ComputerPlayer extends Player {
		private Random random = new Random();

		// in case of being a computer, omit to interact over console. In this
		// case a randomized choice will be generate.
		@Override
		public void play() {
			currentChoice = Handzeichen.values()[random.nextInt(2)];
			System.out.println("Computer choice is: "
					+ currentChoice.toString());
		}
	}

	private static enum Handzeichen {
		Schere, Stein, Papier;

		// compare the Handzeichen instances. Each instance has his own weight
		// and is comparable to another instance.
		public static boolean compare(Handzeichen challenger,
				Handzeichen opponent) {
			switch (challenger) {
			case Papier:
				if (opponent == Stein) {
					return true;
				}
				break;
			case Schere:
				if (opponent == Papier) {
					return true;
				}
				break;
			case Stein:
				if (opponent == Schere) {
					return true;
				}
				break;
			}
			return false;
		}
	}
}
