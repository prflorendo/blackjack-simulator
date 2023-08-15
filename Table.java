/**
 * The Table class represents the blackjack table that the dealer and players 
 * sit at.
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Table {
    Player[] players;
    Dealer dealer;
    
    /**
     * Constructs a new Table with 1 player
     */
    public Table() {
        this.players = new Player[1];
        this.dealer = new Dealer();
        populatePlayers();
    }

    /**
     * Constructs a new table with the given number of players
     * @param numPlayers the desired number of players
     */
    public Table(int numPlayers) {
        this.players = new Player[numPlayers];
        this.dealer = new Dealer();
        populatePlayers();
    }

    /**
     * Fills the seats with players
     */
    private void populatePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    /**
     * Returns the array of players at the table
     * @return the array players at the table
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Returns the table's dealer
     * @return the table's dealer
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * Sets the table's dealer to the given dealer
     * @param dealer the desired dealer
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
