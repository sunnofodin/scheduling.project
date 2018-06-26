package andrewchristensonscheduling.view;

import andrewchristensonscheduling.AndrewChristensonScheduling;
import andrewchristensonscheduling.model.DBConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author andrewchristenson
 */
public class newCXController implements Initializable {

    protected AndrewChristensonScheduling mainApp;
    static boolean okClicked = false;
    ResourceBundle rb; //class level variable that is referenced below by using "this.rb" notation if there is already a local variable declared (initialize param), tell the compiler the right one to use!
    //Customer cx;
    Connection conn;
    Country selected;

    @FXML
    private TableView<Country> table;
    @FXML
    private TableColumn<Country, String> colCountry;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField streetExtraTF;
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
    private ComboBox countryCB;
    @FXML
    private ComboBox cityCB;
    @FXML
    private Button cancelButton;
    @FXML
    private Button createButton;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accessDB();

        colCountry.setCellValueFactory(cellData -> {
            return cellData.getValue().getCountry();
        });
        table.getItems().addAll(countryList);
    }
    ObservableList<Country> countryList = FXCollections.observableArrayList();

    private boolean isInputValid() {
        return true;
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }

    @FXML
    private void handleSave(ActionEvent event) throws SQLException {
        String query = "INSERT INTO Customers"; // should all of these be linked together? String query = "INSERT INTO Users ("
        //    + " customer_id,"
        //    + " customername,"
        //    + " firstname,"
        //    + " lastname,"
        //    + " companyname,"
        //    + " email_addr,"
        //    + " want_privacy ) VALUES ("
        //    + "null, ?, ?, ?, ?, ?, ?)";
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

        try {   // set all the preparedstatement parameters

            PreparedStatement statement = DBConnect.getConnection().prepareStatement("INSERT INTO ___ VALUES ___");
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, firstN);
            st.setString(2, lastN);
            st.setString(3, streetN);
            st.setString(4, streetExtraN);
            st.setString(5, cityN);
            st.setString(6, stateN);
            st.setString(7, postalCode);
            st.setString(8, countryN);
            st.setString(9, phoneNumber);

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
        } catch (SQLException se) {
            // log exception
            throw se;
        }
    }
} // comboBox example in code repository shows the user chooses the country first and that trims down options for city names
// (last_insert_id)
//        try {
//
//            if (isInputValid()) {
//
//                PreparedStatement statement = DBConnect.getConnection().prepareStatement("SELECT * FROM user WHERE userName = ?");
//                statement.setString(1,);
//                ResultSet rs = statement.executeQuery(); //if you are changing the DB, use execute(). retrieving infor from DB, use executeQuery()
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
//}
//public void addCX(Customer cx, Connection conn) throws SQLException {
//  String query = "INSERT INTO Users ("
//    + " customer_id,"
//    + " customername,"
//    + " firstname,"
//    + " lastname,"
//    + " companyname,"
//    + " email_addr,"
//    + " want_privacy ) VALUES ("
//    + "null, ?, ?, ?, ?, ?, ?)";
//
//  try {
//    // set all the preparedstatement parameters
//    PreparedStatement st = conn.prepareStatement(query);
//    st.setString(1, cx.getName());
//    st.setString(2, cx.getFirstName());
//    st.setString(3, cx.getLastName());
//    st.setString(4, cx.getCompanyName());
//    st.setString(5, cx.getEmail());
//    st.setString(6, cx.getPrivacy());
//
//    // execute the preparedstatement insert
//    st.executeUpdate();
//    st.close();
//  } 
//  catch (SQLException se)
//  {
//    // log exception
//    throw se;
//  }
//}
;

        @FXML
        private void handleButtonAction(ActionEvent event) {
        String countryName = null;
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter New Country");
        dialog.setHeaderText("Please enter a new country name");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            countryName = result.get();
        }
        String countryId = insertDB(countryName);
        countryList.add(new Country(new SimpleStringProperty(countryId), new SimpleStringProperty(countryName)));
        table.getItems().clear();
        table.getItems().addAll(countryList);
    }


    

    public void accessDB() {
//        Server name:  52.206.157.109 
//Database name:  U03QIu
//Username:  U03QIu
//Password:  53688051379
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://52.206.157.109/U03QIu";

        //  Database credentials: please fill in your own database information! 
        final String DBUSER = "";
        final String DBPASS = "";

        boolean res = false;
        ResultSet rs = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);

            Statement stmt;

            try {
                countryList.clear();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT countryId, country FROM country");

                while (rs.next()) {
                    countryList.add(new Country(new SimpleStringProperty(rs.getString(1)), new SimpleStringProperty(rs.getString(2))));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    String insertDB(String newCountry) {

        //Note that this assumes an autoincrement on the country id column! 
        String sql = "INSERT INTO country (country, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES (?, now(), 'test', now(), 'test')";
        String countryId = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newCountry);

            ps.execute();
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM country"); //retrieve newly assigned country id
            ResultSet rs = ps.executeQuery();
            rs.next(); //only one record, so no need for a loop.  
            countryId = rs.getString(1);
        

} catch (SQLException ex) {
            Logger.getLogger(InsertController.class
.getName()).log(Level.SEVERE, null, ex);
        }

        return countryId;
    }
}
