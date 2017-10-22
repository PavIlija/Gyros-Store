
package model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Employee {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name= new SimpleStringProperty();
    private final StringProperty surname= new SimpleStringProperty();
    private final StringProperty typeJob= new SimpleStringProperty();
    private final DoubleProperty salary = new SimpleDoubleProperty();
    
//    @ElementCollection 
//    @JoinTable(name = "Employee",joinColumns = @JoinColumn(name="id"))
//    private List<Shifts> list ;
//
//    public void setList(List<Shifts> list) {
//        this.list = list;
//    }
//
//    public List<Shifts> getList() {
//        return list;
//    }
    
    
    public final void setId(Integer value) {
        id.set(value);
    }
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final  Integer getId(){
        return id.get();
        
    }
    
    public final IntegerProperty idProperty() {
        return id;
    }
    public final  void setName(String value) {
        name.set(value);
    }

    public final  String getName() {
        return name.get();
    }

    public final StringProperty nameProperty() {
        return name;
    }

    public final  void setSurname(String value) {
        surname.set(value);
    }

    public final  String getSurname() {
        return surname.get();
    }

    public final StringProperty surnameProperty() {
        return surname;
    }

    public final  void setTypeJob(String value) {
        typeJob.set(value);
    }

    public final  String getTypeJob() {
        return typeJob.get();
    }

    public final StringProperty typeJobProperty() {
        return typeJob;
    }

    public final void setSalary(Double value) {
        salary.set(value);
    }

    public final  Double getSalary() {
        return salary.get();
    }

    public final DoubleProperty salaryProperty() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + '}';
    }
    public Employee(){
        
    }
    
}
