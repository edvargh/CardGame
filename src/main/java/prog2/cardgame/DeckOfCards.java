package prog2.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of playing cards. A deck has 52 cards, 13 of each suit.
 * The deck can be shuffled, and cards can be dealt from the deck.
 */

public class DeckOfCards {
  private List<PlayingCard> cards = new ArrayList<>();
  private final char[] suits = {'S', 'H', 'D', 'C'};

  /**
   * Creates a new deck of cards, with 52 cards in the order of
   * Spades, Hearts, Diamonds and Clubs, and for each suit, the cards
   * are ordered from 1 to 13.
   */
  public DeckOfCards() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        cards.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Shuffles the deck of cards and deals n cards from the deck.
   */
  public List<PlayingCard> dealHand() {
    Random random = new Random();
    int n = random.nextInt(52);
    Collections.shuffle(cards);
    return cards.subList(0, n);
  }
}