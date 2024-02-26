package prog2.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    VBox root = new VBox(10);
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    DeckOfCards deck = new DeckOfCards();
    HandOfCards hand = new HandOfCards(deck.dealHand());
    HBox handContainer = new HBox(5);
    handContainer.setMinHeight(100);
    for (PlayingCard card : hand.getHand()) {
      Label cardLabel = new Label(card.getAsString());
      cardLabel.setMinSize(50, 100);
      handContainer.getChildren().add(cardLabel);
    }

    ScrollPane scrollPane = new ScrollPane(handContainer);
    scrollPane.setContent(handContainer);
    scrollPane.setFitToHeight(true);
    scrollPane.setPrefSize(780, 120);
    root.getChildren().add(scrollPane);

    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");
    dealHandButton.setOnAction(e -> {
      HandOfCards newHand = new HandOfCards(deck.dealHand());
      handContainer.getChildren().clear();
      for (PlayingCard card : hand.getHand()) {
        Label cardLabel = new Label(card.getAsString());
        cardLabel.setMinSize(50, 100);
        handContainer.getChildren().add(cardLabel);
      }
    });

    checkHandButton.setOnAction(e -> {
    });

    HBox buttonContainer = new HBox(10);
    buttonContainer.getChildren().addAll(dealHandButton, checkHandButton);
    root.getChildren().add(buttonContainer);

  stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}