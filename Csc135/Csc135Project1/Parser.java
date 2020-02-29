import java.util.Scanner;

//Lorenzo Susbilla
//Csc135
//due 2 March 2019

//Determines if a given string is legal
// must end statement with $
//no whitespaces or lowercase letters

//based of the given example code
public class Parser {
	static String inputString;
	static int index = 0;
	static int errorflag = 0;
	
	public static void main(String[] args) {
		Parser handle = new Parser();
		Scanner input = new Scanner(System.in);
		System.out.println("enter an expression: ");
		handle.inputString = input.nextLine();
		handle.start();
	}
	
	private char getToken() {
		char currentToken = inputString.charAt(index);
		return currentToken;
	}
	private void nextToken() {
		if(index < inputString.length() - 1) {
			index++;
		}
	}
	private void match(char T) {
		if( T == getToken()) {
			nextToken();
		} else error();
	}
	private void error() {
		System.out.println("error at token: " + index);
		errorflag = 1;
		nextToken();
	}
	private void program() {
		match('S');
		while(getToken() == 'W' || getToken() ==  'X' || getToken() == 'Y' || getToken() == 'Z'
				|| getToken() == 'I' || getToken() == 'D' || getToken() == 'R' || getToken() == 'O'
				|| getToken() == 'C'
				) {
			statemt();
		}
	}
	private void statemt() {
		if(getToken() == 'W' || getToken() ==  'X' || getToken() == 'Y' || getToken() == 'Z') {
			assnmt();
		} else if(getToken() == 'I' ) {
			ifstmt();
		} else if(getToken() == 'D') {
			dostmt();
		} else if(getToken() == 'R' || getToken() == 'O') {
			inout();
		} else if(getToken() == 'C') {
			progcall();
		} else error();
	}
	private void assnmt() {
		ident();
		match('~');
		exprsn();
		match(';');
		
	}
	private void ident() {
		letter();
		while(getToken() == 'W'|| getToken() == 'X' || getToken() == 'Y' || getToken() == 'Z' || getToken() == '0' || getToken() == '1' ) {
			charstmt();
		}
		
	}
	private void charstmt() {
		if(getToken() == 'W'|| getToken() == 'X' || getToken() == 'Y' || getToken() == 'Z' ) {
			letter();
		} else if(getToken() == '0' || getToken() == '1' ) {
			digit();
		} else error();
		
	}
	private void letter() {
		if(getToken() == 'W'|| getToken() == 'X' || getToken() == 'Y' || getToken() == 'Z' ) {
			match(getToken());
		} else error();
		
	}
	private void digit() {
		if(getToken() == '0' || getToken() == '1' ) {
			match(getToken());
		} else error();
		
	}
	private void exprsn() {
		factor();
		while(getToken() == '+') {
			match('+');
			factor();
		}
		
	}
	private void factor() {
		oprnd();
		while(getToken() == '*') {
			match('*');
			oprnd();
		}
		
	}
	private void oprnd() {
		if(getToken() == '0'|| getToken() == '1') {
			intstmt();
		}
		else if(getToken() == 'W'|| getToken() == 'X' || getToken() == 'Y' || getToken() == 'Z' ) {
			ident();
		}
		else if(getToken() == 'T'|| getToken() == 'F') {
			boolstmt();
		}
		else if(getToken() == '(') {
			match('(');
			exprsn();
			match(')');
		} else error();
		
	}
	private void boolstmt() {
		if(getToken() == 'T' || getToken() == 'F' ) {
			match(getToken());
		} else error();
		
	}
	private void intstmt() {
		digit();
		while(getToken() == '0' || getToken() == '1' ) {
			digit();
		}
		
	}
	private void ifstmt() {
			match('I');
			comprsn();
			match('@');
			while (getToken() == 'W' || getToken() ==  'X' || getToken() == 'Y' || getToken() == 'Z'
					|| getToken() == 'I' || getToken() == 'D' || getToken() == 'R' || getToken() == 'O'
					|| getToken() == 'C'
					) {
				statemt();
			}
			if(getToken() == '%') {
				match('%');
				while (getToken() == 'W' || getToken() ==  'X' || getToken() == 'Y' || getToken() == 'Z'
						|| getToken() == 'I' || getToken() == 'D' || getToken() == 'R' || getToken() == 'O'
						|| getToken() == 'C'
						) {
					statemt();
				}
			}
			 else if(getToken() == '&') {
				match('&');
			} else error();
		
		
	}
	private void comprsn() {
		match('(');
		oprnd();
		opratr();
		oprnd();
		match(')');
		
	}
	private void opratr() {
		if(getToken() == '<'|| getToken() == '=' || getToken() == '>' || getToken() == '!' || getToken() == '^') {
			match(getToken());
		} else error();
	}
	private void dostmt() {
		match('D');
		while(getToken() == 'W' || getToken() ==  'X' || getToken() == 'Y' || getToken() == 'Z'
				|| getToken() == 'I' || getToken() == 'D' || getToken() == 'R' || getToken() == 'O'
				|| getToken() == 'C'
				) {
			statemt();
		}
		match('U');
		comprsn();
		match('E');
		
	}
	private void inout() {
		iosym();
		ident();
		while(getToken() == ',') {
			match(',');
			ident();
		}
		match(';');
		
	}
	private void iosym() {
		if(getToken() == 'R' || getToken() == 'O' ) {
			match(getToken());
		} else error();
		
	}
	private void progcall() {
		match('C');
		program();
		match('G');
		
	}
	//starts the code
	public void start() {
		program();
		match('$');
		if(errorflag == 0) {
			System.out.println("legal");
		} else System.out.println("error");
		
	}
}
