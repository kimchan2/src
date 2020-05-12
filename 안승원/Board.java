package 안승원;

public class Board {
	
	String[][] location = {{" ", "1", "2", "3", "4", "5", "6", "7", "8"},
						   {"A", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"B", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"C", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"D", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"E", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"F", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"G", " ", " ", " ", " ", " ", " ", " ", " "},
						   {"H", " ", " ", " ", " ", " ", " ", " ", " "}};
	
	String state = "";
	
	int round = 1;
	
	//되돌리기 할때로 되돌리기 위해 필요한 변수를 넣어야 한다.
	
	/**
	 * 화면 지우기
	 */
	static void clearScreen() {
		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}
	
	/**
	 * 보드 초기화
	 * @param player
	 */
	void boardInit(Player[] player){
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < player[i].piece.length; j++) {
				pieceMove(player[i].piece[j], player[i].piece[j].location);
			}
		}
	}
	
	/**
	 * 전 좌표 정보 삭제 후 새로운 좌표에 피스 이동
	 * @param piece 말
	 * @param newVector 이동할 위치
	 */
	void pieceMove(Piece piece, String newVector){

		int y = Board.locationToInt(piece.location.charAt(0)); // 1~8
		int x = Board.locationToInt(piece.location.charAt(1)); // 1~8
		
		location[y][x] = " ";
		
		y = Board.locationToInt(newVector.charAt(0));
		x = Board.locationToInt(newVector.charAt(1));
		
		location[y][x] = Character.toString(piece.name.charAt(0));
		
		piece.location = newVector;
	}
	
	/**
	 * 보드 출력
	 */
	void boardPrint(String[][] location, boolean clean){
		if(clean)clearScreen();
		for(int i=0; i<18; i++){
			for(int j=0; j<18; j++){
				if(i== 0){
					if(j == 0){
						System.out.print(" ");
					}else if(j%2==0){
						System.out.print(location[i/2][j/2]);
					}else{
						System.out.print("   ");
					}
				}else if(i%2 == 0){
					if(j == 0){
						System.out.print(location[i/2][j/2]);
					}else if(j%2==0){
						System.out.print(location[i/2][j/2]);
					}else{
						System.out.print(" | ");
					}
				}else{
					if(j == 0){
						System.out.print(" ");
					}else if(j%2==0){
						System.out.print("-");
					}else{
						System.out.print("---");
					}
				}
			}
			System.out.println();
		}
	}
	
	
	void boardNav(String[] mvblCrdnt){
		String tempBoard[][] = new String[location.length][location[0].length];
		
		//임시 복사
		for(int i=0; i<location.length; i++){
			for(int j=0; j<location[i].length; j++){
				tempBoard[i][j] = location[i][j];
			}
		}
		
		//이동 가능 구역 표시
		for(int i=0; i<mvblCrdnt.length; i++){
			tempBoard[locationToInt(mvblCrdnt[i].charAt(0))][locationToInt(mvblCrdnt[i].charAt(1))] = "■";
		}
		boardPrint(location, true);
		System.out.println();
		boardPrint(tempBoard, false);
	}
	
	/**
	 * 문자 좌표를 배열 좌표로 변환
	 * @param c
	 * @return
	 */
	static int locationToInt(char c){
		if('0' > c || c > '9'){
			return c - 'A' + 1;
		}else{
			return c-'0';
		}
	}
}
