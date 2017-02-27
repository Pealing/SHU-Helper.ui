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
		String regEx = "[一][0-9]{1,2}.[0-9]{1,2}|[二][0-9]{1,2}.[0-9]{1,2}|[三][0-9]{1,2}.[0-9]{1,2}|[四][0-9]{1,2}.[0-9]{1,2}|[五][0-9]{1,2}.[0-9]{1,2}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		String string="";
		String week="";
		String time="";
		while(matcher.find()){
			//周几
			week=matcher.group();
			System.out.println(week);
			String regEx1 = "[一]|[二]|[三]|[四]|[五]";
			Pattern pattern1 = Pattern.compile(regEx1);
			Matcher matcher1 = pattern1.matcher(week);
			while(matcher1.find()){	
				time=matcher1.group();
				//上课时间
				
				if(time.equals("一")){	
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
						if(courseTable.setToSpecifiedValue(i, 0, 1).equals("课时冲突！")){
							System.out.println("课时冲突！");
							return "课时冲突！";
						}
						else{
							courseTable.setToSpecifiedValue(i, 0, 1);
						}
					}
				}
				if(time.equals("二")){	
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
						if(courseTable.setToSpecifiedValue(i, 1, 1).equals("课时冲突！")){
							System.out.println("课时冲突！");
							return "课时冲突！";
						}
						else{
							courseTable.setToSpecifiedValue(i, 1, 1);
						}
					}
				}
				if(time.equals("三")){	
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
						if(courseTable.setToSpecifiedValue(i, 2, 1).equals("课时冲突！")){
							System.out.println("课时冲突！");
							return "课时冲突！";
						}
						else{
							courseTable.setToSpecifiedValue(i, 2, 1);
						}
					}
				}
				if(time.equals("四")){	
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
						if(courseTable.setToSpecifiedValue(i, 3, 1).equals("课时冲突！")){
							System.out.println("课时冲突！");
							return "课时冲突！";
						}
						else{
							courseTable.setToSpecifiedValue(i, 3, 1);
						}
					}
				}
				if(time.equals("五")){	
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
						if(courseTable.setToSpecifiedValue(i, 4, 1).equals("课时冲突！")){
							System.out.println("课时冲突！");
							return "课时冲突！";
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
		String string="五1-3 学院机房上机 五3-4研讨";
		courseTable.pickClassTime(string);
		courseTable.courseTable.showMatrix();
	}
}
