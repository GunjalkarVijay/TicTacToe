package tic_tac_toe;

public class Board {
	private char[][] board;
	private int boardSize=3;
	
	private char p1Symbol, p2Symbol;
	private int count;
	
	public final static int PLAYER_1_WIN = 1;
	public final static int PLAYER_2_WIN = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;
	
	
	public Board(char p1Symbol, char p2Symbol) {
		board = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				board[i][j]=' ';
			}
		}
		this.p1Symbol=p1Symbol;
		this.p2Symbol=p2Symbol;
	}


	public int move(char symbol, int x, int y) {

		if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ') {
			return INVALID;
		}
		
		board[x][y]=symbol;
		count++;
		
		///ROW WISE CHECKING
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2]) {
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		///COLUMN WISE CHECKING
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y]) {
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		///1ST DIAGONAL CHECKING
		if(board[1][1] != ' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2]) {
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		///2ND DIAGONAL CHECKING
		if(board[1][1] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		if(count == boardSize*boardSize) {
			return DRAW;
		}
		
		return INCOMPLETE;
		
	}


	public void print() {
		
		System.out.println("------------");
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("------------");
	}
}
