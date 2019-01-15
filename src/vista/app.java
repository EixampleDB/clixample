package vista;

import java.io.IOException;
import java.util.Scanner;

import controller.Controller;

public class app {

	private static Scanner sc;
	private static Controller contr = new Controller();

	public static void main(String[] args) throws IOException {
		String input = "", key = "", value= "";
		sc = new Scanner(System.in);
		while(!input.equals("EXIT")) {
			printMenu();
			input = sc.next();
			
			switch(input) {
				case "GET":
					key = sc.next();
					System.out.println(input + " " + key + "\n");
					contr.sendGET(key);
					break;
				case "SET":
					key = sc.next();
					value = sc.next();
					System.out.println(input + " " + key + " " + value + "\n");
					break;	
				case "DELETE":
					key = sc.next();
					System.out.println(input + " " + key + "\n");
					break;
				case "INCR":
					key = sc.next();
					System.out.println(input + " " + key + "\n");
					break;
				case "DECR":
					key = sc.next();
					System.out.println(input + " " + key + "\n");
					break;
				case "BULK":
					System.out.println(input + "\n");
				default:
					break;
			}
		}
		System.exit(0);
	}
	
	public static void printMenu() {
		System.out.println("Insert Command:\nGET <key>\nSET <key> <value>\nDELETE <key>\nINCR <key>\nDECR <key>\nBULK\nEXIT\n");
	}

}
