module prog2.cardgame {
  requires javafx.controls;
  requires javafx.fxml;


  opens prog2.cardgame to javafx.fxml;
  exports prog2.cardgame;
}