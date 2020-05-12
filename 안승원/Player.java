package 안승원;

public class Player {
	
	String name;
	
	Piece[] piece = new Piece[16];
	
	Player(int i) {
		this.name = "Player" + i;
		
		for(int j=0; j<piece.length; j++){
			piece[j] = new Piece(i, j);
		}
		
		int y = 1;
		int x = 1;
		for (int p = 0; p < piece.length; p++) {
			piece[p].init(i, y, x);
			x++;
			if (x == 9) {
				y = 2;
				x = 1;
			}
		}
	}
	
	/**
	 * 아군의 말중에 해당 좌표가 있는지 체크
	 * @param player
	 * @param location
	 * @return
	 */
	static boolean check(Player player, String location) {
		for (int i = 0; i < player.piece.length; i++) {
			if (location.equals(player.piece[i].location)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 해당 좌표의 말 객체
	 * @param player
	 * @param location
	 * @return
	 */
	static Piece locationToPiece(Player player, String location) {
		for (int i = 0; i < player.piece.length; i++) {
			if (location.equals(player.piece[i].location)) {
				return player.piece[i];
			}
		}
		return null;
	}
	
	/**
	 * 피스 삭제
	 * @param player
	 * @param piece
	 */
	static void pieceDel(Player player, Piece piece){
		Piece[] temp = new Piece[player.piece.length-1];
		
		int line = 0;
		//삭제할 배열 위치 찾는다.
		for(int i= 0; i<player.piece.length; i++){
			if(piece == player.piece[i]){
				line = i;
				break;
			}
		}
		//삭제 배열을 삭제할 배열 다음부터 한칸씩 당기기
		for(int i=line; i<player.piece.length-1; i++){
			player.piece[i] = player.piece[i+1];
		}
		
		//temp배열에 저장하기
		for(int i=0; i<temp.length; i++){
			temp[i] = player.piece[i];
		}
		player.piece = temp;
	}
	
}
