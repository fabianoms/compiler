package lexicalAnalysis;

public class Token {

	public enum TokenCategory {/*COLOCAR AQUI OS TIPOS DE TOKEN*/ ID, NUM, IF}
	
	private String lexeme;
	private TokenCategory category;
	
	public Token(String lexeme, TokenCategory category) {
		this.lexeme = lexeme;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "<" + lexeme + "," + category.name() + ">";
	}
}
