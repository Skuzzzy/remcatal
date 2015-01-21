import java.util.ArrayList;
import ShuntingYardToken;

public class TokenizedExpressionFactory
{
	
	/*
		
	*/
	public Token TokenizedExpression(ArrayList<String> expressionList)
	{
		return new Number_Token("0");
	}

	/*
		Takes a string representing some expression and breaks it down into smaller string peices ready to be processed into Tokens	
	*/	
	public ArrayList<ShuntingYardToken> StringTokenizedExpression(String expression)
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
			else if(isPartOfNumber(currentCharacter)) // Current char is the start of a number
			{	
				
				while((position<exprLen) && isPartOfNumber(currentCharacter))
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
				//tokenExpr.add(currentTokenString);	
			}
			else if(isOperator(currentCharacter)) // Current char is a single char operator
			{
				//tokenExpr.add(""+currentCharacter);	
				position++;
			}
			else if(currentCharacter == '(')
			{
				//tokenExpr.add("(");	
				position++;
			}
			else if(currentCharacter == ')')
			{
				//tokenExpr.add(")");	
				position++;
			}
			else if(currentCharacter == ',')
			{
				//tokenExpr.add(",");
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
				//tokenExpr.add(currentTokenString);	
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
		return (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^');
	}

	private boolean isPartOfNumber(char ch)
	{
		return (Character.isDigit(ch) || ch == '.');
	}
	
}
