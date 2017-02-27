package shuhelper.scheduing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import shuhelper.web.WebAPI;
import shuhelper.web.XKWebAPI;

@SuppressWarnings("serial")
public class TestSchedule extends JFrame{
	private static Scanner in = new Scanner(System.in);
	Schedule sframe = new Schedule();
	JFrame frame;
	static JTextField []text=new JTextField[5];
	mTable table = new mTable();
	JTable table1 = new JTable();
	JLabel []labels = new JLabel[9];
	JScrollPane scrollPane = new JScrollPane();
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	static JCheckBox noMorningClass=new JCheckBox("�������");
	static JCheckBox noNoonClass=new JCheckBox("�������");
	static JCheckBox noFridayClass=new JCheckBox("���������");
	int tableWidth=0;
	int tableHeigth=0;
	//�����ѡ�γ�
	ArrayList<String[]> courses = new ArrayList<String[]>();
	//������˿γ�
	ArrayList<String[]> dropCourses = new ArrayList<String[]>();
	static ArrayList<String[]> courseData = new ArrayList<String[]>();
	String [] courseNo= new String[4];
	String [] classTime=new String[4];
	String [] teacherName=new String[4];
	@SuppressWarnings("rawtypes")
	static
	JComboBox campus = null;
	//Object [][]courseData=new Object[13][5];
	Object [][]data=null;
	
	public void Init() throws Exception{
		frame = new JFrame("�ſ�ģ��");
		frame.setLayout(null);
		frame.setSize(1280, 960);
		frame.setBounds(100,200,960,700);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addButton(){
		button1 = new JButton("��ѯ");
		button2 = new JButton("���");
		button3 = new JButton("����");
		button4 = new JButton("ѡ�����");
		button5 = new JButton("ѡ��");
		button6 = new JButton("�˿�");
		button1.setBounds(40, 160, 60, 30);
		button2.setBounds(130, 160, 60, 30);
		button3.setBounds(220, 160, 60, 30);
		button4.setBounds(310, 160, 90, 30);
		button5.setBounds(430, 160, 60, 30);
		button6.setBounds(520, 160, 60, 30);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
	}
	public void addText(){
		for(int i=0;i<4;i++){
			text[i]=new JTextField(null);
			frame.add(text[i]);	
			text[i].setVisible(true);
			text[i].setLayout(null);
		}
		text[0].setBounds(90, 20, 120, 30);
		text[1].setBounds(300, 20, 120, 30);
		text[2].setBounds(90, 60, 120, 30);
		text[3].setBounds(300, 60, 120, 30);
		//text[4].setBounds(300, 100, 120, 30);
	}
	public void addLabel(){
		labels[0]=new JLabel("�γ̺�");
		frame.add(labels[0]);
		labels[0].setBounds(30, 20, 50 , 20);
		labels[1]=new JLabel("�Ͽ�ʱ��");
		frame.add(labels[1]);
		labels[1].setBounds(225, 20, 60 , 20);
		labels[2]=new JLabel("��ʦ��");
		frame.add(labels[2]);
		labels[2].setBounds(30, 65, 50 , 20);
		labels[4]=new JLabel("ѧ��");
		frame.add(labels[4]);
		labels[4].setBounds(225, 65, 50 , 20);
		labels[5]=new JLabel("У��");
		frame.add(labels[5]);
		labels[5].setBounds(30, 105, 50 , 20);
		labels[3]=new JLabel("��������");
		frame.add(labels[3]);
		labels[3].setBounds(450, 10, 100 , 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addComboBox(){
		String str1[]={"����","�ζ�","�ӳ�","ȫ��"};
		campus = new JComboBox(str1);
		frame.add(campus);
		campus.setVisible(true);
		campus.setBounds(90, 100, 120, 30);
		
	}
	public static String getCourseNo(){
		return text[0].getText();
	}
	public static String getClassTime(){
	
		return text[1].getText();
	}
	
	public static String getTeacherName(){
		
		return text[2].getText();
	}
	public static String getCredit(){
		
		return text[3].getText();
	}
	public static String getCampus(){
		
		return (String) campus.getSelectedItem();
	}
public void addCheckBox(){
		
		noMorningClass.setBounds(500,40,120,30);
		noNoonClass.setBounds(500,80,120,30);
		noFridayClass.setBounds(500,120,120,30);
		
		frame.add(noMorningClass);
		frame.add(noNoonClass);
		frame.add(noFridayClass);
	}
	
	public void drawTable(Object [][]data,int s) throws Exception{
				
		String []cloName={"�γ̺�", "�γ���", "ѧ��", "��ʦ��", "��ʦ��", "�Ͽ�ʱ��", 
						"�Ͽεص�", "����", "����", "У��", "ѡ������", "����ʱ��", "���ɵص�","ѡ��"};
		//scrollPane.removeAll();
		DefaultTableModel tabDemo = (DefaultTableModel) table.getModel();
		tabDemo.setRowCount(0);
		tabDemo.setColumnIdentifiers(cloName);
		JCheckBox jc = new JCheckBox();
        table.getColumnModel().getColumn(13).setCellEditor(new DefaultCellEditor(jc));
		for(int i=0;i<s;i++){
			
			 Object[] objdata = { data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],
					 data[i][5],data[i][6],data[i][7],data[i][8],data[i][9],data[i][10],
					 data[i][11],data[i][12],false};
			 tabDemo.addRow(objdata);
			}
		tabDemo.setRowCount(s);
		table.updateUI();
		table.setRowHeight(25);
		DefaultTableCellRenderer font = new DefaultTableCellRenderer();// ����table���ݾ���
		font.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, font);
		fitTableColumns(table);
		scrollPane.setViewportView(table);
		scrollPane.repaint();
		scrollPane.setBounds(20, 280, tableWidth, tableHeigth);
		frame.validate();
		frame.add(scrollPane);
	}
	public void fitTableColumns(JTable myTable) {
		tableWidth=0;
         myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         JTableHeader header = myTable.getTableHeader();
         int rowCount = myTable.getRowCount();
         
         Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
         while(columns.hasMoreElements()) {
        	 
            TableColumn column = (TableColumn)columns.nextElement();
            
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int)header.getDefaultRenderer().getTableCellRendererComponent
            (myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
            for(int row = 0; row < rowCount; row++) {
                int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent
                (myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
		header.setResizingColumn(column); 
		column.setWidth(width+myTable.getIntercellSpacing().width);
		tableWidth+=width+myTable.getIntercellSpacing().width;
		}
        tableWidth+=10;
        tableHeigth=table.getRowCount()*table.getRowHeight()+25;
	}

	public void myEvent(){
		data=new Object[Schedule.courseSize()][13];
	 button1.addActionListener(new ActionListener()
     {
           public void actionPerformed(ActionEvent e)
           { 	   	
        	   try {
       			data=new Object[Schedule.courseSize()][13];
               	//scrollPane.remove(table);
               	data=TestSchedule.testSchedule();
       			drawTable(data,Schedule.courseSize());
       		} catch (Exception e1) {
       			// TODO Auto-generated catch block
       			e1.printStackTrace();
       		}
           } 
	  });
	 button2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<4;i++){
				text[i].setText(null);
			}
			courseData.clear();
		}
	});
	 
