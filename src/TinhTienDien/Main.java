/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TinhTienDien;

import Controller.TinhTienDienController;
import Model.Phuong;
import View.TinhTienDienView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dunnokiet
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Phuong model = new Phuong(1, "Vinh Hai");
        model.khoiTao();
        TinhTienDienView view = new TinhTienDienView();
        new TinhTienDienController(model, view);
       
        Scene scene = new Scene(view.getRoot(), 800, 600);
        primaryStage.setTitle("Tinh Tien Dien");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
