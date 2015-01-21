import java.math.BigDecimal;

public class Multiplication_Token implements Token
{

	Token left;
	Token right;

	public Multiplication_Token(Token left,Token right)
	{
		this.left = left;
		this.right = right;
	}	
	
	public BigDecimal evaluate()
	{
		return left.evaluate().multiply(right.evaluate());	
	}
} 
