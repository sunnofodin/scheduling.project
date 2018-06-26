package andrewchristensonscheduling.view;

import andrewchristensonscheduling.AndrewChristensonScheduling;
import andrewchristensonscheduling.model.DBConnect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/* @author andrewchristenson
*/
public class LoginController implements Initializable {

    protected AndrewChristensonScheduling mainApp;
    static boolean okClicked = false;
    private Stage primaryStage = new Stage();
    private BorderPane rootLayout;
    private Node mainOverview;
    ResourceBundle rb; //class level variable that is referenced below by using "this.rb" notation if there is already a local variable declared (initialize param), tell the compiler the right one to use!

    
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
     @FXML
    private Button loginButton;
    @FXML
    private Button quitButton;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label welcome;
    

    @Override 
    public void initialize(URL url, ResourceBundle rb) {
  //      Locale.setDefault(new Locale("sv", "SV"));
        this.rb = ResourceBundle.getBundle("language_files/rb");
        System.out.println(Locale.getDefault());
         
        loginButton.setText(this.rb.getString("login"));
        quitButton.setText(this.rb.getString("quit"));
        password.setText(this.rb.getString("password"));
        username.setText(this.rb.getString("username"));
        welcome.setText(this.rb.getString("welcome"));
        
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        System.exit(0);
    }
    
    private boolean isInputValid() {
        return true;
    }

    public static boolean isOkClicked() {
        return okClicked;
    }

    public void setMainApp(AndrewChristensonScheduling aThis) {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleSceneChange() {
        Parent main = null;
        try {
            main = FXMLLoader.load(getClass().getClassLoader().getResource("andrewchristensonscheduling/view/main.fxml"));
            Scene scene = new Scene(main);
            Stage stage = AndrewChristensonScheduling.getStage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleSave(ActionEvent event) {
        String userN = usernameTF.getText();
        String passW = passwordTF.getText();
        String DBpass = null;
        String loginLogging = "log.txt";
       // PrintWriter writer = null;
        
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("log.txt"),true /*append=true*/)); ) {

            if (isInputValid()) {

                PreparedStatement statement = DBConnect.getConnection().prepareStatement("SELECT * FROM user WHERE userName = ?");
                statement.setString(1, userN);
                ResultSet rs = statement.executeQuery(); //if you are changing the DB, use execute(). retrieving infor from DB, use executeQuery()
                
                
                while (rs.next()) {
                    DBpass = rs.getString("password");
                }
                if (passW.equals(DBpass)) {
                    handleSceneChange();
                    writer.append(userN + " logged in at "+ LocalDateTime.now() + "\n");
                    System.out.println("LOL it worked");
                    
                } else {
                    writer.append(userN + " failed to log in at "+ LocalDateTime.now() + "\n");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(rb.getString("error"));
                    alert.setHeaderText(rb.getString("error"));
                    alert.setContentText(rb.getString("errorMessage"));
                    alert.showAndWait();
                }
                okClicked = true;
            }
        } catch (SQLException|FileNotFoundException e) {
            e.printStackTrace();
            //if (you can tell its english) do this stuff:
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(rb.getString("error"));
            alert.setHeaderText(rb.getString("error"));
            alert.setContentText(rb.getString("errorMessage"));
            alert.showAndWait();
            //else{show it in swedish}
            
        }
        
        
        
        
        
    }

//    public void handleMainApp(AndrewChristensonScheduling aThis) {
//       mainApp.showMainView();
//    }
//   public void initRootLayout() {
//        try {
//            //Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(AndrewChristensonScheduling.class.getResource("view/RootLayout.fxml"));
//            rootLayout = (BorderPane) loader.load();
//
//            // Show the scene containing the root layout.
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
