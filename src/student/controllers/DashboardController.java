package student.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import student.values.Values;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by acer on 28-Apr-19.
 */
public class DashboardController extends mainController implements Initializable {
    @FXML
    private Label textNumberOfStudents;
    @FXML
    private Label textNumberOfTeachers;
    @FXML
    private Label textNumberOfClasses;

    public DashboardController() throws IOException {
    }

    //private BorderPane middle = new mainController().main_border_pane;

    //Values values = new Values();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textNumberOfStudents.setText(String.valueOf(Values.totstudents));
        textNumberOfTeachers.setText(String.valueOf(Values.totteachers));
        textNumberOfClasses.setText(String.valueOf(Values.totClasses));
    }

    @FXML
    public void showMainTeachers() {

//        BorderPane parent = null;
//        try {
//            parent = FXMLLoader.load(getClass().getResource("/student/layouts/teachers.fxml"));
//            System.out.println("get fxml "+parent);
//        } catch (IOException e) {
//            System.out.println("error while loading teachers");
//        }
//
//        BorderPane myPane = null;
//
        try{
            mainController.getInstance().showTeachers();
            //mainController.getInstance().main_border_pane.setCenter(parent.getCenter());
        }catch (Exception e){
            System.out.println("err massage : "+e.getMessage()+
                    "\nCause " + e.getCause() + "\nFull e -> "+e
            );
        }

//        try{
//            myPane.setCenter(parent.getCenter());
//
//        }catch (Exception ee){
//            System.out.println("ee "+ ee.getMessage());
//        }

    }



}

