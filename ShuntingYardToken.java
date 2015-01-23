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

	private String data;
	private Type tokenType;

	public ShuntingYardToken(Type tokenType,String data)
	{
		this.tokenType = tokenType;
		this.data = data;
	}
	public Type getType()
	{
		return tokenType;
	}
	public String getData()
	{
		return data;
	}

}
