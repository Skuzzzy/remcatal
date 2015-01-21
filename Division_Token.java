import java.math.BigDecimal;

public class Division_Token implements Token
{
	
	public static int PRECISION = 15;	

	Token left;
	Token right;

	public Division_Token(Token left,Token right)
	{
		this.left = left;
		this.right = right;
	}	
	
	public BigDecimal evaluate()
	{
		return left.evaluate().divide(right.evaluate(),PRECISION);	
	}
} 
