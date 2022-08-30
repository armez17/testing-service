package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//printAllNumberInListFunctional(numbers);
		//printEvenNumberInListFunctional(numbers);
		printSquareOfEvenNumberInListFunctional(numbers);
	}
	
	//private static void print(int number) {
	//	System.out.println(number);
	//}
	private static boolean isEven(int number) {
		return number%2==0;
		
	}
	//private static void printAllNumberInListFunctional(List<Integer> numbers) {

		//numbers.stream().forEach(FP01Structured::print); //Method Reference
		
	private static void printAllNumberInListFunctional(List<Integer> numbers) {

		numbers.stream().forEach(System.out::println); //Method Reference
	}
	/*private static void printEvenNumberInListFunctional(List<Integer> numbers) {
 
		numbers.stream().filter(FP01Functional::isEven) //filter - only allow even numbers
			.forEach(System.out::println); //Method Reference
	}*/
	private static void printEvenNumberInListFunctional(List<Integer> numbers) {
		 
		numbers.stream().filter(number -> number%2 == 0) //Lamdba Expression
			.forEach(System.out::println); //Method Reference
	}
	private static void printSquareOfEvenNumberInListFunctional(List<Integer> numbers) {
		 
		numbers.stream().filter(number -> number%2 == 0) //Lamdba Expression
			//mapping - x -> x * x
			.map(number -> number * number)
			.forEach(System.out::println); //Method Reference
	}
}