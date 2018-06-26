package andrewchristensonscheduling.view;

import andrewchristensonscheduling.AndrewChristensonScheduling;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author andrewchristenson
 */
public class MainController implements Initializable {
    
    protected AndrewChristensonScheduling mainApp;
    private boolean okClicked = false;
    private Stage primaryStage = new Stage();
    ResourceBundle rb; //class level variable that is referenced below by using "this.rb" notation if there is already a local variable declared (initialize param), tell the compiler the right one to use!
    
    
    private Node mainOverview;
     @FXML
    private TextField firstNameTF;
    @FXML
    private TextField streetExtraTF;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField postalTF;
    @FXML
    private TextField stateTF;
    @FXML
    private TextField streetTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField countryTF;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private boolean isInputValid() {
        return true;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    public void setMainApp(AndrewChristensonScheduling aThis) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleSave(ActionEvent event) {
        String firstN = firstNameTF.getText();
        String lastN = lastNameTF.getText();
        String streetN = streetTF.getText();
        String streetExtraN = streetExtraTF.getText();
        String cityN = cityTF.getText();
        String stateN = stateTF.getText();
        String postalCode = postalTF.getText();
        String countryN = countryTF.getText();
        String phoneNumber = phoneTF.getText();
        String DBpass = null;

//        try {
//
//            if (isInputValid()) {
//
//                PreparedStatement statement = DBConnect.getConnection().prepareStatement("SELECT * FROM user WHERE userName = ?");
//                statement.setString(1,userN);
//                ResultSet rs = statement.execute(); //if you are changing the DB, use execute(). retrieving infor from DB, use executeQuery()
//
//                while (rs.next()) {
//                    DBpass = rs.getString("password");
//                }
//                if (passW.equals(DBpass)) {
//                    handleSceneChange();
//                    System.out.println("LOL it worked");
//
//                } else {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle(rb.getString("error"));
//                    alert.setHeaderText(rb.getString("error"));
//                    alert.setContentText(rb.getString("errorMessage"));
//                    alert.showAndWait();
//                }
//                okClicked = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            //if (you can tell its english) do this stuff:
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle(rb.getString("error"));
//            alert.setHeaderText(rb.getString("error"));
//            alert.setContentText(rb.getString("errorMessage"));
//            alert.showAndWait();
//            //else{show it in swedish}
//            
//        }
        
//    }    
//        
//    @FXML
//    public void handleSceneChange() {
//        Parent main = null;
//        try {
//            main = FXMLLoader.load(getClass().getClassLoader().getResource("andrewchristensonscheduling/view/main.fxml"));
//            Scene scene = new Scene(main);
//            Stage stage = AndrewChristensonScheduling.getStage();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//          }
//    }
//        
//        
//        
        
        
    }
public class Country {
    StringProperty id;
    StringProperty country;

    public Country(StringProperty id, StringProperty country) {
        this.id = id;
        this.country = country;
    }

    public StringProperty getId() {
        return id;
    }

    public void setId(StringProperty id) {
        this.id = id;
    }

    public StringProperty getCountry() {
        return country;
    }

    public void setCountry(StringProperty country) {
        this.country = country;
    }

    
}
}