	 button3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//�����ѡ�γ�
			for(int i=0;i<courseData.size();i++){
				if((boolean) table.getValueAt(i, 13)){
					
					courses=sframe.saveEleCourse(courseData, i, courses);
					
				}
			}
			
			output(courses, "��ѡ�γ�");
		}
	});
	 
	 button4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//ѡ�����
			ArrayList<String[]> arrayList=new ArrayList<String[]>();
			
			arrayList=sframe.selectedCourse();
			scrollPane.remove(table);
			scrollPane.remove(table1);
			Object [][]data=new Object[arrayList.size()][8];
			for(int i=0;i<arrayList.size();i++){
				data[i]=arrayList.get(i);
			}
			String []cloName={"�γ̺�", "�γ���", "��ʦ��", "��ʦ��", "ѧ��", "�Ͽ�ʱ��", 
					"�Ͽεص�","У��","ѡ��"};
			
			DefaultTableModel tabDemo = (DefaultTableModel) table1.getModel();
			tabDemo.setRowCount(0);
			tabDemo.setColumnIdentifiers(cloName);
			JCheckBox jc = new JCheckBox();
			table1.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(jc));
			for(int i=0;i<arrayList.size();i++){
				Object[] objdata = { data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],
				 data[i][5],data[i][6],data[i][7],false};
				tabDemo.addRow(objdata);
			}
			tabDemo.setRowCount(arrayList.size());
			table1.setRowHeight(25);
			DefaultTableCellRenderer font = new DefaultTableCellRenderer();// ����table���ݾ���
			font.setHorizontalAlignment(JLabel.CENTER);
			table1.setDefaultRenderer(Object.class, font);
			
			fitTableColumns(table1);
			scrollPane.setViewportView(table1);
			scrollPane.repaint();
			scrollPane.setBounds(20, 280, tableWidth+20, tableHeigth+30);
			frame.add(scrollPane);
		}
	});
	 button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ѡ��
				String []str=new String[11];
				for(int i=0;i<courses.size();i++){
					str=courses.get(i);
					try {
						Schedule.XK.getEnrollStatus();
						System.out.println(Schedule.XK.enrollCourse(str[0], str[3]));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//output(sframe.eleCourse(courses),"ѡ��");
			}
		});
	 button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�˿�
				ArrayList<String[]> arrayList = new ArrayList<String[]>();
				String []str=new String[8];
				arrayList=sframe.selectedCourse();
				
				for(int i=0;i<arrayList.size();i++){
					if((boolean) table1.getValueAt(i, 8)){
						str=arrayList.get(i);
						try {
							Schedule.XK.getEnrollStatus();
							System.out.println(Schedule.XK.returnCourse(str[0], str[2]));
						} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	public static void output(ArrayList<String[]> arrayList, String title) {
		System.out.println("================================");
		System.out.println(title);
		System.out.println("================================");
		for (String[] row : arrayList) {
			for (String col : row)
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.printf("-------- Total %d row(s) --------\n", arrayList.size());
	}
	private static boolean login(WebAPI web) throws Exception {
		// ��ȡ��֤��ͼƬ
		String validatePath = web.getCaptcha();
		System.out.println("��֤��ͼƬ�洢��: " + validatePath);
		
		// ��¼����
		System.out.print("ѧ��: ");
		String username = in.next();;
		System.out.print("����: ");
		String password = in.next();;
		System.out.print("��֤��: ");
		String validate = in.next();
		
		// ���Ե�¼
		String res = web.login(username, password, validate);
		System.out.println("��¼���: " + res);
		
		// ���ص�¼״̬
		return web.isLogin();
	}
	public void testXKWebAPI() throws Exception {
		// ʵ���� XKWebAPI
		Schedule.XK=new XKWebAPI();
		
		// �鿴ѧ��
		String[] termInfo = Schedule.XK.getTermInfo();
		for (int i = 0; i < termInfo.length; i++) {
			System.out.printf("[%d] %s\n", i, termInfo[i]);
		}
	
		// ѡ��
		System.out.print("��ѡ��ѧ�ڱ��: ");
		int termNo = in.nextInt();
		Schedule.XK.setTerm(termNo);
	
		// ��¼
		if (!login(Schedule.XK)) return;
		//��ȡ�α�״̬
		//conflict.getCourseTable().showMatrix();
		//sframe.initCourseStatus(Schedule.XK.getCourseTableArrayList(), conflict);
	}
	public static Object [][] testSchedule() throws Exception {
		if(!getCourseNo().equals("")&getClassTime().equals("")&&getTeacherName().equals("")&&getCredit().equals("")){
			courseData=Schedule.schedule(getCourseNo(),noMorningClass,noNoonClass,noFridayClass);
			Schedule.data=Schedule.getData(courseData.size(), courseData);
		}
		if(!getCourseNo().equals("")&&!getClassTime().equals("")&&getTeacherName().equals("")&&getCredit().equals("")){
			courseData=Schedule.scheTime(getCourseNo(),getClassTime(),noMorningClass,noNoonClass,noFridayClass);
			Schedule.data=Schedule.getData(courseData.size(), courseData);
		}
		if(!getCourseNo().equals("")&&getClassTime().equals("")&&!getTeacherName().equals("")&&getCredit().equals("")){
			courseData=Schedule.schedTeacher(getCourseNo(),getTeacherName(),noMorningClass,noNoonClass,noFridayClass);
			Schedule.data=Schedule.getData(courseData.size(), courseData);
		}
		if(!getCourseNo().equals("")&&!getClassTime().equals("")&&!getTeacherName().equals("")&&!getCredit().equals("")){
			courseData=Schedule.schedTeacher(getCourseNo(),getTeacherName(),noMorningClass,noNoonClass,noFridayClass);
			Schedule.data=Schedule.getData(courseData.size(), courseData);
		}
		return Schedule.data;
	}

	public void sfmain() throws Exception {
		Init();
		addLabel();
		addCheckBox();
		addButton();
		addComboBox();
		addText();

		try {
			testXKWebAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myEvent();
	}
	class mTable extends JTable{
		@Override 
		public boolean isCellEditable(int rowIndex, int columnIndex) {  
		        if(columnIndex == 13) return true;  
		        return false;  
		}
		 @Override
		public Class<?> getColumnClass(int columnIndex) {
		        return getValueAt(0, columnIndex).getClass();
		}	 
	}
	public static void main(String[] args) throws Exception {
		TestSchedule schedule=new TestSchedule();
		schedule.sfmain();
	}
	
}
