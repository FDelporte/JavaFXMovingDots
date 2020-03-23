package be.webtechie.movingdots;

import be.webtechie.movingdots.ui.DotsView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovingDotsApp extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private DotsView view;

    @Override
    public void init() {
        view = new DotsView(WIDTH, HEIGHT);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(view, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Moving dots framerate checker");
        stage.show();
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}