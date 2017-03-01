package shuhelper.ui;

import java.io.IOException;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

public class XK_IdentFrame extends Controller{

	//��֤��
	private String XK_identify;
	//��֤���ַ
	private String XK_validatePath;
	//��ť
	@FXML
	private Button  XK_Button;
	//��������
	@FXML
	private TextField XK_Text;
	//��֤��ͼƬ
	@FXML
	private ImageView XK_Image;
	//��ʾ��Ϣ
	@FXML
	private Label XK_Prompt;
	

	private void Change()
	{
		XKvalidate task = new XKvalidate();
		waitframe wait = new waitframe(stage);
		wait.activateProgressBar();
        
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
            	XK_validatePath = task.GetPath();
            	Image xkimage = new Image("File:"+XK_validatePath);
        		XK_Image.setImage(xkimage);
        		wait.cancelProgressBar();
            }
        });
	}
	//������֤��	
	@FXML
	public void XK_ChangeImage(MouseEvent e) throws IOException
	{
		Change();
	}
	
	@FXML
	public void XK_ButtonAction(ActionEvent e) throws Exception
	{
		XK_identify = XK_Text.getText();
		XKlogintask task = new XKlogintask(LoginFrame.username,LoginFrame.password,XK_identify);
		waitframe wait = new waitframe(stage);
		wait.activateProgressBar();
        
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		
		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
            	//��¼XK�߳�
            	String res = task.GetPath();
            	System.out.println(res);
        		if(res.equals("OK"))
        		{
        			String labelText = "��¼�ɹ���";
        			//��¼�ɹ�����XK��¼״̬
        			shuhelpapp.XK_Islogin = true;
        			XK_Prompt.setText(labelText);
        			stage.close();
        			//���µ�ǰ�α�״̬
        			try {
						shuhelpapp.test.initCourseStatus(shuhelpapp.test.selectedCourse(shuhelpapp.XK));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			//��ȡ��ѡ�γ̺�����
        			try {
						shuhelpapp.MainFrame.controller.enrollRank = shuhelpapp.XK.getEnrollRankArrayList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			//��ȡ��ѡ�γ���Ϣ
        			try {
						shuhelpapp.MainFrame.controller.courseTable = shuhelpapp.XK.getCourseTableArrayList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			//��ʼ���α�
        			wait.cancelProgressBar();
        		}
        		else if(res.equals("��֤�����"))
        		{
        			wait.cancelProgressBar();
        			String labelText = "��֤�벻��ȷ����������";
        			XK_Prompt.setText(labelText);
        			Change();
        		}
        		else
        		{
        			wait.cancelProgressBar();
        			String labelText = "�˺������������������";
        			//������֤��
        			Change();
        			stage.close();
        			shuhelpapp.MainFrame.stage.close();
        			XK_Prompt.setText(labelText);
        			try {
        				shuhelpapp.PromtFrame.controller.label.setText("�˺������������������");
						shuhelpapp.PromtFrame.stage.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
            }
        });
		 
	}	
	public void CloseFrame()
	{
		stage.close();
	}
}
