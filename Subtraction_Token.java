import java.util.ArrayList;
import java.math.BigDecimal;

public class Subtraction_Token
{

	Token left;
	Token right;

	public Subtraction_Token(Token left,Token right)
	{
		this.left = left;
		this.right = right;
	}	
	
	public BigDecimal evaluate()
	{
		left.evaluate().subtract(right.evaluate());	
	}
} 
