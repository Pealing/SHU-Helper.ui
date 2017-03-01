package shuhelper.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView; 

public class PromtFrame extends Controller{
	@FXML
	private ImageView Sure;
	@FXML
	public Label label;
	
	public PromtFrame()
	{
		name = "Promt";
	}
	@FXML
	private void ButtonAction()
	{
		stage.close();
		//Î´µÇÂ¼ÔòÏÔÊ¾µÇÂ¼´°¿Ú
		if(!shuhelpapp.XK_Islogin)
		{
			shuhelpapp.Login.stage.show();	
		}
	}

}
