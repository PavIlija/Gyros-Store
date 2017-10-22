
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.LoginMain;

public class LoginController {
   
    @FXML
    private TextField nameAdmin;
    @FXML
    private PasswordField passwordAdmin;
    
    
    @FXML
    public void login(ActionEvent event) throws IOException{
       if(nameAdmin.getText().equals("")&& passwordAdmin.getText().equals("")){
         GridPane pane=FXMLLoader.load(LoginMain.class.getResource("view/welcome.fxml"));
         Scene welcomeScene = new Scene(pane);
         String css= LoginMain.class.getResource("view/styleLogin.css").toExternalForm();
         welcomeScene.getStylesheets().add(css);
         Stage welcome=(Stage)((Node)event.getSource()).getScene().getWindow();
         welcome.setScene(welcomeScene);
         welcome.show();
       }else{
           System.out.println("wrong password");   
       }
    }

   
    
}
