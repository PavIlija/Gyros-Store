
package controller;

import com.sun.webkit.graphics.WCFont;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Employee;
import model.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AddWorkerController {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSurname;
    @FXML private TextField txtSalary;
    @FXML
    private TextField txtTypeJob;
    @FXML
      public void addWorker(){
        Employee worker = new Employee();
        worker.setName(txtName.getText());
        worker.setSurname(txtSurname.getText());
        worker.setSalary(Double.parseDouble(txtSalary.getText()));
        worker.setTypeJob(txtTypeJob.getText());
        Session session= HibernateUtil.getFactory().openSession();
        Transaction tx=null;
        
        try {
            tx=session.beginTransaction();
          
            session.save(worker);
            
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
    @FXML
      public void clearWorker(){
          txtName.setText("");
          txtSurname.setText("");
          txtSalary.setText("");
          txtTypeJob.setText("");
      }
    
    
   
}
