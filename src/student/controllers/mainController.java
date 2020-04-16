package student.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import student.values.Values;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

    public  class mainController implements Initializable{
    @FXML
    public BorderPane main_border_pane;
    @FXML
    public TextField txusername,txSearch;
    @FXML
    public PasswordField txpassword;
    @FXML
    public ImageView logout;
    @FXML
    public Label lableHeading;
    @FXML
    private HBox paneTeachers;



    public static Parent teachers;

    private static mainController instance;

    public mainController(){
        instance = this;
    }

    public static mainController getInstance(){
        return instance;
    }

//    public mainController() throws IOException {
//        try {
//            teachers = FXMLLoader.load(getClass().getResource("/student/layouts/teachers.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //disable before login
        System.out.println("init main "+main_border_pane.getId());
        this.main_border_pane.getLeft().setDisable(true);
        //main_border_pane.getLeft().setDisable(true);
        txSearch.setDisable(true);

        //set values;
        lableHeading.setText(Values.instituteName);
        logout.setCursor(Cursor.HAND);

        try {
            Parent welcome = FXMLLoader.load(getClass().getResource("/student/layouts/welcome.fxml"));
            main_border_pane.setCenter(welcome);
        } catch (IOException e) {
            e.printStackTrace();
        }

        txpassword.setOnKeyReleased(event -> {
            //login and verification process;
            txpassword.setText("");
            switch (event.getCode()){
                case ENTER:
                    try {
                        loginProcess();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });

        logout.setSmooth(true);
        logout.setOnMouseClicked(event -> {
            //log out process
            try {
                logoutProcess();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        paneTeachers.setOnMouseClicked(event -> showTeachers());

    }

    @FXML
    public void showDashboard(){
        try {
            Parent dashboard = FXMLLoader.load(getClass().getResource("/student/layouts/dashboard.fxml"));
            this.main_border_pane.setCenter(dashboard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void showStudents(){
        try {
            Parent students = FXMLLoader.load(getClass().getResource("/student/layouts/students.fxml"));
            this.main_border_pane.setCenter(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTeachers(){

        try {
            teachers = FXMLLoader.load(getClass().getResource("/student/layouts/teachers.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Showing teachers " + teachers);

//        main_border_pane.getCenter().getBoundsInLocal().

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main_border_pane.setCenter(teachers);
    }


    private void loginProcess() throws IOException {
        try{
            Parent dashboard = FXMLLoader.load(getClass().getResource("/student/layouts/dashboard.fxml"));
            main_border_pane.setCenter(dashboard);
            main_border_pane.getLeft().setDisable(false);
            txSearch.setDisable(false);
        }catch (Exception e){
            System.out.println("massage : "+e.getMessage() +"\nCause : "+e.getCause());
        }
    }
    private void logoutProcess() throws IOException {
        try{
            Parent welcome = FXMLLoader.load(getClass().getResource("/student/layouts/welcome.fxml"));
            main_border_pane.setCenter(welcome);
            main_border_pane.getLeft().setDisable(true);
            txSearch.setDisable(true);
        }catch (Exception e){
            System.out.println("massage : "+e.getMessage() +"\nCause : "+e.getCause());
        }
    }

}
