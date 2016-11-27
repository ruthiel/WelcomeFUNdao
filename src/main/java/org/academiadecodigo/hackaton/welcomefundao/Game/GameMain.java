package org.academiadecodigo.hackaton.welcomefundao.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.academiadecodigo.hackaton.welcomefundao.Navigation;

/**
 * Created by codecadet on 25/11/16.
 */
public class GameMain  extends Application{
    private static final int NUM_OF_PAIRS = 8;
    private static final int NUM_PER_ROW = 4;

    private Image[] imgArray = new Image[8];

    private Tile selected = null;
    private int clickCount = 2;
    private int end=0;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(350, 350);



        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            imgArray[i] = new Image("images"+i+".jpg");

            tiles.add(new Tile(imgArray[i]));
            tiles.add(new Tile(imgArray[i]));
        }

        Collections.shuffle(tiles);

        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(87.5 * (i % NUM_PER_ROW));
            tile.setTranslateY(87.5 * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private class Tile extends StackPane {
        ImageView format = new ImageView();
        


        public Tile(Image initialImageView) {

            format.setFitHeight(87.5);
            format.setFitWidth(87.5);
            format.setImage(initialImageView);
            format.setOpacity(0);
            getChildren().add(format);

            setOnMouseClicked(this::handleMouseClick);
            close();
        }

        public void handleMouseClick(MouseEvent event) {
            if (isOpen() || clickCount == 0)
                return;

            clickCount--;

            if (selected == null) {
                selected = this;
                open(() -> {});
            }
            else {
                open(() -> {
                    if (!hasSameValue(selected)) {
                        selected.close();
                        this.close();
                    }

                    selected = null;
                    clickCount = 2;
                });
            }
        }

        public boolean isOpen() {
            return format.getOpacity() == 1;
        }

        public void open(Runnable action) {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), format);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), format);
            ft.setToValue(0);
            ft.play();
        }

            public boolean hasSameValue(Tile other) {
                boolean toReturn =format.getImage().equals(other.format.getImage());
                if(toReturn){
                    end++;
                    if(end==8){
                        Navigation.getInstance().back();
                    }
                }
            return toReturn;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
