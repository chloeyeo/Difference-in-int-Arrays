package arrayDiff;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class DifferenceArrays {
	public static int[] arrayDiff(int[] a, int[] b) {
		/** Returns difference between array a and b; a-b, as an int[] array. */
		// System.out.println("array a: " + Arrays.toString(a));
		// System.out.println("array b: " + Arrays.toString(b));

		List<Integer> listB = IntStream.of(b).boxed().collect(Collectors.toList());

		int[] result = IntStream.of(a).filter(x -> !(listB.contains(x))).toArray();

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("We are calculating the difference between int arrays a and b, i.e. (a-b)");
		System.out.println("and will return the result as an int array.\n");

		boolean repeat = true;
		while (repeat) {
			System.out.println("Enter array a elements separated by space:");
			String[] string1 = scan.nextLine().split(" ");
			int[] array1 = Arrays.stream(string1).mapToInt(x -> Integer.parseInt(x)).toArray();

			System.out.println("Enter array b elements separated by space:");
			String[] string2 = scan.nextLine().split(" ");
			int[] array2 = Arrays.stream(string2).mapToInt(x -> Integer.parseInt(x)).toArray();

			System.out.println("The result is:");
			System.out.println(Arrays.toString(arrayDiff(array1, array2)));

			System.out.println("\nWould you like to try again? (y/n):");
			String answer = scan.nextLine().strip();
			
			if (answer.equals("n")) {
				repeat = false;
				scan.close();
			}
		}
	}
}
