import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Game extends Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        stage.setTitle("BallWorld");

        BorderPane rootNode = new BorderPane();

        BallWorld ballWorld = new BallWorld();
        ballWorld.setPrefSize(500, 500);
        rootNode.setCenter(ballWorld);

        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);

        Paddle paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(ballWorld.getPrefHeight() - paddle.getHeight() + 5);

        ballWorld.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getX() <= ballWorld.getWidth() - paddle.getWidth()) paddle.setX(event.getX());
                paddle.setDx(event.getX() - paddle.getX());
                paddle.setPos(event.getX());
            }
        });


        ballWorld.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.addKey((event.getCode()));
                double speed = paddle.getWidth() / 3;
                if (paddle.getX() >= speed / 2 && event.getCode() == KeyCode.LEFT) paddle.move(-speed, 0);
                if (paddle.getX() <= ballWorld.getWidth() - paddle.getWidth() - speed / 2 && event.getCode() == KeyCode.RIGHT)
                    paddle.move(speed, 0);
            }
        });

        ballWorld.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.removeKey((event.getCode()));
                paddle.setDx(0);
            }
        });

        ballWorld.add(ball);
        ballWorld.add(paddle);
        ballWorld.start();

//        if (ballWorld.getBricks().size() == 1){
//            System.out.println("Hi");
//        }

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();

        ballWorld.requestFocus();

    }

}
