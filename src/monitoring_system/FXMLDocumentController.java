/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoring_system;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {

    //login Form
    @FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    //regite

    @FXML
    private Button close1;

    @FXML
    private TextField firstName;

    @FXML
    private TextField last_Name;

    @FXML
    private PasswordField password1;

    @FXML
    private Button registerBtn;

    @FXML
    private Button register_Btn1;

    @FXML
    private TextField username1;

    @FXML
    private AnchorPane register_form;

    @FXML
    private AnchorPane login_form;

    @FXML
    private ComboBox<String> login_role;

    @FXML
    private AnchorPane Faculty_form;

    @FXML
    private AnchorPane Student_form;

    @FXML
    private AnchorPane Teacher_form;

    @FXML
    private Button close11;

    @FXML
    private Button close111;

    @FXML
    private PasswordField faculty_confirm_password;

    @FXML
    private TextField faculty_email;

    @FXML
    private Hyperlink faculty_hyperlink_login;

    @FXML
    private PasswordField faculty_password;

    @FXML
    private Button faculty_register;

    @FXML
    private TextField faculty_username;

    @FXML
    private TextField studen_email;

    @FXML
    private PasswordField student_confirm_password;

    @FXML
    private Hyperlink student_hyperlink_login;

    @FXML
    private PasswordField student_password;

    @FXML
    private Button student_register_btn;

    @FXML
    private TextField student_username;

    @FXML
    private PasswordField teacher_confirm_password;

    @FXML
    private TextField teacher_email;

    @FXML
    private Hyperlink teacher_hyperlink_login;

    @FXML
    private PasswordField teacher_password;

    @FXML
    private Button teacher_register;

    @FXML
    private TextField teacher_username;

    @FXML
    private TextField student_email;
    
    
    @FXML
    private TextField teacherRegister_fullname;
    
    @FXML
    private TextField studentRegister_fullname;

//database tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

//register 
    private AlertMessage alert = new AlertMessage();
//loginAccount
    private double x = 0;
    private double y = 0;

    public void loginAccount() {
        
        if (username.getText().isEmpty()
                || password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            String selectData = "SELECT * FROM users WHERE Username = ? AND Password = ?";

            connect = Database.connectDB();

            String role = "";
            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, username.getText());
                prepare.setString(2, password.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    role = result.getString("role");

                    System.out.println(role);

                    Thread.sleep(1000);

                    if (role.equals("Admin")) {
                        ListData.admin_username = username.getText();
                        // LINK YOUR MAIN FORM FOR ADMIN
                        Parent root = FXMLLoader.load(getClass().getResource("Admindashboard.fxml"));

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setMaximized(true);
                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);
                        });

                        stage.initStyle(StageStyle.TRANSPARENT);

                        stage.show();

                        // TO HIDE YOUR LOGIN FORM
                        loginBtn.getScene().getWindow().hide();

                    } else if (role.equals("Student")) {
                        String tempStudentID = result.getString("student_id");

                        String checkData = "SELECT * FROM student WHERE student_id = '"
                                + tempStudentID + "'";

                        statement = connect.createStatement();
                        result = statement.executeQuery(checkData);

                        if (result.next()) {
                            if (result.getString("status").equals("Approval")) {
                                alert.errorMessage("Need the approval of the Admin!");
                            } else {
                                // TO GET THE USERNAME
                                ListData.student_username = username.getText();

                                Parent root = FXMLLoader.load(getClass().getResource("StudentMainForm.fxml"));
                                Stage stage = new Stage();

                                stage.setTitle("University Management System | Student Portal");
                                stage.setScene(new Scene(root));
                                
                                stage.setMaximized(true);
                                
                                root.setOnMousePressed((MouseEvent event) -> {
                                    x = event.getSceneX();
                                    y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) -> {
                                    stage.setX(event.getScreenX() - x);
                                    stage.setY(event.getScreenY() - y);
                                });

                                stage.initStyle(StageStyle.TRANSPARENT);

                                stage.show();

                                // TO HIDE YOUR LOGIN FORM
                                loginBtn.getScene().getWindow().hide();
                            }
                        }
                    } else if (role.equals("Teacher")) {

                        String tempTeacherID = result.getString("teacher_id");

                        String checkData = "SELECT * FROM teacher WHERE teacher_id = '"
                                + tempTeacherID + "'";

                        statement = connect.createStatement();
                        result = statement.executeQuery(checkData);

                        if (result.next()) {
                            if (result.getString("status").equals("Approval")) {
                                alert.errorMessage("Need the approval of the Admin!");
                            } else {
                                // TO GET THE USERNAME
                                ListData.teacher_username = username.getText();

                                Parent root = FXMLLoader.load(getClass().getResource("TeacherMainForm.fxml"));
                                Stage stage = new Stage();

                                stage.setTitle("University Management System | Teacher Portal");
                                stage.setScene(new Scene(root));
                                stage.setMaximized(true);

                                root.setOnMousePressed((MouseEvent event) -> {
                                    x = event.getSceneX();
                                    y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) -> {
                                    stage.setX(event.getScreenX() - x);
                                    stage.setY(event.getScreenY() - y);
                                });

                                stage.initStyle(StageStyle.TRANSPARENT);

                                stage.show();

                                // TO HIDE YOUR LOGIN FORM
                                loginBtn.getScene().getWindow().hide();
                            }
                        }

                    }
                } else {
                    alert.errorMessage("Incorrect Username/Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

//register as Teacher
    public void registerTeacher() {
        teacherIDGenerator();
        System.out.println(teacherID);

        if (teacher_username.getText().isEmpty() || teacher_password.getText().isEmpty()
                || teacher_confirm_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields!");
        } else {
            connect = Database.connectDB();

            String selectData = "SELECT * FROM users WHERE Username='"
                    + teacher_username.getText() + "'";
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);

                if (result.next()) {
                    alert.errorMessage(teacher_username.getText() + "is already exist");
                } else {
                    if (!teacher_password.getText().equals(teacher_password.getText())) {
                        alert.errorMessage("Password does not match!");
                    } else if (teacher_password.getText().length() < 8) {
                        alert.errorMessage("Invalid Password, at least 8 characters needed");
                    } else {

                        String temp_teacherID = "TID-" + String.valueOf(teacherIDGenerator());

                        String insertData = "INSERT INTO users (full_name,Email, Username, Password, Role, teacher_id, Date)"
                                + "Values(?,?,?,?,?,?,?)";

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, teacherRegister_fullname.getText());
                        prepare.setString(2, teacher_email.getText());
                        prepare.setString(3, teacher_username.getText());
                        prepare.setString(4, teacher_password.getText());
                        prepare.setString(5, "Teacher");
                        prepare.setString(6, temp_teacherID);
                        prepare.setString(7, String.valueOf(sqlDate));
                        prepare.executeUpdate();

                        String insertTeacher = "INSERT INTO teacher(teacher_id, full_name, date_insert, status)"
                                + "VALUES(?,?,?,?)";

                        prepare = connect.prepareStatement(insertTeacher);
                        prepare.setString(1, temp_teacherID);
                        prepare.setString(2, teacherRegister_fullname.getText());
                        prepare.setString(3, String.valueOf(sqlDate));
                        prepare.setString(4, "Approval");

                        prepare.executeUpdate();

                        alert.successMessage("Registered Successfully!");

                        login_form.setVisible(true);
                        Teacher_form.setVisible(false);
                    }

                }
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    private int teacherID = 0;

    public int teacherIDGenerator() {
        String selectData = "SELECT MAX(id) FROM teacher";

        connect = Database.connectDB();

        int temp_teacherID = 0;

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(selectData);

            if (result.next()) {
                temp_teacherID = result.getInt("MAX(id)");
            }
            if (temp_teacherID == 0) {
                teacherID = 1;
            } else {
                teacherID = temp_teacherID + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherID;
    }
//register as Student

    public void registerStudent() {
        studentIDGenerator();
        System.out.println(studentID);
        if (student_username.getText().isEmpty() || student_password.getText().isEmpty()
                || student_confirm_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields!");
        } else {
            connect = Database.connectDB();

            String selectData = "SELECT * FROM users WHERE Username='"
                    + student_username.getText() + "'";
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);

                if (result.next()) {
                    alert.errorMessage(student_username.getText() + "is already exist");
                } else {
                    if (!student_password.getText().equals(student_password.getText())) {
                        alert.errorMessage("Password does not match!");
                    } else if (student_password.getText().length() < 8) {
                        alert.errorMessage("Invalid Password, at least 8 characters needed");
                    } else {
                        String insertData = "INSERT INTO users (full_name, Email, Username, Password, Role, student_id, Date)"
                                + "Values(?,?,?,?,?,?,?)";

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        SimpleDateFormat format = new SimpleDateFormat("yyyy");
                        String getYear = format.format(date);
                        String studentNum = getYear + "0000";
                        int sNum = Integer.parseInt(studentNum) + studentIDGenerator();

                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, student_email.getText());
                        prepare.setString(2, studentRegister_fullname.getText());
                        prepare.setString(3, student_username.getText());
                        prepare.setString(4, student_password.getText());
                        prepare.setString(5, "Student");
                        prepare.setString(6, String.valueOf(sNum));
                        prepare.setString(7, String.valueOf(sqlDate));

                        prepare.executeUpdate();

                        studentIDGenerator();
                        String insertStudent = "INSERT INTO student(student_id, full_name, date_insert, status)"
                                + "VALUES(?,?,?,?)";

                        prepare = connect.prepareStatement(insertStudent);
                        prepare.setString(1, String.valueOf(sNum));
                        prepare.setString(2,studentRegister_fullname.getText());
                        prepare.setString(3, String.valueOf(sqlDate));
                        prepare.setString(4, "Approval");

                        prepare.executeUpdate();

                        alert.successMessage("Registered Successfully!");

                        login_form.setVisible(true);
                        Student_form.setVisible(false);
                    }

                }

                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

//generate student ID
    private int studentID;

    public int studentIDGenerator() {
        String selectData = "SELECT MAX(id) FROM student";

        connect = Database.connectDB();

        int temp_studentID = 0;

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(selectData);

            if (result.next()) {
                temp_studentID = result.getInt("MAX(id)");
            }
            if (temp_studentID == 0) {
                studentID = 1;
            } else {
                studentID = temp_studentID + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentID;
    }

    //register as Faculty
   
//role list
    public void roleList() {

        List<String> listR = new ArrayList<>();

        for (String data : ListData.role) {
            listR.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listR);
        login_role.setItems(listData);

    }

//login form
    public void loginForm() {
        login_form.setVisible(true);
        Teacher_form.setVisible(false);
        Student_form.setVisible(false);
    }

//switch form
    public void switch_form(ActionEvent event) {
        switch (login_role.getSelectionModel().getSelectedItem()) {
            case "Teacher":
                Teacher_form.setVisible(true);
                Student_form.setVisible(false);
                login_form.setVisible(false);
                break;
            case "Student":
                Teacher_form.setVisible(false);
                Student_form.setVisible(true);
                login_form.setVisible(false);
                break;
            default:
                break;
        }

    }
// close Button
    public void close() {
         
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit?");

        // Show the confirmation dialog and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);// Close the application if the user confirms
        }
        
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roleList();
    }

}
