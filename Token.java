import java.util.ArrayList;

public interface Token
{
	public Token evaluate(ArrayList<Token> args);
	public String toString();
}
