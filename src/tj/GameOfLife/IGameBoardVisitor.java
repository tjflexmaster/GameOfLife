package tj.GameOfLife;

/** Visitor pattern interface definition for objects
 * 	that visit IGameBoard objects.
 * 
 * @author TJ
 *
 */
public interface IGameBoardVisitor {

	public void visit(IGameBoard board);
}
