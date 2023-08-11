public class Table {
    Player[] players;
    Dealer dealer;
    
    public Table() {
        this.players = new Player[1];
        this.dealer = new Dealer();
        populatePlayers();
    }

    public Table(int numPlayers) {
        this.players = new Player[numPlayers];
        this.dealer = new Dealer();
        populatePlayers();
    }

    private void populatePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }
}
