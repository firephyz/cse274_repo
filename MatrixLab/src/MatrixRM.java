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
		
		// Check for boundary conditions
		if(i >= n || j >= m) throw new ArrayIndexOutOfBoundsException();
		
		return A[i * m + j];
	}

	/* (non-Javadoc)
	 * @see Matrix#set(int, int, int)
	 */
	@Override
	public void set(int i, int j, int val) {
		
		// Check for boundary conditions
		if(i >= n || j >= m) throw new ArrayIndexOutOfBoundsException();
		
		A[i * m + j] = val;
	}
	
	/* (non-Javadoc)
	 * @see Matrix#find(int)
	 */
	public int[] find(int val) {
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(A[i * m + j] == val) {
					int[] result = {i, j};
					return result;
				}
			}
		}
		
		return null;
	}

}
