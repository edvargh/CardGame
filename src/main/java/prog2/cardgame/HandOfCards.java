package prog2.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class HandOfCards {
  private List<PlayingCard> hand = new ArrayList<>();
  public HandOfCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  public int getSum() {
    int sum = 0;
    for (PlayingCard card : hand) {
      sum += card.getFace();
    }
    return sum;
  }

  public List<PlayingCard> getHearts() {
    List<PlayingCard> hearts = new ArrayList<>();
    for (PlayingCard card : hand) {
      if (card.getSuit() == 'H') {
        hearts.add(card);
      }
    }
    return hearts;
  }

  public boolean containsQueenOfSpades() {
    boolean containsQueenOfSpades = false;
    for (PlayingCard card : hand) {
      if (card.getSuit() == 'S' && card.getFace() == 12) {
        containsQueenOfSpades = true;
      }
    }
    return containsQueenOfSpades;
  }

  public boolean hasFlush() {
    Map<Character, Long> suitCounts = hand.stream().collect(Collectors.groupingBy(PlayingCard::getSuit,
        Collectors.counting()));
    return suitCounts.values().stream().anyMatch(count -> count >= 5);
  }
}
