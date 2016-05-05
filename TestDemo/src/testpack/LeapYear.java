package testpack;

public class LeapYear {

	public static void main(String args[]) {

		//Checking leap year without using library or API and applying logic
		
		System.out.println("Does 1800 a leap year : " + doesLeapYear(1800));
		System.out.println("Does 1901 a leap year : " + doesLeapYear(1901));
		System.out.println("Does 1900 a leap year : " + doesLeapYear(1900));
		
		System.out.println("Does 2000 a leap year : " + doesLeapYear(2000));
		System.out.println("Does 2012 a leap year : " + doesLeapYear(2012));

	}   

	public static boolean doesLeapYear(int year){
		return (year%400 == 0) || ((year%100) != 0 && (year%4 == 0));
	}
}
