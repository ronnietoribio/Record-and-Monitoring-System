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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author admin
 */
public class studentDashboardController implements Initializable {

    @FXML
    private Label student_username;
    @FXML
    private AnchorPane main_form;

    @FXML
    private Button logout;

    @FXML
    private Button student_close;

    @FXML
    private AnchorPane student_mainForm;

    @FXML
    private Label student_id;

    @FXML
    private Button studentInformation_btn;
    @FXML
    private TableView<DataStudentHandle> table_view;
    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_teacherID;
    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_studentID;

    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_name;

    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_gender;

    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_dateInsert;

    @FXML
    private Circle circle_image;

    @FXML
    private Label teacher_id;

    @FXML
    private Label teacher_name;

    @FXML
    private Label teacher_gender;

    @FXML
    private Label teacher_date;

    //////////////////////////
    @FXML
    private Button studentSubject_btn;
    @FXML
    private Button yourTeachers_btn;

    @FXML
    private AnchorPane studentSubject_form;

    @FXML
    private TableView<SubjectData> studentSubject_tableView;

    @FXML
    private TableColumn<SubjectData, String> studentSubject_col_subjectCode;

    @FXML
    private TableColumn<SubjectData, String> studentSubject_col_subject;

    @FXML
    private TableColumn<SubjectData, String> studentSubject_col_teacher;

    @FXML
    private TextField studentSubject_search;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private TableView<SubjectData> studentGrade_tableView;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_subjectCode;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_subject;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_teacher;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_firstSem;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_secondSem;

    @FXML
    private TableColumn<SubjectData, String> studentGrade_col_final;

    @FXML
    private TextField studentGrade_search;

    @FXML
    private TableColumn<DataStudentHandle, String> studentInfo_col_YE;

    @FXML
    private AnchorPane student_yourTeachers_form;

    public studentDashboardController() {
    }

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    AlertMessage alert = new AlertMessage();

