package quadricmatrix;
import java.util.*;

public class quadricmatrix {
	private double elements[][];
	
	public quadricmatrix(int rows, int cols)
	{
		
		this.elements = new double[rows][cols]; // create a new matrix 
	}

	// Return the rows 
	public int rows() 
	{
		return elements.length; 
	}
	  
	// Return the columns
	public int cols() 
	{ 
		return elements[0].length; 
	}


	public void set(int row, int col, double value) 
	{
		   if((row < 1) || (row > rows()) || (col < 1) || (col > cols())) 
		   {
			   System.out.println("OutOfBoundsException");
			   return;
		   }
		   elements[row-1][col-1] = value;
	}
	  
	// Return the matrix value at row m and column n.
	public double get(int row, int col) {
	   if((row < 1) || (row > rows()) || (col < 1) || (col > cols())) 
	   {
		   System.out.println("OutOfBoundsException");
		   return Double.NaN;
	   }
	   return elements[row-1][col-1];
	}

	public quadricmatrix transpose() 
	{
		quadricmatrix trans = new quadricmatrix(cols(), rows());
	   for(int i = 1; i <= cols(); i++) 
	   {
		   
		   for(int j = 1; j <= rows(); j++) 
		   {
			   trans.set(i, j, get(j, i));
		   }
	   }
	   return trans;
	}
	  
	// Printing the matrix
	public void println() 
	{
	   double v;
	   for(int i = 1; i <= rows(); i++) 
	   {
		   System.out.format("[");
		   for(int j = 1; j <= cols(); j++) 
		   {
			   if(j>1)
			   System.out.format(" ");
			   v = get(i, j);
			   System.out.format("%.2f", v);
		   }
	   System.out.format("] \n");
	   }
	}

	// function to add two matrices and return sum matrix
	public quadricmatrix add(quadricmatrix B) {

	   if((rows()!=B.rows()) || (cols()!=B.cols())) 
	   {
		   System.out.println("Cannot add these 2 Matrices");
		   System.exit(0);
	   }
	  
	// addition matrix is the matrix that contains the sum
	   quadricmatrix addition = new quadricmatrix(rows(), cols());
	   double v;
	   for(int i = 1; i <= rows(); i++) 
	   {
		   for(int j = 1; j <= cols(); j++) {
			   v = get(i, j);
			   addition.set(i, j, v+B.get(i, j));
		   }
	   }
	   return addition;
	}

	// function to multiply two matrices and return the product matrix
	public quadricmatrix mul(quadricmatrix B) 
	{
	  
	// multiply matrix is the matrix that contains the product
		quadricmatrix multiply = new quadricmatrix(rows(), B.cols());
	   double v, w;
	   if(cols()!=B.rows()) 
	   {
		   System.out.println("Can't multiply these 2 Matrices");
		   System.exit(0);
	   }

	   for(int i = 1; i <= rows(); i++) 
	   {
		   for(int j = 1; j <= B.cols(); j++) 
		   {
			   double s = 0;
			   for(int k = 1; k <= cols(); k++) 
			   {
				   v = get(i, k);
				   w = B.get(k, j);
				   s += v*w;
			   }
	       multiply.set(i, j, s);
		   }
	   }
	   return multiply;
	}
	
	public static void main(String args[]) 
	{
		  
		Scanner scan = new Scanner(System.in);
		
		quadricmatrix m =new quadricmatrix(3,3);
		for(int i=1; i<=m.rows(); i++)
		{
			for(int j=1;j<=m.cols();j++)
			{
				System.out.println("rows "+ i +" col " + j);
				System.out.println("Enter number :" );
				double v = scan.nextDouble();
				m.set(i,j,v);
			}
		}
	  
	System.out.println("Matrix 1:");
	m.println();
	  
	quadricmatrix n = new quadricmatrix (3,3);
	for(int i=1;i<=m.rows();i++){
		for(int j=1;j<=m.cols();j++)
		{
			System.out.println("M2 rows "+ i +" col " + j);
			 System.out.println("Enter number :");
			double v = scan.nextDouble();
			n.set(i,j,v);
		}
	}
	  
	System.out.println();
	System.out.println("Matrix 2:");
	n.println();
	  
	quadricmatrix c = m.add(n);
	System.out.println();
	System.out.println("Matrix Add:");
	c.println();
	  
	quadricmatrix d = m.mul(n);
	System.out.println();
	System.out.println("Matrix Multiply:");
	d.println();
	}
	}


