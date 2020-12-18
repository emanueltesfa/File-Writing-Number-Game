import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextCreator {

	public static void main(String[] args) {

		String fileName = "Assignment8.txt";

		try {

			PrintWriter outputStream = new PrintWriter(fileName);

			double randNum = 0;
			double finalScore = 0;
			double userNum = 1;

			System.out.println("Enter in a number between 1 and 10 (Enter 0 to finish)");

			Scanner input1 = new Scanner(System.in);

			userNum = input1.nextDouble();

			try {
				while (userNum > 10 || userNum < 0) {
					System.out.println("Try again: Enter a number 1-10.");
					userNum = input1.nextDouble();
				}

			} catch (InputMismatchException inputMismatchException) {
				System.err.printf("%nException:%s%n", inputMismatchException);
				System.out.println("There is a mismatch of input types" + inputMismatchException);

			}
			randNum = (int) (Math.random() * (10 + 1) + 0);

			while (userNum != 0) {

				while (userNum > 10 || userNum < 0) {
					System.out.println("Try again: Enter a number 1-10.");

					try {
						userNum = input1.nextDouble();
						if (userNum == 0) {
							break;
						}
					}

					catch (InputMismatchException e) {
						System.out.println("There is a mismatch of input types" + e);
					}
				}
				if (userNum == 0) {
					break;

				} else {
					if (randNum > userNum) {
						finalScore -= 0.5;
					} else if (randNum == userNum) {
						finalScore += 1;
					} else {
						finalScore += 0.5;
					}

					ArrayList<String> inputList = new ArrayList<>();
					inputList.add(+userNum + ", " + randNum + ", " + finalScore);
					outputStream.println(inputList);

					try {
						userNum = input1.nextDouble();
					}

					catch (InputMismatchException e) {
						System.out.println("There is a mismatch of input types " + e);
					}

					randNum = (int) (Math.random() * (10 + 1) + 0);
				}
			}

			outputStream.println("Final Score: " + finalScore);
			outputStream.close(); // flush
			System.out.println("File creation completed!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
