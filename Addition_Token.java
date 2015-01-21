import java.util.ArrayList;
import java.math.BigDecimal;

public class Addition_Token implements Token
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
		return left.evaluate().add(right.evaluate());	
	}
} 
