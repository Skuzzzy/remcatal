import java.util.ArrayList;

public class TokenizedExpressionFactory
{	
	public ArrayList<String> TokenizedExpression(String expression)
	{
		int position = 0;
		ArrayList<String> tokenExpr = new ArrayList<String>();		
		int exprLen = expression.length();

		while(position<exprLen) // Ensure we only parse to the end of the expression
		{
			String currentTokenString = ""; // Append chars to this string in order to form constructor string for token
			char currentCharacter = expression.charAt(position);
			if(Character.isSpaceChar(currentCharacter)) // Skip any white space in expression
			{
				position++;
			}
			else if(Character.isDigit(currentCharacter) || currentCharacter == '.') // Current char is the start of a number
			{	

				//TODO Make sure numbers like 5.5.5 do not get parsed properly
				currentTokenString += currentCharacter;
				position++;
				currentCharacter = expression.charAt(position);
				while((Character.isDigit(currentCharacter) || currentCharacter == '.') && (position<exprLen))
				{
					currentTokenString += currentCharacter;	
					position++;
					currentCharacter = expression.charAt(position);
				}
				//TODO Construct number token here with currentTokenString and add to the tokenExpr ArrayList
			}
			else if(isOperator(currentCharacter)) // Current char is a single char operator
			{
				//TODO Construct operator token where with the token char
				position++;
			}
			else if(currentCharacter == '(')
			{
				//TODO Construct a l-paren token	
				position++;
			}
			else if(currentCharacter == ')')
			{
				//TODO Construct a r-paren token 
				position++;
			}
			else if(Character.isLetter(currentCharacter)) // This is a function
			{	
			 	currentTokenString += currentCharacter;
			 	position++;
			 	currentCharacter = expression.charAt(position);
			 	while((Character.isLetter(currentCharacter)) && (position<exprLen))
			 	{
				 	currentTokenString += currentCharacter;	
				 	position++;
					currentCharacter = expression.charAt(position);
			 	}
			 	//TODO Construct number token here with currentTokenString and add to the tokenExpr ArrayList
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
