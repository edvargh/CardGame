package prog2.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
    AtomicInteger sum = new AtomicInteger();
    hand.forEach(card -> sum.addAndGet(card.getFace()));
    return sum.get();
  }

  public List<PlayingCard> getHearts() {
    List<PlayingCard> hearts = new ArrayList<>();
    hand.stream().filter(card -> card.getSuit() == 'H').forEach(hearts::add);
    return hearts;
  }

  public boolean containsQueenOfSpades() {
    return hand.stream().anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  public boolean hasFlush() {
    return hand.stream()
            .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
            .values()
            .stream()
            .anyMatch(count -> count >= 5);
  }
}
