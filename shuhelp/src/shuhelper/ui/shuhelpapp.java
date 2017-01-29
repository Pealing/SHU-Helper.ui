package shuhelper.ui;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
import shuhelper.web.*;

public class shuhelpapp extends Application{
	public static CJWebAPI CJ;
	public static XKWebAPI XK;
	public static WindowFrame Login;
	
	 public static void main(String[] args) throws Exception 
	 {
		    CJ = new CJWebAPI();
		    XK = new XKWebAPI();
	        Application.launch(shuhelpapp.class, args);
	 }
	
	@Override
	public void start(Stage stage) throws Exception
	{
		Login = new WindowFrame("LoginFrame",600,400);
		Login.Start();
		Login.SetTitle("SHU-Helper_Login");
		Login.Show();
	}

}
