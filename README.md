![title](./media/screenshot_title.png)
# battleship-console-terminal
Java battleship game using console terminal with classical rules but with an improved CLI graphics system


### Installation
To run the game you need to have:
* Versions after Java 8

### The Game
When you start the game the following menu appears on the home screen

![menu](./media/screenshot_initmenu.png)

>Type a number in the menu to continue

### Options available
  * Type '1' to start playing classical game 10x10 vs the computer
  * Type '2' to simulate a computer vs computer game 10x10
  * Type '3' to see the rules and legend
  * Type '0' to exit

### How to win
  - Each player has a battlefield represented by a 10x10 grid (default) on which he places 8 ships, hidden from his opponent.
  - The goal of the game is to sink all the opposing ships! A ship is sunk when it is hit once for each space it occupies.
  - In other words, a submarine, which occupies two spaces, is sunk after being hit twice.
  - The 8 ships occupy 25 total spaces, so the first player to record 25 hits wins!

### Place your ships

To place a ship you need to enter a departure coordinate (A1-J10 for the default 10x10 board) and a direction (vertical or horizontal).
- For example: "A1" and 'H' or "B7" and 'V'. 

Ships shall not overlap or be adjacent and shall remain within the boundaries of the edge.

![addShips](./media/screenshot_playerboard.png)


### Shoot the enemy ships
Once both players have configured their ships, the battle may have started!
- Shoot your opponent’s ships by matching the coordinates.
- You will be informed if you have hit or missed a ship.
- Sink all 8 computer ships to win!

![playerShoot](./media/screenshot_shootplayer.png)

![playerBoards](./media/screenshot_boards.png)

### End game
This is a possible scenario of an end game. 
The rules and legend of the symbols are explained in detail in point 3 of the menu. Consult anytime if you have any doubts.

![endGame](./media/screenshot_endgame.png)

![playerWin](./media/screenshot_win.png)

### Feedback
If you have any feedback, please reach out to us at gurzau10@gmail.com

### License
[MIT](https://choosealicense.com/licenses/mit/)
