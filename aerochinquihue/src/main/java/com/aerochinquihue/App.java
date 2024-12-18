package com.aerochinquihue;

import com.aerochinquihue.db.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;

import javafx.stage.Stage;

public class App extends Application {
    private static Object currentController;
    @SuppressWarnings("exports")
    public Stage Rstage;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        this.Rstage = stage;
        stage.setUserData(this);
        loadStartView();
    }
    private void loadStartView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/mainView.fxml"));
        Parent root = loader.load();
        Image icon = new Image(getClass().getResourceAsStream("img/icon2.png"));
        //  ----------------------------
        Rstage.getIcons().add(icon);
        Scene scene = new Scene(root, 600, 400);
        Rstage.setTitle("Sistema de sesiones - aerodromo");
        Rstage.setScene(scene);
        Rstage.show();
    }
    public Object getController() {
        return currentController;
    }
    public void switchScene(String root, int width, int height, Object data) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(root));
        Parent newRoot = loader.load();
        Scene newScene = new Scene(newRoot, width, height);
        currentController = loader.getController();
        Rstage.setScene(newScene);
    }

    public static void main(String[] args) {
        DBInitializer.createTable();
        launch();
    }

}