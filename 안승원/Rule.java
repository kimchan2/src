package 안승원;

import java.util.Arrays;

public class Rule {
	
	static String[] mvblCrdnt(Player fiendly, Player enemy, Piece piece){
		String[] move = new String[0];

		switch(Piece.locationToName(piece)){
			case "Rook":
				move = rook(fiendly, enemy, piece, move);
				break;
				
			case "Night":
				move = knight(fiendly, enemy, piece, move);
				break;
				
			case "Bishop":
				move = bishop(fiendly, enemy, piece, move);
				break;
				
			case "King":
				move = king(fiendly, enemy, piece, move);
				break;
				
			case "Queen":
				move = queen(fiendly, enemy, piece, move);
				break;
				
			case "Pawn":
				move = pawn(fiendly, enemy, piece, move);
				break;
		
		}
		
		return move;
	}
	
	/**
	 * 룩이 이동할 수 있는 좌표를 저장한다.
	 * @param fiendly
	 * @param enemy
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] rook(Player fiendly, Player enemy, Piece piece, String[] move) {

		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		// 상 y축 1=>8
		if (y != 8) {
			outer: for (int i = y + 1; i <= 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(i, x))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(i, x));
					break outer;
				default:
					move = moveAdd(move, locationToString(i, x));
					break;
				}
			}
		}
		// 하 y축 8=>1
		if (y != 1) {
			outer: for (int i = y - 1; i >= 1; i--) {
				switch (moveCheck(fiendly, enemy, locationToString(i, x))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(i, x));
					break outer;
				default:
					move = moveAdd(move, locationToString(i, x));
					break;
				}
			}
		}
		// 좌 x축8=>1
		if (x != 1) {
			outer: for (int i = x - 1; i >= 1; i--) {
				switch (moveCheck(fiendly, enemy, locationToString(y, i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y, i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y, i));
					break;
				}
			}
		}
		// 우 x축 1=>8
		if (x != 8) {
			outer: for (int i = x + 1; i <= 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(y, i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y, i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y, i));
					break;
				}
			}
		}

		//캐승링
		if(piece.count == 0 && Piece.locationToName(piece).equals("Rook")){	//룩이며 한번도 움직이지않았다면
			Piece king = Player.locationToPiece(fiendly, locationKing(fiendly));	//아군 킹 객체
			if(Piece.locationToName(king).equals("King") && king.count == 0){		//킹객체가 킹이며, 한번도 움직이지 않았다면
				if(x== 1){
					String check = null;
					for (int i = x + 1; i < 4; i++) {
						check = moveCheck(fiendly, enemy, locationToString(y, i));
						if(!check.equals("null"))break;
					}
					if(check.equals("null"))move = moveAdd(move, locationToString(y, 4));
					//킹이 이동되므로 체크되는 곳인지 확인				
//					outer: for(int j = 0; j<enemy.piece.length; j++){
//						for(int l =0 ; l<enemy.piece[j].mvblCrdnt.length; l++){
//							if(locationToString(y, 2).equals(enemy.piece[j].mvblCrdnt[l])){
//								move = moveDel(move, locationToString(y, 4));
//								break outer;
//							}
//						}
//					}
				}else if(x== 8){
					String check = null;
					for (int i = x - 1; i > 4; i--) {
						check = moveCheck(fiendly, enemy, locationToString(y, i));
						if(!check.equals("null"))break;
					}
					if(check.equals("null"))move = moveAdd(move, locationToString(y, 4));
					//킹이 이동되므로 체크되는 곳인지 확인				
//					outer: for(int j = 0; j<enemy.piece.length; j++){
//						for(int l =0 ; l<enemy.piece[j].mvblCrdnt.length; l++){
//							if(locationToString(y, 6).equals(enemy.piece[j].mvblCrdnt[l])){
//								move = moveDel(move, locationToString(y, 4));
//								break outer;
//							}
//						}
//					}
				}
			}
		}

		return move;
	}
	
	/**
	 * 나이트가 이동할 수 있는 좌표를 저장한다.
	 * @param fiendly
	 * @param enemy
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] knight(Player fiendly, Player enemy, Piece piece, String[] move){
		
		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		
		//위 
		if(y+2 <= 8){
			outer: for(int i = -1; i<= 1; i++){
				if(i != 0){
					switch (moveCheck(fiendly, enemy, locationToString(y+2, x+i))) {
					case "fiendly":
						break;

					case "enemy":
						move = moveAdd(move, locationToString(y+2, x+i));
						break;
					default:
						move = moveAdd(move, locationToString(y+2, x+i));
						break;
					}
				}
			}
		}
		
		//아래
		if(y-2 >= 1){
			outer: for(int i = -1; i<= 1; i++){
				if(i != 0){
					switch (moveCheck(fiendly, enemy, locationToString(y-2, x+i))) {
					case "fiendly":
						break;

					case "enemy":
						move = moveAdd(move, locationToString(y-2, x+i));
						break;
					default:
						move = moveAdd(move, locationToString(y-2, x+i));
						break;
					}
				}
			}
		}
		
		//좌
		if(x-2 >= 1){
			outer: for(int i = -1; i<= 1; i++){
				if(i != 0){
					switch (moveCheck(fiendly, enemy, locationToString(y+i, x-2))) {
					case "fiendly":
						break;

					case "enemy":
						move = moveAdd(move, locationToString(y+i, x-2));
						break;
					default:
						move = moveAdd(move, locationToString(y+i, x-2));
						break;
					}
				}
			}
		}
		
		if(x+2 <= 8){
			for(int i = -1; i<= 1; i++){
				if(i != 0){
					switch (moveCheck(fiendly, enemy, locationToString(y+i, x+2))) {
					case "fiendly":
						break;

					case "enemy":
						move = moveAdd(move, locationToString(y+i, x+2));
						break;
					default:
						move = moveAdd(move, locationToString(y+i, x+2));
						break;
					}
				}
			}
		}
		move = boarderDel(move);
		return move;
	}
	
	/**
	 * 비숍이 이동할 수 있는 좌표를 저장한다.
	 * @param fiendly
	 * @param enemy
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] bishop(Player fiendly, Player enemy, Piece piece, String[] move){
		
		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		
		// 상좌
		if (x != 1 && y != 8) {
			outer: for (int i = 1; i < 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(y + i, x - i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y + i, x - i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y + i, x - i));
					break;
				}
				if (x - i == 1 || y + i == 8)
					break outer;
			}
		}
		
		//상우
		if(x != 8 && y != 8){
			outer: for (int i = 1; i < 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(y + i, x + i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y + i, x + i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y + i, x + i));
					break;
				}
				if (x + i == 8 || y + i == 8)
					break outer;
			}
		}
		
		//하좌
		if(x != 1 && y != 1){
			outer: for (int i = 1; i < 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(y - i, x - i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y - i, x - i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y - i, x - i));
					break;
				}
				if (x - i == 1 || y - i == 1)
					break outer;
			}
		}
		
		//하우
		if(x != 8 && y != 1){
			outer: for (int i = 1; i < 8; i++) {
				switch (moveCheck(fiendly, enemy, locationToString(y - i, x + i))) {
				case "fiendly":
					break outer;

				case "enemy":
					move = moveAdd(move, locationToString(y - i, x + i));
					break outer;
				default:
					move = moveAdd(move, locationToString(y - i, x + i));
					break;
				}
				if (x + i == 8 || y - i == 1)
					break outer;
			}
		}
		return move;
	}
	
	/**
	 * 킹이 이동할 수 있는 좌표를 저장한다.
	 * @param player
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] king(Player fiendly, Player enemy, Piece piece, String[] move){
		
		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i != 0 || j != 0) {
					switch (moveCheck(fiendly, enemy, locationToString(y + i, x + j))) {
					case "fiendly":
						break;

					case "enemy":
						move = moveAdd(move, locationToString(y + i, x + j));
						break;
					default:
						move = moveAdd(move, locationToString(y + i, x + j));
						break;
					}
				}
			}
		}
		move = boarderDel(move);
		
		//캐슬링 체크
		if(piece.count == 0){
			Piece rook = Player.locationToPiece(fiendly, locationToString(y, 1));
			if(rook != null && Piece.locationToName(rook).equals("Rook") && rook.count == 0){
				String check = null;
				for (int i = x - 1; i > 1; i--) {
					check = moveCheck(fiendly, enemy, locationToString(y, i));
					if(!check.equals("null"))break;
				}
				if(check.equals("null"))move = moveAdd(move, locationToString(y, 2));
			}
			rook = Player.locationToPiece(fiendly, locationToString(y, 8));
			if(rook != null && Piece.locationToName(rook).equals("Rook") && rook.count == 0){
				String check = null;
				for (int i = x + 1; i < 8; i++) {
					check = moveCheck(fiendly, enemy, locationToString(y, i));
					if(!check.equals("null"))break;
				}
				if(check.equals("null"))move = moveAdd(move, locationToString(y, 6));
			}
		}
		//체크 위치로 이동 불가
//		for (int i = 0; i < move.length; i++) {
//			outer: for (int j = 0; j < enemy.piece.length; j++) {
//				for (int l = 0; l < enemy.piece[j].mvblCrdnt.length; l++) {
//					if (move[i].equals(enemy.piece[j].mvblCrdnt[l])) {
//						move = moveDel(move, move[i]);
//						break outer;
//					}
//				}
//			}
//		}
		return move;
	}
	
	/**
	 * 퀸이 이동할 수있는 좌표를 저장한다.
	 * @param player
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] queen(Player fiendly, Player enemy, Piece piece, String[] move){
		
		move = rook(fiendly, enemy, piece, move);
		move = bishop(fiendly, enemy, piece, move);
		
		return move;
	}
	
	/**
	 * 폰이 갈 수 있는 좌표를 저장한다.
	 * @param player
	 * @param piece
	 * @param move
	 * @return
	 */
	static String[] pawn(Player fiendly, Player enemy, Piece piece, String[] move){
		
		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		
		int temp = 1;
		if(fiendly.name.equals("Player1")){	//진행 방향 8=>1
			
			for(int i= y; i >= (y-temp); i--){
				for(int j = -1; j<=1; j++){
					if(i==y && j != 0){
						//양파 상
					}else if(i == y-1){
						if(j== 0 && moveCheck(fiendly, enemy, locationToString(i, x)).equals("null")){
							move = moveAdd(move, locationToString(i, x));
						}else if(j != 0 && moveCheck(fiendly, enemy, locationToString(i, x+j)).equals("enemy")){
							move = moveAdd(move, locationToString(i, x+j));
						}
						if(piece.count == 0)temp = 2;
					}else if(i == y-2){
						if(j== 0 && moveCheck(fiendly, enemy, locationToString(i, x)).equals("null")){
							move = moveAdd(move, locationToString(i, x));
						}
					}
				}				
			}
			
		}
		else{	//진행 방향 1=>8
			for(int i= y; i <= (y+temp); i++){
				for(int j = -1; j<=1; j++){
					if(i==y && j != 0){
						//양파상
					}else if(i == y+1){
						if(j== 0 && moveCheck(fiendly, enemy, locationToString(i, x)).equals("null")){
							move = moveAdd(move, locationToString(i, x));
						}else if(j != 0 && moveCheck(fiendly, enemy, locationToString(i, x+j)).equals("enemy")){
							move = moveAdd(move, locationToString(i, x+j));
						}
						if(piece.count == 0)temp = 2;
					}else if(i == y+2){
						if(j== 0 && moveCheck(fiendly, enemy, locationToString(i, x)).equals("null")){
							move = moveAdd(move, locationToString(i, x));
						}
					}
				}				
			}
		}
		return move;
	}
	
