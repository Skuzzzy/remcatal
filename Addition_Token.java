import java.util.ArrayList;
import java.math.BigDecimal;

public class Addition_Token
{

	Token left;
	Token right;

	public Addition_Token(Token left,Token right)
	{
		this.left = left;
		this.right = right;
	}	
	
	public BigDecimal evaluate()
	{
		left.evaluate().add(right.evaluate());	
	}
} 
