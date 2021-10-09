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
import ik.ijse.pos.bo.custom.ItemBO;
import ik.ijse.pos.dto.CustomerDTO;
import ik.ijse.pos.dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class AddItemFormController {

    static ItemBO itemBO = (ItemBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.ITEM);

    public JFXTextField txtCode;
    public JFXTextField txtName;
    public JFXTextField txtPrice;
    public JFXButton btnSave;
    public JFXButton btnCustomer;
    public AnchorPane pane;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String name = txtName.getText();
        String price = txtPrice.getText();
        try {
            if (code.length() > 0 && name.length() > 0 && price.length() > 0) {
                ItemDTO itemDTO = new ItemDTO(code, name, price);

                boolean isAddedStudent = itemBO.addItem(itemDTO);
                if (isAddedStudent) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Registerd Sussefull", ButtonType.OK).show();
                    txtCode.setText(null);
                    txtName.setText(null);
                    txtPrice.setText(null);
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

    public void btnCustomer(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) this.pane.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../views/customer.fxml"))));
        window.show();
    }
}
