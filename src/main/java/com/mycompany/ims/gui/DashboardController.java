package com.mycompany.ims.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import launcher.InHouse;
import launcher.Inventory;
import launcher.Part;

public class DashboardController {

    /** Controls **/
    @FXML
    private TableView<Part> tblParts;

    private Inventory inventory;

    public DashboardController(){
        this.inventory = Inventory.getInstance();

        // Setup tables
        this.tblParts = new TableView<Part>();
        tblParts.setEditable(true);

        inventory.addPart(new InHouse(1, "1", 1, 1, 1, 1, 1));

        TableColumn colPartID = new TableColumn("Part ID");
        colPartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));

        TableColumn colPartName = new TableColumn("Part Name");
        colPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));

        TableColumn colInvLevel = new TableColumn("Stock");
        colInvLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        TableColumn colPPU = new TableColumn("Price Per Unit");
        colPPU.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));

        tblParts.setItems(inventory.getAllParts());
    }

    public void exit(){
        System.exit(0);
    }

}
