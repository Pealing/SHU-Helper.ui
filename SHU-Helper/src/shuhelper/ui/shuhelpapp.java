package shuhelper.ui;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import shuhelper.scheduing.Schedule;
import shuhelper.scheduing.TestSchedule;
import shuhelper.web.*;

public class shuhelpapp extends Application{
	public static CJWebAPI CJ;
	public static XKWebAPI XK;
	public static LoginFrameWindow Login;//��¼����
	public static MainFrameWindow MainFrame ;//������
	//��֤�봰��
	public static CJ_IdentFrameWindow CJ_IdentFrame;
	public static XK_IdentFrameWindow XK_IdentFrame;
	//�˺�������󴰿�
	public static PromtFrameWindow PromtFrame;
	//������ʾ��
	public static WindowFrame ErrorFrame;
	public static Schedule test;//��ѯ�γ���
	
	//����Ƿ��Ѿ���¼
	public static Boolean CJ_Islogin = false;
	public static Boolean XK_Islogin = false;
	
	
	 public static void main(String[] args) throws Exception 
	 {
		    CJ = new CJWebAPI();
		    XK = new XKWebAPI();
		    test = new Schedule();
	        Application.launch(shuhelpapp.class, args);
	 }
	
	@Override
	public void start(Stage stage) throws Exception
	{
		//��¼����
		Login = new LoginFrameWindow();
		//������
		MainFrame = new MainFrameWindow();
//		��֤�� 
		CJ_IdentFrame = new CJ_IdentFrameWindow();
		CJ_IdentFrame.stage.setTitle("CJ_IdentFrame");
		XK_IdentFrame = new XK_IdentFrameWindow();
		XK_IdentFrame.stage.setTitle("XK_IdentFrame");
		
		PromtFrame = new PromtFrameWindow();

		Login.stage.show();
	}
}
