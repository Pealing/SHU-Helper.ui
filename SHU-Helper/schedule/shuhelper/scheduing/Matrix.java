package shuhelper.scheduing;

/**
 * ������
 * @author yy
 *
 */
public class Matrix {

	private int row;
	
	private int col;
	
	int[][] data;
	/**
	 * �޲ι��죬����һ����ʽ������ʵ���в�������0*0�Ŀվ���ע������ָ���쳣
	 */
	public Matrix() {
		this.row = 0;
		this.col = 0;
		this.data = new int[row][col];
	}
	
	/**
	 * ����ά�ȹ���
	 * @param row ��
	 * @param col ��
	 */
	public Matrix(int row,int col) {
		this.row = row;
		this.col = col;
		this.data = new int[row][col];
        for(int i=0;i<row;i++) {
    	   for(int j=0;j<col;j++) {
    		   data[i][j]=0;
    	   }
        }
	}
	
	/**
	 * �ö�ά�������������
	 * @param data ��������
	 */
	public Matrix(int[][] data) {
        row = data.length;
        col = data[0].length;
        this.data = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
            	this.data[i][j] = data[i][j];
            }
        }
    }
	
	/**
	 * ��ʼ������Ϊ��ͬ����
	 * @param row ����
	 * @param col ����
	 * @param allvalue �ض�������ֵ
	 */
	public Matrix(int row,int col,int allvalue)
    {
		this.row = row;
	    this.col = col;
	    int[][]tmp = new int[row][col];
        for(int i=0;i<row;i++) {
    	   for(int j=0;j<col;j++) {
    		   tmp[i][j]=allvalue;
    	   }
        }
       data=tmp;
    }
	
	/**
	 * ���ؾ�������
	 * @return ����
	 */
	public int getRowNumber() {
		return this.row;
	}

	/**
	 * ���ؾ�������
	 * @return ����
	 */
	public int getColoumNumber() {
		return this.col;
	}

	/**
	 * �����ض�������Ԫ��ֵ
	 * @param Row ������
	 * @param Coloum ������
	 * @return Ԫ��
	 */
	public int getElement(int Row, int Coloum) {
		return this.data[Row][Coloum];
	}

	/**
	 * �趨ָ������Ԫ��Ϊ�ض�ֵ
	 * @param Row ������
	 * @param Coloum ������
	 * @param e matrix[r][c]=e
	 */
	public String setToSpecifiedValue(int r, int c, int e) {
		if(this.data[r][c] == 1){
			return "��ʱ��ͻ��";
		}
		else{
			this.data[r][c] = e;
			return "�ſγɹ���";
		}
	}

	/**
	 * �趨ָ��������Ԫ��Ϊ�ض�ֵ
	 * @param Row ������
	 * @param e ֵ
	 * @return �趨��ľ���
	 */
	public Matrix setRowToSpecifiedValue(int Row, int e) {
		 for (int j = 0; j < col; j++) {
	            this.data[Row][j] = e;
		 }
	     return this;
	}

	/**
	 * �趨ָ��������Ԫ��Ϊ�ض�ֵ
	 * @param Coloum ������
	 * @param e ֵ
	 * @return �趨��ľ���
	 */
	public Matrix setColoumToSpecifiedValue(int Coloum, int e) {
		for (int i = 0; i < row; i++) {
			this.data[i][Coloum] = e;
		}
		return this;
	}
	/**
	 * �ж����������Ƿ����
	 * @param t ���ȽϾ���
	 * @return ��������
	 */
	public boolean equalTo(Matrix t) {
		 for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (data[i][j] != t.data[i][j]) {
	                	return false;
	                }
	            }
		 }
         return true;
	}

	/**
	 * ��ӡ����
	 */
	public void showMatrix() {
		for (int[] a : data) {
            for (int b : a) {
                System.out.printf("%9d ", b);
            }
            System.out.println();
        }
	}	
	/**
	 * ȡ���ض�����
	 * @param index ������
	 * @return �о���
	 */
	public Matrix getRow(int index) {
		Matrix A = new Matrix(1,col);
		for(int i=0;i<col;i++) {
			A.data[0][i] = data[index][i];
		}
		return A;
	}
	
	/**
	 * ȡ���ض�����
	 * @param index ������
	 * @return �о��� 
	 */
	public Matrix getColoum(int index) {
		Matrix A = new Matrix(row,1);
		for(int i=0;i<row;i++) {
			A.data[i][0] = data[i][index];
		}
		return A;
	}
}
