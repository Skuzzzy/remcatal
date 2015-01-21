import java.util.ArrayList;

public class TokenizedExpressionFactory
{

	public ArrayList<Token> getTokensFromString(String expression)
	{
		return TokenizedExpression(StringTokenizedExpression(expression));
	}

	
	public Token TokenizedExpression(ArrayList<String> expressionList)
	{
		return new Token;
	}
	
	public ArrayList<String> StringTokenizedExpression(String expression)
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
				
				while((position<exprLen) && (Character.isDigit(currentCharacter) || currentCharacter == '.'))
				{
					if(currentCharacter == '.')
					{
						if(currentTokenString.contains(".")) // Prevents numbers like 5.5.5 from being successfully parsed
						{
							System.out.println("Number already has decimal");
							//TODO Handle Error
						}
					}

					currentTokenString += currentCharacter;
					position++;
					if(position<exprLen)
					{
						currentCharacter = expression.charAt(position);
					}
					
				}
				tokenExpr.add(currentTokenString);	
			}
			else if(isOperator(currentCharacter)) // Current char is a single char operator
			{
				tokenExpr.add(""+currentCharacter);	
				position++;
			}
			else if(currentCharacter == '(')
			{
				tokenExpr.add("(");	
				position++;
			}
			else if(currentCharacter == ')')
			{
				tokenExpr.add(")");	
				position++;
			}
			else if(currentCharacter == ',')
			{
				tokenExpr.add(",");
				position++;
				
			}
			else if(Character.isLetter(currentCharacter)) // This is a function
			{	

				while(position<exprLen && Character.isLetter(currentCharacter))
				{
					currentTokenString += currentCharacter;
					position++;
					if(position<exprLen)
					{
						currentCharacter = expression.charAt(position);
					}
				}
				tokenExpr.add(currentTokenString);	
			}
			else
			{
				//TODO Handle bad input here
				System.out.println(currentCharacter + " not recognized by parser. Character will be skipped");
				position++;
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
