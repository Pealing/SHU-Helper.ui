package shuhelper.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Style;

import org.apache.http.client.ClientProtocolException;

import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;   
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent; 
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import shuhelper.web.*;

public class MainFrame extends Controller{
	//验证码窗口
	static CJ_IdentFrameWindow CJ_IdentFrame;
	static XK_IdentFrameWindow XK_IdentFrame;
	
	@FXML
	private TabPane ChosePane;
	
	@FXML
	private GridPane XK_Pane,XK_ClassTable;
	//Tab
	@FXML
	private Tab CJ_IdentTab, XK_IdentTab;
	
	@FXML
	private Button CJ_Button,XK_Button;
	//待选课程、搜索课程、已选课程窗口
	@FXML
	private GridPane Wait_Pane,Search_Pane,Had_Pane;
	@FXML
	private ScrollPane Search_Scroll;
	
	//登录状态
	private boolean CJ_status = false;
	private boolean XK_status = false;
	
	//是否已经选择过学期
	private boolean term = false;
	//是否已经加载过排名表
	private boolean isrank = false;
	//第一次登录
	private boolean FirstLogin = true;
	
	// 已选课程
	public static ArrayList<String[]> courseTable;
			
	// 选课排名
	public static ArrayList<String[]> enrollRank;
	
	//查询课程
	private ArrayList<String[]> queryCourse;
	
	//数据集合：已选课程
	ObservableList<HadClass> Haddata = FXCollections.observableArrayList();
	//课程表格：已选课程
	@FXML
	private TableView<HadClass> RankTable;
	@FXML
	private TableColumn<HadClass,String> ClassNum,ClassName,TeacherNum,TeacherName,PeopleNum,Rank;
	@FXML
	private TableColumn<HadClass,Boolean>ExitClass;
	
	
	
	
	public MainFrame() throws IOException
	{
		CJ_IdentFrame = new CJ_IdentFrameWindow();
		CJ_IdentFrame.stage.setTitle("CJ_IdentFrame");
		XK_IdentFrame = new XK_IdentFrameWindow();
		XK_IdentFrame.stage.setTitle("XK_IdentFrame");
	}
	public void CJ_Offline() throws Exception
	{
		try {
			CJ_status = shuhelpapp.CJ.isLogin();
		} catch (Exception e) {
			// Do nothing
		}
		if(CJ_status == false)
		{
			XK_IdentFrame.stage.close();
			CJ_IdentFrame.stage.show();
//			CJ_IdentFrame.Show();
//			CJ_IdentFrame.stage.setAlwaysOnTop(true);
			CJ_IdentFrame.stage.setResizable(false);
		}
	}
	
	public void XK_Offline() throws Exception
	{
		if(!term )
		{
			WindowFrame chose = new WindowFrame("ChoseFrame",188,40,true);
			try {
				chose.Start();
			} catch (Exception e) {
				// Do nothing
			}
			chose.scene.setFill(null);
			term = true;
		}
		else
		{
			try {
				XK_status = shuhelpapp.XK.isLogin();
			} catch (Exception e) {
				//Do nothing
			}
			if(XK_status == false)
			{
				CJ_IdentFrame.stage.close();
				XK_IdentFrame.stage.show();
				XK_IdentFrame.stage.setResizable(false);
			}
		}
	}
	@FXML
	public void Tabaction() throws Exception
	{

	}
	@FXML
	public void XK_Tabaction() throws Exception
	{
		if(XK_IdentTab.isSelected())
		{
			XK_Offline();
		}
		else if(CJ_IdentTab.isSelected())
		{
			CJ_Offline();
		}
		
	}
	@FXML
	public void CJ_Tabaction() throws Exception
	{
		if(XK_IdentTab.isSelected())
		{
			XK_Offline();
		}
		else if(CJ_IdentTab.isSelected())
		{
			CJ_Offline();
		}
	}
	@FXML
	public void Wait_Buttonaction(ActionEvent e)
	{
		System.out.println("1111");
		Wait_Pane.setDisable(false);
		Wait_Pane.setVisible(true);
		Search_Pane.setDisable(true);
		Search_Pane.setVisible(false);
		Had_Pane.setDisable(true);
		Had_Pane.setVisible(false);
	}
	@FXML
	public void Search_Buttonaction(ActionEvent e)
	{
		Wait_Pane.setDisable(true);
		Wait_Pane.setVisible(false);
		System.out.print(Wait_Pane.isVisible());
		Search_Pane.setDisable(false);
		Search_Pane.setVisible(true);
		Had_Pane.setDisable(true);
		Had_Pane.setVisible(false);
	}
	@FXML
	public void Had_Buttonaction(ActionEvent e)
	{
		Wait_Pane.setDisable(true);
		Wait_Pane.setVisible(false);
		Search_Pane.setDisable(true);
		Search_Pane.setVisible(false);
		Had_Pane.setDisable(false);
		Had_Pane.setVisible(true);
		if(!isrank )
		{
			SetTable();
			isrank = true;
		}
	}
	@FXML
	public void ExitButtonaction(ActionEvent e) throws Exception
	{
		System.out.println("选课状态: " + shuhelpapp.XK.getEnrollStatus());
		for (HadClass h : Haddata)
		{
			if(h.getExitClass().isSelected())
			{
				String x = shuhelpapp.XK.returnCourse(h.getClassNum(), h.getTeacherNum());
				System.out.println(x);
			}
		}
	}
	public void SetTable()
	{
		
		ClassNum.setCellValueFactory(new PropertyValueFactory<>("ClassNum"));
		ClassName.setCellValueFactory(new PropertyValueFactory<>("ClassName"));
		TeacherNum.setCellValueFactory(new PropertyValueFactory<>("TeacherNum"));
		TeacherName.setCellValueFactory(new PropertyValueFactory<>("TeacherName"));
		PeopleNum.setCellValueFactory(new PropertyValueFactory<HadClass,String>("PeopleNum"));
		Rank.setCellValueFactory(new PropertyValueFactory<HadClass,String>("Rank"));
		ExitClass.setCellValueFactory(new PropertyValueFactory<HadClass,Boolean>("ExitClass"));
				
		for (String[] row : enrollRank) 
		{
			Haddata .add(new HadClass(row[0],row[1],row[2],row[3],row[5],row[6]));
		}
		RankTable.setItems(Haddata);	
	}
}
