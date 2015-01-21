import java.math.BigDecimal;
import java.util.ArrayList;

public class Number_Token
{
	
	public BigDecimal number;

	public Number_Token(String stringRepresentation)
	{
		number = new BigDecimal(stringRepresentation);
	}

	public BigDecimal evaluate()
	{
		return number;
	}
}
