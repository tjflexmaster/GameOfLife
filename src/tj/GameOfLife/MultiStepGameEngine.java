package tj.GameOfLife;

public class MultiStepGameEngine extends SingleStepGameEngine 
{
	private int numberOfSteps;
	
	MultiStepGameEngine(int numberOfSteps)
	{
		setNumberOfSteps(numberOfSteps);
	}
	
	@Override
	public void visit(IGameBoard board) 
	{
		for(int stepCount = 0; stepCount < numberOfSteps; ++numberOfSteps)
		{
			System.out.println(new StringBuilder().append("Step :").append(stepCount).toString());
			super.visit(board);
		}
	}

	public int getNumberOfSteps() 
	{
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) 
	{
		this.numberOfSteps = numberOfSteps;
	}

}
