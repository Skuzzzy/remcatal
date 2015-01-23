import java.util.ArrayList;
public class Main
{
	public static void main(String[] args)
	{
		TokenizedExpressionFactory chips = new TokenizedExpressionFactory();
		ArrayList<ShuntingYardToken> newRef = chips.StringTokenizedExpression(args[0]);		
		for(int i=0; i<newRef.size() ; i++)
		{
			System.out.println(newRef.get(i).data);
		}
	}
}
