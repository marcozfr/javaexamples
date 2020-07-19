package com.example.twitterapp.app;

import com.example.twitterapp.core.TwitterFlowableOnSubscribe;
import com.example.twitterapp.core.TwitterStreamSubscriber;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import twitter4j.Status;

import java.io.IOException;
import java.net.URL;

public class TwitterFX extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    Flowable<Status> twitterFlow;
    TwitterFlowableOnSubscribe flowable = new TwitterFlowableOnSubscribe();
    TwitterStreamSubscriber subscriber;

    public TwitterFX(){
        twitterFlow = Flowable.create(flowable,BackpressureStrategy.BUFFER);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TwitterFX");
        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            URL url = TwitterFX.class.getClassLoader().getResource("twitterfx.fxml");
            loader.setLocation(url);
            rootLayout = (AnchorPane) loader.load();
            buildLayout();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout, 600,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildLayout() {
        ListView<String> listView = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);
        listView.setPrefHeight(245.0);
        listView.setPrefWidth(569.0);
        listView.setLayoutX(14.0);
        listView.setLayoutY(93.0);

        rootLayout.getChildren().add(listView);

        TextField txt = (TextField)rootLayout.getChildren().get(0);
        Button btn = (Button)rootLayout.getChildren().get(1);
        btn.setOnAction(e -> {
            String text = txt.getText();

            if(subscriber!=null) {
                listView.setItems(FXCollections.observableArrayList());
                subscriber.cancelSubscription();
            }

            flowable.setTwitterQuery(text);

            subscriber = new TwitterStreamSubscriber(s -> {
                listView.getItems().add(s.getText());
            });

            twitterFlow.subscribe(subscriber);

        });
    }
}
