/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.AbstractHo;
import Model.HoGiaDinh;
import Model.HoKinhDoanh;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Dunnokiet
 */
public class TinhTienDienView {
    private BorderPane root;
    private TableView<AbstractHo> tableView;
    private ObservableList<AbstractHo> customerData;
    private TextField searchField;
    private Label searchResult;
    private Label avgBillLabel;
    private Label maxBillLabel;
    private Label minProdBillLabel;
    private Button searchButton;
    private Button avgBillButton;
    private Button maxBillButton;
    private Button minProdBillButton;

    public TinhTienDienView() {
        root = new BorderPane();
        root.setPadding(new Insets(10));
        setupUI();
    }

    private void setupUI() {
        tableView = new TableView<>();
        customerData = FXCollections.observableArrayList();

        TableColumn<AbstractHo, String> idColumn = new TableColumn<>("Ma");
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getMaKH())));

        TableColumn<AbstractHo, String> nameColumn = new TableColumn<>("Ten");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTenChuHo()));

        TableColumn<AbstractHo, String> typeColumn = new TableColumn<>("Ho");
        typeColumn.setCellValueFactory(cellData -> {
            AbstractHo customer = cellData.getValue();
            if (customer instanceof HoGiaDinh) return new SimpleStringProperty("Ho Gia Dinh");
            if (customer instanceof HoKinhDoanh) return new SimpleStringProperty("Ho Kinh Doanh");
            return new SimpleStringProperty("Ho San Xuat");
        });

        TableColumn<AbstractHo, String> billColumn = new TableColumn<>("Hoa Don (VND)");
        billColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                String.format("%.2f", cellData.getValue().tinhTienDien())));

        tableView.getColumns().addAll(idColumn, nameColumn, typeColumn, billColumn);
        tableView.setItems(customerData);

        HBox searchBox = new HBox(10);
        searchField = new TextField();
        searchField.setPromptText("Nhap Ma Ho");
        searchButton = new Button("Tim");
        searchResult = new Label();
        searchBox.getChildren().addAll(new Label("Tim Kiem Theo Ma:"), searchField, searchButton, searchResult);

        VBox statsBox = new VBox(10);
        avgBillButton = new Button("Tinh Hoa Don Trung Binh");
        avgBillLabel = new Label();
        maxBillButton = new Button("Tim hoa don cao nhat");
        maxBillLabel = new Label();
        minProdBillButton = new Button("Tim Ho San Xuat Hoa Don Nho Nhat");
        minProdBillLabel = new Label();

        statsBox.getChildren().addAll(
                avgBillButton, avgBillLabel,
                maxBillButton, maxBillLabel,
                minProdBillButton, minProdBillLabel
        );

        VBox controlBox = new VBox(10, searchBox, statsBox);
        root.setTop(controlBox);
        root.setCenter(tableView);
    }

    public BorderPane getRoot() { return root; }
    public void setCustomerData(List<AbstractHo> customers) {
        customerData.setAll(customers);
    }
    public TextField getSearchField() { return searchField; }
    public Label getSearchResult() { return searchResult; }
    public Label getAvgBillLabel() { return avgBillLabel; }
    public Label getMaxBillLabel() { return maxBillLabel; }
    public Label getMinProdBillLabel() { return minProdBillLabel; }
    public Button getSearchButton() { return searchButton; }
    public Button getAvgBillButton() { return avgBillButton; }
    public Button getMaxBillButton() { return maxBillButton; }
    public Button getMinProdBillButton() { return minProdBillButton; }
}
