package prog2.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandOfCards {
  private List<PlayingCard> hand = new ArrayList<>();
  public HandOfCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  public boolean hasFlush() {
    char suit = hand.get(0).getSuit();
    for (PlayingCard card : hand) {
      if (card.getSuit() != suit) {
        return false;
      }
    }
    return true;
  }
}
