import java.util.ArrayList;
import java.lang.StringBuilder;

public class TokenizedExpressionFactory
{	
	public ArrayList<String> TokenizedExpression(String expression)
	{
		int position = 0;
		ArrayList<String> tokenExpr = new ArrayList<String>();		

		while(position<expression.length()) // Ensure we only parse to the end of the expression
		{
			char currentCharacter = expression.charAt(position);
			if(Character.isSpaceChar(currentCharacter)) // Skip any white space in expression
			{
				position++;
			}
			else if(Character.isDigit(currentCharacter) || currentCharacter == '.') // Current char is the start of a number
			{
				
			}
			else if(isOperator(currentCharacter)) // Current char is a single char operator
			{

			}
			else if(Character.isLetter(currentCharacter)) // This is a function
			{

			} 
			
			

		}	
		
		return tokenExpr;	


	}	

	private boolean isOperator(char ch)
	{
		if(ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
