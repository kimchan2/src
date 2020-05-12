package 안승원;

public class Piece {

	static String[] mal = {"Rook","Night", "Bishop", "King", "Queen", "Bishop", "Night", "Rook", "Pawn"};
	
	String name;
	
	String location;
	
	int count = 0;
	
	String[] mvblCrdnt = new String[0];
	
	/**
	 * 이름 초기화
	 * @param i
	 */
	Piece(int i, int j) {
		if (j < 8) {
			if (i == 1) {
				name = Character.toString((char) (mal[j].charAt(0) + 32))
						+ mal[j].substring(1);
			} else {
				name = mal[j];
			}
		} else {
			if (i == 1) {
				name = Character.toString((char) (mal[8].charAt(0) + 32))
						+ mal[8].substring(1);
			} else {
				name = mal[8];
			}
		}
	}
	
	/**
	 * 피스 좌표 초기화
	 * @param i : 플레이어 번호
	 * @param y : y축
	 * @param x : x축
	 */
	void init(int i, int y, int x){
		if (i == 1) { // 백 H1~H8 G1~G8
			location = Character.toString((char) ('I' - y)) + x;
		} else { // 흑 A1~A8 B1~B8
			location = Character.toString((char) ('A' + y - 1)) + x;
		}
	}
	
	/**
	 * 선택한 말의 이름이 무엇인지
	 * @param piece
	 * @return
	 */
	static String locationToName(Piece piece) {
		if ('a' <= piece.name.charAt(0) && piece.name.charAt(0) < 'z') {
			return piece.name.substring(0, 1).toUpperCase()
					+ piece.name.substring(1).toLowerCase();
		}
		return piece.name;
	}
}
