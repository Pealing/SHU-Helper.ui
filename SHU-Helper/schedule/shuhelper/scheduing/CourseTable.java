package shuhelper.scheduing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import shuhelper.scheduing.Matrix;

public class CourseTable extends Matrix{
	Matrix courseTable=new Matrix(13,5);
	public Matrix getCourseTable(){
		return courseTable;
	}
	public String pickClassTime(String str){
		//String regEx = "[\u2E80-\u9FFF]";
		String regEx = "[һ][0-9]{1,2}.[0-9]{1,2}|[��][0-9]{1,2}.[0-9]{1,2}|[��][0-9]{1,2}.[0-9]{1,2}|[��][0-9]{1,2}.[0-9]{1,2}|[��][0-9]{1,2}.[0-9]{1,2}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		String string="";
		String week="";
		String time="";
		while(matcher.find()){
			//�ܼ�
			week=matcher.group();
			System.out.println(week);
			String regEx1 = "[һ]|[��]|[��]|[��]|[��]";
			Pattern pattern1 = Pattern.compile(regEx1);
			Matcher matcher1 = pattern1.matcher(week);
			while(matcher1.find()){	
				time=matcher1.group();
				//�Ͽ�ʱ��
				
				if(time.equals("һ")){	
					String regEx2 = "[0-9]{1,2}";
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(week);
					int []stime={-1,-1};
					int k=0;
					Integer it;
					while(matcher2.find()){
						it = new Integer(matcher2.group(0));
						stime[k++]=it.intValue();
					}
					//System.out.println(stime[0]+"   "+stime[1]);
					for(int i=stime[0]-1;i<stime[1];i++){
						if(courseTable.setToSpecifiedValue(i, 0, 1).equals("��ʱ��ͻ��")){
							System.out.println("��ʱ��ͻ��");
							return "��ʱ��ͻ��";
						}
						else{
							courseTable.setToSpecifiedValue(i, 0, 1);
						}
					}
				}
				if(time.equals("��")){	
					String regEx2 = "[0-9]{1,2}";
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(week);
					int []stime={-1,-1};
					int k=0;
					Integer it;
					while(matcher2.find()){
						it = new Integer(matcher2.group(0));
						stime[k++]=it.intValue();
					}
					//System.out.println(stime[0]+"   "+stime[1]);
					for(int i=stime[0]-1;i<stime[1];i++){
						if(courseTable.setToSpecifiedValue(i, 1, 1).equals("��ʱ��ͻ��")){
							System.out.println("��ʱ��ͻ��");
							return "��ʱ��ͻ��";
						}
						else{
							courseTable.setToSpecifiedValue(i, 1, 1);
						}
					}
				}
				if(time.equals("��")){	
					String regEx2 = "[0-9]{1,2}";
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(week);
					int []stime={-1,-1};
					int k=0;
					Integer it;
					while(matcher2.find()){
						it = new Integer(matcher2.group(0));
						stime[k++]=it.intValue();
					}
					//System.out.println(stime[0]+"   "+stime[1]);
					for(int i=stime[0]-1;i<stime[1];i++){
						if(courseTable.setToSpecifiedValue(i, 2, 1).equals("��ʱ��ͻ��")){
							System.out.println("��ʱ��ͻ��");
							return "��ʱ��ͻ��";
						}
						else{
							courseTable.setToSpecifiedValue(i, 2, 1);
						}
					}
				}
				if(time.equals("��")){	
					String regEx2 = "[0-9]{1,2}";
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(week);
					int []stime={-1,-1};
					int k=0;
					Integer it;
					while(matcher2.find()){
						it = new Integer(matcher2.group(0));
						stime[k++]=it.intValue();
					}
					//System.out.println(stime[0]+"   "+stime[1]);
					for(int i=stime[0]-1;i<stime[1];i++){
						if(courseTable.setToSpecifiedValue(i, 3, 1).equals("��ʱ��ͻ��")){
							System.out.println("��ʱ��ͻ��");
							return "��ʱ��ͻ��";
						}
						else{
							courseTable.setToSpecifiedValue(i, 3, 1);
						}
					}
				}
				if(time.equals("��")){	
					String regEx2 = "[0-9]{1,2}";
					Pattern pattern2 = Pattern.compile(regEx2);
					Matcher matcher2 = pattern2.matcher(week);
					int []stime={-1,-1};
					int k=0;
					Integer it;
					while(matcher2.find()){
						it = new Integer(matcher2.group(0));
						stime[k++]=it.intValue();
					}
					//System.out.println(stime[0]+"   "+stime[1]);
					for(int i=stime[0]-1;i<stime[1];i++){
						if(courseTable.setToSpecifiedValue(i, 4, 1).equals("��ʱ��ͻ��")){
							System.out.println("��ʱ��ͻ��");
							return "��ʱ��ͻ��";
						}
						else{
							courseTable.setToSpecifiedValue(i, 4, 1);
						}
					}
				}
			}
			string=string+matcher.group();
		}
		System.out.println(string);
		return string;
	}
	
	public static void main(String[] args) throws Exception {
		CourseTable courseTable=new CourseTable();
		String string="��1-3 ѧԺ�����ϻ� ��3-4����";
		courseTable.pickClassTime(string);
		courseTable.courseTable.showMatrix();
	}
}
