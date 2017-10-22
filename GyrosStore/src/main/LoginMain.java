
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
public class LoginMain extends Application{
   
   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root=FXMLLoader.load(getClass().getResource("view/login.fxml"));
         String css= LoginMain.class.getResource("view/styleLogin.css").toExternalForm();
         Scene scene = new Scene(root);
         scene.getStylesheets().add(css);
         
         primaryStage.setTitle("Gyros Store");
         primaryStage.setMinHeight(600);
         primaryStage.setMinWidth(600);
         primaryStage.setScene(scene);
         primaryStage.show();
    }
   

         
    
}
