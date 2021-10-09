/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ik.ijse.pos.bo.BOFactry;
import ik.ijse.pos.bo.custom.CustomerBO;
import ik.ijse.pos.dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class AddCustomerFormController implements Initializable {

    static CustomerBO customerBO = (CustomerBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.CUSTOMER);


    public JFXTextField txtNic;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public JFXButton btnItem;
    public AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void btnSaveOnAction(ActionEvent actionEvent) {
        String nic = txtNic.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        try {
            if (nic.length() > 0 && name.length() > 0 && email.length() > 0 && address.length() > 0) {
                CustomerDTO customerDTO = new CustomerDTO(nic, name, email, address);

                boolean isAddedStudent = customerBO.addCustomer(customerDTO);
                if (isAddedStudent) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Registerd Sussefull", ButtonType.OK).show();
                    txtNic.setText(null);
                    txtName.setText(null);
                    txtEmail.setText(null);
                    txtAddress.setText(null);
                } else {
                    new Alert(Alert.AlertType.WARNING, "Customer Registerd Fail", ButtonType.OK).show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Filed Can't Be Empty!",
                        ButtonType.OK).show();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.WARNING, "This Customer Already Registerd", ButtonType.OK).show();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.WARNING, "All Fields should be completed", ButtonType.OK).show();
        } catch (NullPointerException ex) {
            new Alert(Alert.AlertType.WARNING, "Customer Fields should be completed", ButtonType.OK).show();
        }
    }

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.pane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../views/item.fxml"))));
        window.show();
    }
}
