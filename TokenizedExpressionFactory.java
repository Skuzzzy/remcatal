import java.util.ArrayList;
import java.util.Stack;

public class TokenizedExpressionFactory
{

	public ArrayList<ShuntingYardToken> convertToPostfix(ArrayList<ShuntingYardToken> expression)
	{
		ArrayList<ShuntingYardToken> postfixExpression = new ArrayList<ShuntingYardToken>(); // Output Queue
		Stack<ShuntingYardToken> operatorStack = new Stack();
		int index = 0;
		ShuntingYardToken currentToken;

		while(index<expression.size()) // While there are tokens to be read
		{
			currentToken = expression.get(index);
			switch(currentToken.getType())
			{
				case NUMBER:
					postfixExpression.add(currentToken);
					index++;
					break;
				case FUNCTION:
					operatorStack.add(currentToken);
					break;
				case FUNCTION_SEPARATOR:
					// TODO Pop operators off the stack untill ( reached
					postfixExpression.add(currentToken);	
					break;
				case OPERATOR:
					// TODO
					break;
				case LEFT_PARENTHESIS:
					operatorStack.add(currentToken);
					break;
				case RIGHT_PARENTHESIS:
					// TODO Pop operators off the stack untill ( reached
					break;
				default:
					System.out.println("Skipping non recognized token type");
					index++;
					break;	
			}
			while(operatorStack.size() > 0)
			{
				currentToken = operatorStack.pop();
				if(currentToken.getType() != ShuntingYardToken.Type.LEFT_PARENTHESIS)
				{
					postfixExpression.add(currentToken);
				}
				else{
					System.out.println("Mismatched parenthesis found on operatorStack");
				}
			}
		}

		return postfixExpression;
	}
	private ArrayList<ShuntingYardToken> popOperatorsUntillParenthesis(Stack<ShuntingYardToken> operatorStack)
	{
		ArrayList<ShuntingYardToken> operators = new ArrayList<ShuntingYardToken>();
		ShuntingYardToken currentToken;
		while(operatorStack.size() > 0)
		{
			currentToken = operatorStack.pop();
			if(currentToken.getType() != ShuntingYardToken.Type.LEFT_PARENTHESIS)
			{
				operators.add(currentToken);
			}
			else
			{
				return postfixExpression;
			}
		}

		// TODO Handle mismatched parenthesis error here
		return null;
	}
	private Stack clearStackUntillParenthesis(Stack<ShuntingYardToken> operatorStack)
	{
		while(operatorStack.pop().getType() != ShuntingYardToken.Type.LEFT_PARENTHESIS){}
		return operatorStack;
	}
	
	/*
		Takes a string representing some expression and breaks it down into Tokens	
	*/	
	public ArrayList<ShuntingYardToken> StringTokenizedExpression(String expression)
	{
		int position = 0;
		ArrayList<ShuntingYardToken> tokenExpr = new ArrayList<ShuntingYardToken>();		
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
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.NUMBER, currentTokenString));
			}
			else if(isOperator(currentCharacter)) // Current char is a single char operator
			{
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.OPERATOR, ""+currentCharacter));
				position++;
			}
			else if(currentCharacter == '(')
			{
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.LEFT_PARENTHESIS, "("));
				position++;
			}
			else if(currentCharacter == ')')
			{
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.RIGHT_PARENTHESIS, ")"));
				position++;
			}
			else if(currentCharacter == ',')
			{
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.FUNCTION_SEPARATOR, ","));
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
				tokenExpr.add(new ShuntingYardToken(ShuntingYardToken.Type.FUNCTION, currentTokenString));
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
