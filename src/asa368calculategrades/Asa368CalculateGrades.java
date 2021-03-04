/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asa368calculategrades;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author Adrian Atanasov
 */
public class Asa368CalculateGrades extends Application {

    public String title = "Calculate Grades";
    public int width = 500;
    public int height = 360;
    public String fontStyle = "Comic Sans MS";
    public double score_1, score_2, score_3, score_4, result;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 0, 15, 0));
        vbox.setSpacing(10);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        Label label1 = new Label("Score1 (70%):");
        root.add(label1, 0, 0);

        Label label2 = new Label("Score2 (30%):");
        root.add(label2, 0, 1);

        Label label3 = new Label("Bonus:");
        root.add(label3, 0, 2);

        Label label4 = new Label("Final Score");
        root.add(label4, 0, 3);


        TextField score1 = new TextField();
        root.add(score1, 1, 0, 2, 1);

        TextField score2 = new TextField();
        root.add(score2, 1, 1, 2, 1);

        TextField score3 = new TextField();
        root.add(score3, 1, 2, 2, 1);

        TextField finalscore = new TextField();
        finalscore.setEditable(false);
        root.add(finalscore, 1, 3, 2, 1);

        Button fs = new Button();
        fs.setText("Full Score");
        fs.setTextAlignment(TextAlignment.CENTER);
        fs.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().add(fs);

        Button calc = new Button();
        calc.setText("Calculate");
        calc.setTextAlignment(TextAlignment.CENTER);
        calc.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().add(calc);

        Button clear = new Button();
        clear.setText("Clear");
        clear.setTextAlignment(TextAlignment.CENTER);
        clear.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().add(clear);

        Button alert = new Button();
        alert.setText("Alert");
        alert.setTextAlignment(TextAlignment.CENTER);
        alert.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().add(alert);


        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                score1.clear();
                score2.clear();
                score3.clear();
                finalscore.clear();
            }
        });
        calc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                score_1 = Integer.valueOf(score1.getText());
                score_2 = Integer.valueOf(score2.getText());
                score_3 = Integer.valueOf(score3.getText());
                result = score_1 * .7 + score_2 * .3 + score_3;
                finalscore.setText("My final score should be " +
                        Double.toString(score_1) + "*.7" + "+" + Double.toString(score_2) + "*.3"
                        + "+" + Double.toString(score_2) + "=" + Double.toString(result));
            }
        });

        fs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                score1.setText("100");
                score2.setText("100");
                score3.setText("10");
            }
        });

        alert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alrt = new Alert(AlertType.INFORMATION);
                alrt.setTitle("Alert");
                alrt.setHeaderText("Message");
                alrt.setContentText(finalscore.getText());
                alrt.showAndWait();
            }
        });


        root.add(vbox, 0, 4);
        root.setColumnSpan(vbox, 4);


        Scene scene = new Scene(root, width, height);

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                if (scene.widthProperty().getValue() > width) {
                    score1.setFont(Font.font(100));
                    score2.setFont(Font.font(100));
                    score3.setFont(Font.font(10));
                } else {
                    score1.setFont(Font.font(10));
                    score2.setFont(Font.font(10));
                    score3.setFont(Font.font(10));
                }
            }

        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


