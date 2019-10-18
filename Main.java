package sample;



import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application
{
    final int STEP_SIZE = 100;
    final Duration DURATION = Duration.millis(500);
    Group player;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        VBox root = new VBox();

        Button btn1 = new Button("SNAKE-GAME");
        Button btn2 = new Button("WELCOME");
        Button btn3 = new Button("RULES");

        root.setId("root");
        root.setId("btn1");
        root.setId("btn2");
        root.setId("btn3");
        Button button = new Button("START");
        root.setPadding(new Insets(30, 50, 50, 50));

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(btn1, btn2, btn3,button);
         // the button

        Scene scene = new Scene(root,500,500); // create the scene and set the root, width and height
        scene.getStylesheets().add(getClass().getClassLoader().getResource("sample/buttons.css").toExternalForm());
        primaryStage.setScene(scene); // set the scene
        primaryStage.setTitle("Splash Screen");
        primaryStage.show();



        button.setOnAction(e->{
            final ImageView image0 = new ImageView(new Image("https://opengameart.org/sites/default/files/snake%20idle.gif"));
            final ImageView image1 = new ImageView(new Image("https://opengameartfiles/styles/thumbnail/public/jabolko.jpg"));

            player = new Group(image0,image1);

            final Scene scene2 = new Scene(player,700,700,Color.WHITE);


            moveOnKeyPressed(scene2, player);
            Stage secondStage = new Stage();
            secondStage.setScene(scene2); // set the scene
            secondStage.setTitle("screen2");
            secondStage.show();
            primaryStage.close();});
    }

    private void moveOnKeyPressed(Scene scene, Group player)
    {

        final TranslateTransition transition = new TranslateTransition(DURATION, player);
        scene.setOnKeyPressed(e -> {
            switch(e.getCode())
            {

                case UP:
                {

                    transition.setFromX(player.getTranslateX());
                    transition.setFromY(player.getTranslateY());
                    transition.setToX(player.getTranslateX());
                    transition.setToY(player.getTranslateY() - STEP_SIZE);
                    transition.playFromStart();

                } break;
                case DOWN:
                {

                    transition.setFromX(player.getTranslateX());
                    transition.setFromY(player.getTranslateY());
                    transition.setToX(player.getTranslateX());
                    transition.setToY(player.getTranslateY() + STEP_SIZE);
                    transition.playFromStart();

                } break;
                case LEFT:
                {

                    transition.setFromX(player.getTranslateX());
                    transition.setFromY(player.getTranslateY());
                    transition.setToX(player.getTranslateX() - STEP_SIZE);
                    transition.setToY(player.getTranslateY());
                    transition.playFromStart();

                } break;
                case RIGHT:
                {

                    transition.setFromX(player.getTranslateX());
                    transition.setFromY(player.getTranslateY());
                    transition.setToX(player.getTranslateX() + STEP_SIZE);
                    transition.setToY(player.getTranslateY());
                    transition.playFromStart();

                } break;

                default:break;

            }
        });
    }
}
