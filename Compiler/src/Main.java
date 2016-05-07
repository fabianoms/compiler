import java.util.ArrayList;
import java.util.List;

import lexicalAnalysis.Scanner;
import lexicalAnalysis.Token;
import util.SourceReader;

public class Main {
	public static void main(String[] args) {
		testToken();
		
		//runScanner(args);
		
	}
	
	private static void runScanner(String[] args) {
		if (!validArgs(args)) {
			return;
		}
		
		SourceReader sourceReader = new SourceReader(args[0]);
		String[] sourceCode = sourceReader.readContent();
		Scanner lexicalAnalyser = new Scanner(sourceCode);
		
		lexicalAnalyser.scan();
				
		printTokens(lexicalAnalyser.getAllTokens());
		
	}

	private static void testToken() {
		Token t1, t2, t3;
		t1 = new Token("c", Token.TokenCategory.ID);
		t2 = new Token("", Token.TokenCategory.IF);
		t3 = new Token("23", Token.TokenCategory.NUM);
		
		List<Token> tokens = new ArrayList();
		tokens.add(t1);
		tokens.add(t2);
		tokens.add(t3);
		printTokens(tokens);
	}
	
	private static void printTokens(List<Token> tokens) {
		for(Token token : tokens) {
			System.out.println(token);
		}
	}

	public static boolean validArgs(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("Argument missing: source code file name.");
			return false;
		}
		if (args.length != 1) {
			System.err.println("Just one argument must be given.");
			return false;
		}
		
		return true;
	}
}
