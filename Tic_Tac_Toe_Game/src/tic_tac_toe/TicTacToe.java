package tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1, player2;
	private Board board;
	
	public void StartGame() {
		Scanner s= new Scanner(System.in);
		
		//take player
		
		player1= takePlayerInput(1);
		player2= takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol already taken !! pick another symbol !");
			char ch = s.next().charAt(0);
			player2.setSymbol(ch);
		}
		
		//create board
		
		board= new Board(player1.getSymbol(), player2.getSymbol());
		
		//conduct game
		
		boolean player1turn = true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALID) {
			if(player1turn) {
				System.out.println("Player 1 - "+player1.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player1.getSymbol(), x, y);
				
				if(status!=Board.INVALID) {
					player1turn=false;
					board.print();
				}else {
					System.out.println("Invalid Move ! Try Again !!");		
				}
				
			}else {
				System.out.println("Player 2 - "+player2.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player2.getSymbol(), x, y);
				
				if(status!=Board.INVALID) {
					player1turn=true;
					board.print();
				}else {
					System.out.println("Invalid Move ! Try Again !!");
				}
			}
		}
		if(status==Board.PLAYER_1_WIN) {
			System.out.println("Player 1 - "+player1.getName()+" Wins !! ");
		}
		if(status==Board.PLAYER_2_WIN) {
			System.out.println("Player 2 - "+player2.getName()+" Wins !! ");
		}
		if(status==Board.DRAW) {
			System.out.println("It's Draw !! ");
		}
	}
	
	private Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player "+num+" name: ");
		String name = s.nextLine();
		System.out.println("Enter Plyer "+num+" symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}
}
