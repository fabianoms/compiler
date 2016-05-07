package lexicalAnalysis;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import exceptions.CharNotFoundException;

/***
 * 
 * @author Fabiano
 *
 */
public class Scanner {

	private String[] sourceCode;
	private List<Token> tokens;
	private int tokenToReturnIndex;
	//private Automata automata;
	
	
	private int lineIndex;
	private int charIndex;
	
	public Scanner(String[] src) {
		sourceCode = src;
		tokens = new ArrayList<Token>();
		tokenToReturnIndex = 0;
		lineIndex = -1;
		charIndex = -1;
	}
	
	public String[] getSourceCode() {
		return sourceCode;
	}
	
	public Token nextToken() {
		if (tokenToReturnIndex < 0 ||
			tokenToReturnIndex >= tokens.size()) {
			return null;
		}
		return tokens.get(tokenToReturnIndex++); 
	}

	public List<Token> getAllTokens() {
		return tokens;
	}

	public void scan() {
		while (hasNextChar() /*&& automataState != error*/) {
			try {
				System.out.print(nextChar());
			} catch (CharNotFoundException e) {
				System.err.println("Charnotfoundexception");
			}
		}
	}
	
	private char nextChar() throws CharNotFoundException {
		if (!hasNextChar()) {
			throw new CharNotFoundException();
		}
		
		updateIndexes();
		return charAt(lineIndex,charIndex);
	}
	
	private char lookahead() throws CharNotFoundException {
		if (!hasNextChar()) {
			throw new CharNotFoundException();
		}
		
		Point indexes = nextCharIndex(); //get next char without update indexes
		return charAt(indexes.y, indexes.x);
	}
	
	private char charAt(int lineIndex, int charIndex) {
		return sourceCode[lineIndex].charAt(charIndex);
	}
	
	private boolean hasNextChar() {
		if (lineIndex == -1 && charIndex == -1) {
			return true;
		}
		if (lineIndex == sourceCode.length-1
			&& charIndex == sourceCode[lineIndex].length() - 1) {
			return false;
		}
		return true;
	}
	
	private void updateIndexes() {
		Point newIndexes = nextCharIndex();
		lineIndex = newIndexes.y;
		charIndex = newIndexes.x;
	}
	
	private Point nextCharIndex() {
		int line = lineIndex;
		int charI = charIndex;
		if (line == -1 && charI == -1) {
			line++;
			charI++;
		}
		else if (charI == sourceCode[line].length() - 1) {
			line++;
			charI = 0;
		} else {
			charI++;
		}
		
		return new Point(charI, line);
	}
	
	
	

	
	
}
