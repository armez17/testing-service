package programming;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15); 
		//printOddNumberInListFunctional(numbers);  ex1 print odd
		//printSquareOfOddNumberInListFunctional(numbers);  ex5 print square of odd
		
		List<String> courses = List.of("Spring","Spring Boot","API",
				"Microservices","AWS","PCD","Azure","Docker","Kubernetes");
		//course.stream().forEach(System.out::println);  ex2  Print all course
		
		//courses.stream().filter(course -> course.contains("Spring")) ex3  print course match "Spring"
		//	.forEach(System.out::println);
		
		//courses.stream().filter(course -> course.length() >= 4)   ex4 print course >4 char
		//.forEach(System.out::println);
		
		courses.stream().map(course -> course + " " + course.length())   //ex6  print num of char 
		.forEach(System.out::println);
	}

	//private static void printOddNumberInListFunctional(List<Integer> numbers) {  ex1   print odd
	//	 numbers.stream().filter(number -> number%2 == 1) //Lamdba Expression      
	//		.forEach(System.out::println); //Method Reference					   
	//}
	
	/*private static void printSquareOfOddNumberInListFunctional(List<Integer> numbers) {    ex5  print square of odd
		 numbers.stream().filter(number -> number%2 == 1) //Lamdba Expression
			//mapping - x -> x * x
			.map(number -> number * number * number)
			.forEach(System.out::println); //Method Reference
	}*/  




}