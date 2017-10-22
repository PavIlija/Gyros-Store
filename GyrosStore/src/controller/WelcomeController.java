
package controller;

import java.io.IOException;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.LoginMain;
import model.Employee;
import model.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WelcomeController {

    
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn salaryCol;
   
   
    @FXML
    private TableColumn typeJobCol;
   
    
    public void initialize(){
        setColumns();
        fillTable();
    }
    @FXML
    private void logOut(ActionEvent event) throws IOException{
        GridPane pane=FXMLLoader.load(LoginMain.class.getResource("view/login.fxml"));
        String css= LoginMain.class.getResource("view/styleLogin.css").toExternalForm();
        
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        
        Stage welcome=(Stage)((Node)event.getSource()).getScene().getWindow();
        welcome.setScene(scene);
        welcome.show();
    }
    @FXML
    private void addWorker() throws IOException{
        GridPane vb= FXMLLoader.load(LoginMain.class.getResource("view/add_worker.fxml"));
        String css= LoginMain.class.getResource("view/styleWelcome.css").toExternalForm();
        
        Scene scene= new Scene(vb);
        scene.getStylesheets().add(css);
        
        Stage stage= new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Dodaj radnika");
        stage.setScene(scene);
        stage.show();
        
    }
    @FXML
     public void showShifts() throws IOException{
        GridPane gp=FXMLLoader.load(LoginMain.class.getResource("view/shifts.fxml"));
        String css= LoginMain.class.getResource("view/styleWelcome.css").toExternalForm();
        Stage shift = new Stage();
        Scene scene= new Scene(gp);
        scene.getStylesheets().add(css);
        shift.setScene(scene);
        shift.setTitle("Smene");
        shift.show();
    }
    
    @FXML
    public void fillTable(){
         Session session= HibernateUtil.getFactory().openSession();
       
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
        List<Employee> workers=session.createCriteria(Employee.class).list();
        ObservableList<Employee>tableData=FXCollections.observableArrayList();
        for(Employee work:workers){
                tableData.add(work);
            }
            tableView.setItems(tableData);
          
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            System.out.println(e);
        }finally{
            session.close();
            
        }
        
    }
    private void setColumns(){
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee,StringProperty>("name"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee,StringProperty>("surname"));
        idCol.setCellValueFactory(new PropertyValueFactory<Employee,IntegerProperty>("id"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<Employee,DoubleProperty>("salary"));
        typeJobCol.setCellValueFactory(new PropertyValueFactory<Employee,StringProperty>("typeJob"));
    }
    
}