	/**
	 * 피스가 이동함에 따른 변화
	 * @param fiendy
	 * @param enemy
	 * @param piece
	 * @param move
	 */
	static void movePiece(Board board, Player fiendly, Player enemy, Piece piece, String move){
		switch(Piece.locationToName(piece)){
		case "Rook":
			moveRook(board, fiendly, enemy, piece, move);
			break;
			
		case "Night":
			moveKnight(board, fiendly, enemy, piece, move);
			break;
			
		case "Bishop":
			moveBishop(board, fiendly, enemy, piece, move);
			break;
			
		case "King":
			moveKing(board, fiendly, enemy, piece, move);
			break;
			
		case "Queen":
			moveQueen(board, fiendly, enemy, piece, move);
			break;
			
		case "Pawn":
			movePawn(board, fiendly, enemy, piece, move);
			break;
		}
	}
	
	/**
	 * Rook이 이동하면서 생긴 변화
	 * @param board
	 * @param fiendly
	 * @param enemy
	 * @param piece
	 * @param move
	 */
	static void moveRook(Board board, Player fiendly, Player enemy, Piece piece, String move){

		int y = Board.locationToInt(piece.location.charAt(0));
		int x = Board.locationToInt(piece.location.charAt(1));
		
		if(locationKing(fiendly).equals(move)){	//이동할 위치에 아쿤 킹이 위치해 있으면(캐슬링)
			if(x == 1){
				board.pieceMove(piece, locationToString(y ,3));	//룩 이동
				board.pieceMove(Player.locationToPiece(fiendly, locationToString(y ,4)), locationToString(y, 2));
				
			}else{
				board.pieceMove(piece, locationToString(y ,5));	//룩 이동
				board.pieceMove(Player.locationToPiece(fiendly, locationToString(y ,4)), locationToString(y, 6));
			}
		}else{
			if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
				Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
			}
			board.pieceMove(piece, move);
		}
	}
	
	static void moveKnight(Board board, Player fiendly, Player enemy, Piece piece, String move){
		if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
			Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
		}
		board.pieceMove(piece, move);
	}
	
	static void moveBishop(Board board, Player fiendly, Player enemy, Piece piece, String move){
		if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
			Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
		}
		board.pieceMove(piece, move);
	}
	
	static void moveKing(Board board, Player fiendly, Player enemy, Piece piece, String move){
		
		int y = Board.locationToInt(move.charAt(0));
		int x = Board.locationToInt(move.charAt(1));
		System.out.println("카운트 : " + piece.count + "x축 : " + x);
		//캐슬링
		if(x== 2 && piece.count == 0){
			board.pieceMove(Player.locationToPiece(fiendly, locationToString(y , 1)), locationToString(y, 3));	//룩의 이동
			System.out.println("확인");
		}else if(x == 6 && piece.count == 0){
			board.pieceMove(Player.locationToPiece(fiendly, locationToString(y , 8)), locationToString(y, 5));	//룩의 이동
		}else{
			if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
				Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
			}
		}
		board.pieceMove(piece, move);	//킹의 이동
	}
	
	static void moveQueen(Board board, Player fiendly, Player enemy, Piece piece, String move){
		if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
			Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
		}
		board.pieceMove(piece, move);
	}
	
	static void movePawn(Board board, Player fiendly, Player enemy, Piece piece, String move){
		if(moveCheck(fiendly, enemy, move).equals("enemy")){	//이동할 위치에 적이 위치해 있으면
			Player.pieceDel(enemy, Player.locationToPiece(enemy, move));	//적의 피스를 삭제
		}
		board.pieceMove(piece, move);
	}
	
	/**
	 * 이동 위치에 적, 아군, 아무것도 없는지 파악
	 * @param move
	 * @return
	 */
	static String moveCheck(Player fiendly, Player enemy, String location){
		
		for(int i=0; i<fiendly.piece.length; i++){
			if(location.equals(fiendly.piece[i].location)){
				return "fiendly";
			}
		}
		
		for(int i=0; i<enemy.piece.length; i++){
			if(location.equals(enemy.piece[i].location)){
				return "enemy";
			}
		}
		return "null";
	}
	
	/**
	 * 적이 갈 수 있는 위치에 아군의 King이 위치해있는지 파악
	 * @enemy : 적
	 * @King : 아군의 King의 좌표
	 */
	static boolean checkKing(Player enemy, String King){
		for(int i=0; i<enemy.piece.length; i++){
			for(int j = 0; j<enemy.piece[i].mvblCrdnt.length; j++){
				if(King.equals(enemy.piece[i].mvblCrdnt[j]))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * 아군 킹의 좌표를 리턴
	 * @param fiendly 아군 Player
	 * @return
	 */
	static String locationKing(Player fiendly){
		for(int i=0; i< fiendly.piece.length; i++){
			if("King".equals(Piece.locationToName(fiendly.piece[i]))){
				return fiendly.piece[i].location;
			}
		}
		return null;
	}
	
	/**
	 * 배열을 추가 하여 좌표를 저장한다.
	 * @param move
	 * @param location
	 * @return
	 */
	static String[] moveAdd(String[] move, String location){
		String [] temp = new String[move.length+1];
		
		for(int i=0; i<move.length; i++){
			temp[i] = move[i];
		}
		temp[move.length] = location;
		
		return temp;
	}
	
	/**
	 * 이동 배열 삭제
	 * @param move
	 * @return
	 */
	static String[] moveDel(String[] move, String location){
		String[] temp = new String[move.length - 1];
		int line = 0;
		//삭제할 배열 위치 찾는다.
		for(int i= 0; i<move.length; i++){
			if(location.equals(move[i])){
				line = i;
				break;
			}
		}
		//삭제 배열을 삭제할 배열 다음부터 한칸씩 당기기
		for(int i=line; i<move.length-1; i++){
			move[i] = move[i+1];
		}
		
		//temp배열에 저장하기
		for(int i=0; i<temp.length; i++){
			temp[i] = move[i];
		}
		return temp;
	}
	
	/**
	 * 보드판을 넘어간 배열을 삭제
	 * @param move
	 * @return
	 */
	static String[] boarderDel(String[] move){
		
		String[] temp = new String[move.length];
		//??? temp = move를 했더니 중간에 값이 바뀜
		for(int i=0; i< temp.length; i++){
			temp[i] = move[i];
		}
		for(int i=0; i < temp.length; i++){
			int y = Board.locationToInt(temp[i].charAt(0)); // 1~8
			int x = Board.locationToInt(temp[i].charAt(1)); // 1~8
			if(x < 1 || x > 8 || y < 1 || y > 8){
				move = moveDel(move, temp[i]);
			}
		}
		
		return move;
	}
	
	static void playerDivision(){
		
	}
	
	static String locationToString(int y, int x){
		return Character.toString((char) ('A' + y - 1)) + x;
	}
}
