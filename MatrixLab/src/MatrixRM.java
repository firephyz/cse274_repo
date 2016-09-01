/**
 * 
 */

/**
 * @author karroje
 *
 */
public class MatrixRM extends Matrix {
	int [] A;
	
	/**
	 * Constructor.  Should initialize all values to 0.
	 * @param num_rows
	 * @param num_cols
	 */
	public MatrixRM(int num_rows, int num_cols) {
		super(num_rows, num_cols);
		A = new int[num_rows*num_cols];
	}

	/* (non-Javadoc)
	 * @see Matrix#get(int, int)
	 */
	@Override
	public int get(int i, int j) {
		// TODO: Write code.  (Please remove this comment.)
	}

	/* (non-Javadoc)
	 * @see Matrix#set(int, int, int)
	 */
	@Override
	public void set(int i, int j, int val) {
		// TODO: Write code.  (Please remove this comment.)
	}
	
	/* (non-Javadoc)
	 * @see Matrix#find(int)
	 */
	public int[] find(int val) {
		// NOTE: DO this WITHOUT calling this.get() -- access A directly.
		// TODO: Write code.  (Please remove this comment.)
	}

}
