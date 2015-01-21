public class ShuntingYardToken
{
	public enum Type
	{
	NUMBER,
	FUNCTION,
	FUNCTION_SEPARATOR,
	LEFT_PARENTHESIS,
	RIGHT_PARENTHESIS,
	OPERATOR	
	}

	public String data;
	public Type tokenType;

	public ShuntingYardToken(Type tokenType,String data)
	{
		this.tokenType = tokenType;
		this.data = data;
	}

}
