package prog2.cardgame;

import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGame extends Application {
  private TextField sumField;
  private TextField heartsField;
  private TextField queenOfSpadesField;
  private TextField flushField;
  private HandOfCards hand;

  @Override
  public void start(Stage stage) throws Exception {
    VBox root = new VBox(10);
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    DeckOfCards deck = new DeckOfCards();
    hand = new HandOfCards(deck.dealHand());
    HBox handContainer = new HBox(5);
    handContainer.setMinHeight(100);
    updateHandDisplay(hand, handContainer);

    ScrollPane scrollPane = new ScrollPane(handContainer);
    scrollPane.setFitToHeight(true);
    scrollPane.setPrefSize(780, 120);
    root.getChildren().add(scrollPane);

    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");
    dealHandButton.setOnAction(e -> {
      hand = new HandOfCards(deck.dealHand());
      updateHandDisplay(hand, handContainer);
    });

    checkHandButton.setOnAction(e -> {
      sumField.setText(String.valueOf(hand.getSum()));
      String hearts = hand.getHearts().stream()
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(", "));
      heartsField.setText(hearts.isEmpty() ? "No Hearts" : hearts);
      queenOfSpadesField.setText(hand.containsQueenOfSpades() ? "Yes" : "No");
      flushField.setText(hand.hasFlush() ? "Yes" : "No");
    });

    HBox buttonContainer = new HBox(10);
    buttonContainer.getChildren().addAll(dealHandButton, checkHandButton);
    root.getChildren().add(buttonContainer);

    root.getChildren().add(createInfoContainer());

    stage.show();
  }

  private VBox createInfoContainer() {
    VBox infoContainer = new VBox(5);
    sumField = new TextField();
    heartsField = new TextField();
    queenOfSpadesField = new TextField();
    flushField = new TextField();
    TextField[] fields = {sumField, heartsField, queenOfSpadesField, flushField};
    String[] titles = {"Sum", "Hearts", "Queen of Spades", "Flush"};

    for (int i = 0; i < titles.length; i++) {
      HBox row = new HBox(5);
      Label label = new Label(titles[i] + ":");
      fields[i].setEditable(false);
      row.getChildren().addAll(label, fields[i]);
      infoContainer.getChildren().add(row);
    }
    return infoContainer;
  }

  private void updateHandDisplay(HandOfCards hand, HBox handContainer) {
    handContainer.getChildren().clear();
    for (PlayingCard card : hand.getHand()) {
      Label cardLabel = new Label(card.getAsString());
      cardLabel.setMinSize(50, 100);
      handContainer.getChildren().add(cardLabel);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}