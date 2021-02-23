
package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 *
 * @author smsj
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtRowVersion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleLoadData(ActionEvent actionEvent) {

        try (Connection conn = new DBConnector().getConnection())
        {
            //Create helper SQL vars
            String sql = "SELECT * FROM Users WHERE id = ?";

            PreparedStatement stmt = null;

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2); //id
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                txtFirstName.setText(resultSet.getString("firstname"));
                txtLastName.setText(resultSet.getString("lastname"));
                txtAge.setText(Integer.toString(resultSet.getInt("age")));
                txtRowVersion.setText(Integer.toString(resultSet.getInt("row_version")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleUpdateData(ActionEvent actionEvent) {

        try (Connection conn = new DBConnector().getConnection())
        {
            //Create helper SQL vars
            String sql = "UPDATE Users SET firstname=?, lastname=?, age=?, row_version=? WHERE row_version=? AND id = ?";

            PreparedStatement stmt = null;
            int row_version = Integer.parseInt(txtRowVersion.getText());

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, txtFirstName.getText()); //first name
            stmt.setString(2, txtLastName.getText()); //last name
            stmt.setInt(3, Integer.parseInt(txtAge.getText())); //age
            stmt.setInt(4, row_version + 1); //updated row_version
            stmt.setInt(5, row_version); //current row_version
            stmt.setInt(6, 2); //row_version

            int updated_rows = stmt.executeUpdate();

            if (updated_rows == 0) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText("Update your view");
                alert.setContentText("Please refresh the view as somebody has updated the data.");

                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Update success");
                alert.setContentText("Successfully updated the record.");

                alert.showAndWait();
                System.out.println("");
                txtRowVersion.setText(Integer.toString(++row_version));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}