    public void Minimize() {
        Stage stage = (Stage) student_mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void maximizeWindow(MouseEvent event) {
        Stage stage = (Stage) student_mainForm.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }

    public void Close() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("You are about to exit the application!");
        alert.setContentText("Are you sure you want to exit?");

        // Show the confirmation dialog and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);// Close the application if the user confirms
        }
    }

    private double x = 0;
    private double y = 0;

    public void logoutBtn() {

        try {
            if (alert.confirmMessage("Are you sure you want to logout?")) {
                Parent root = FXMLLoader.load(getClass().getResource("LoginFormLayout.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                logout.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//// grades student

    public ObservableList<SubjectData> studentGradeSetData() {
        ObservableList<SubjectData> listData = FXCollections.observableArrayList();

        String sql = "SELECT teacher_handle.teacher_id,\n"
                + "       teacher_handle.subject_code,\n"
                + "       teacher_handle.subject, student_grade.first_sem, student_grade.second_sem, student_grade.finals \n"
                + "FROM teacher_handle\n"
                + "LEFT JOIN student_grade ON teacher_handle.teacher_id = student_grade.course";

        connect = Database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            SubjectData sg;

            while (result.next()) {
                // (String subjectCode, String subject, String teacherID )
                sg = new SubjectData(
                        result.getString("teacher_id"),
                        result.getString("subject_code"),
                        result.getString("subject"),
                        result.getDouble("first_sem"),
                        result.getDouble("second_sem"),
                        result.getDouble("finals")
                );
                listData.add(sg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<SubjectData> studentGradetListData;

    public void studentGradeDisplayData() {
        studentGradetListData = studentGradeSetData();

        studentGrade_col_subjectCode.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        studentGrade_col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
        studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
        studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("finals"));

        studentGrade_tableView.setItems(studentGradetListData);
    }

    public ObservableList<SubjectData> studentSubjectSetData() {
        ObservableList<SubjectData> listData = FXCollections.observableArrayList();

        String sql = "SELECT teacher_handle.subject_code,\n"
                + "       teacher_handle.subject,\n"
                + "       teacher_student.teacher_id\n"
                + "FROM teacher_handle\n"
                + "LEFT JOIN teacher_student ON teacher_handle.teacher_id = teacher_student.teacher_id";

        connect = Database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            SubjectData sd;

            while (result.next()) {
                // (String subjectCode, String subject, String teacherID )
                sd = new SubjectData(
                        result.getString("subject_code"),
                        result.getString("subject"),
                        result.getString("teacher_id")
                );
                listData.add(sd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    private ObservableList<SubjectData> studentSubjectListData;

    public void studentSubjectDisplayData() {
        studentSubjectListData = studentSubjectSetData();

        studentSubject_col_subjectCode.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        studentSubject_col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        studentSubject_tableView.setItems(studentSubjectListData);
    }

    public ObservableList<DataStudentHandle> teacherSetData() {
        ObservableList<DataStudentHandle> listData = FXCollections.observableArrayList();

        String sql = "SELECT teacher.full_name,teacher.gender,teacher.date_insert, teacher_student.teacher_id\n"
                + "FROM teacher\n"
                + "LEFT JOIN teacher_student ON teacher.teacher_id = teacher_student.teacher_id";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            DataStudentHandle dsh;

            while (result.next()) {
                // DataStudentHandle(String teacherID, String studentID, String name, String gender, Date dateInsert)
                dsh = new DataStudentHandle(
                        result.getString("teacher_id"),
                        result.getString("full_name"),
                        result.getString("gender"),
                        result.getDate("date_insert")
                );
                listData.add(dsh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<DataStudentHandle> teacherListData;

    public void teacherDisplayData() {
        teacherListData = teacherSetData();

        studentInfo_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        studentInfo_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentInfo_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        studentInfo_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

        table_view.setItems(teacherListData);
    }

    private Image image;

    public void teacherSelectData() {
        DataStudentHandle dsh = table_view.getSelectionModel().getSelectedItem();
        int num = table_view.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String sql = "SELECT * FROM teacher WHERE teacher_id = '"
                + dsh.getTeacherID() + "'";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {

                String path = "File:" + result.getString("image");

                image = new Image(path, 164, 73, false, true);
                circle_image.setFill(new ImagePattern(image));

                teacher_id.setText(result.getString("teacher_id"));
                teacher_name.setText(result.getString("full_name"));
                teacher_gender.setText(result.getString("gender"));
                teacher_date.setText(result.getString("date_insert"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == yourTeachers_btn) {
            student_yourTeachers_form.setVisible(true);
            studentSubject_form.setVisible(false);
            studentGrade_form.setVisible(false);

            teacherDisplayData();
            studentIDDisplay();

        } else if (event.getSource() == studentSubject_btn) {
            student_yourTeachers_form.setVisible(false);
            studentSubject_form.setVisible(true);
            studentGrade_form.setVisible(false);

            studentSubjectDisplayData();

        } else if (event.getSource() == studentGrade_btn) {
            student_yourTeachers_form.setVisible(false);
            studentSubject_form.setVisible(false);
            studentGrade_form.setVisible(true);

            studentGradeDisplayData();

        }
    }

    public void displayStudent() {

        String sql = "SELECT * FROM users WHERE username = '"
                + ListData.student_username + "'";

        connect = Database.connectDB();

        String temp_studentNumber = "";
        String temp_studentName = "";

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                temp_studentNumber = result.getString("student_id");
            }

            String selectData = "SELECT * FROM student WHERE student_id = '"
                    + temp_studentNumber + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(selectData);

            if (result.next()) {
                temp_studentName = result.getString("full_name");
            }

            student_username.setText("Welcome, " + temp_studentName);
            teacher_id.setText(temp_studentNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void studentIDDisplay() {

        String sql = "SELECT * FROM users WHERE Username = '"
                + ListData.student_username + "'";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                student_id.setText(result.getString("student_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherDisplayData();
       studentIDDisplay();
    }

}
