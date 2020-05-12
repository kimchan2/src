package 안승원;

import java.util.Arrays;
import java.util.Scanner;

// 모든 피스의 이동 할 수 있는 좌표를 계속 저장할 것
public class Main {

	public static void main(String[] args) {
		
		Player[] player = new Player[2];
		
		Board board = new Board();
		
		Scanner s = new Scanner(System.in);
		
		boolean turn = false;
				
		//플레이어 객체 생성
		for(int i=0; i< player.length; i++){
			player[i] = new Player(i+1);
		}
		board.boardInit(player);
		
		 while(true){
			board.boardPrint(board.location, true);
			System.out.println(String.format("%35s", "round : " + board.round));
			System.out.println(String.format("%35s", board.state));
			
			//적의 말이 갈 수 있는 위치
			for(int i=0; i<player[turn?0:1].piece.length; i++){
				player[turn?0:1].piece[i].mvblCrdnt = Rule.mvblCrdnt(player[turn?0:1], player[turn?1:0], player[turn?0:1].piece[i]);
			}
			
			String select = null;
			String[] mvblCrdnt = null;
			//적이 갈 수 있는 위치에 킹이 위치해 있다.
			if(Rule.checkKing(player[turn?0:1], Rule.locationKing(player[turn?1:0]))){
				
				select = Rule.locationKing(player[turn?1:0]);	//킹의 좌표
//				System.out.println("킹의 좌표"+ select);
				
				//이동할 좌표를 검색
				mvblCrdnt = Rule.mvblCrdnt(player[turn?1:0], player[turn?0:1], Player.locationToPiece(player[turn?1:0], select));

				if(mvblCrdnt.length == 0 || mvblCrdnt == null){
					board.state = "체크메이트";
					System.out.println(player[turn?0:1].name + "님 승리!!");
					break;
				}else{
					//이동할 좌표를 출력
					//board.boardNav(mvblCrdnt);
					board.state = "체크";
					
					board.boardPrint(board.location, true);
					System.out.println(String.format("%35s", "round : " + board.round));
					System.out.println(String.format("%35s", board.state));
					
					System.out.print(player[turn?1:0].name + "님 말을 선택해주세요 >");
					select = s.nextLine();	//말이 있는 좌표를 입력
					while(!Player.check(player[turn?1:0], select)){	//자신의 말이 아니면 다시 입력
						System.out.print(player[turn?1:0].name + "님 말을 선택해주세요 >");
						select = s.nextLine();
					}
					
					//이동할 좌표를 검색
					mvblCrdnt = Rule.mvblCrdnt(player[turn?1:0], player[turn?0:1], Player.locationToPiece(player[turn?1:0], select));
					//이동할 좌표를 출력
					System.out.println("이동 가능 좌표" +Arrays.toString(mvblCrdnt));
					board.boardNav(mvblCrdnt);
					board.state = "";
				}
			}else{
				System.out.print(player[turn?1:0].name + "님 말을 선택해주세요 >");
				select = s.nextLine();	//말이 있는 좌표를 입력
				while(!Player.check(player[turn?1:0], select)){	//자신의 말이 아니면 다시 입력
					System.out.print(player[turn?1:0].name + "님 말을 선택해주세요 >");
					select = s.nextLine();
				}
				
				//이동할 좌표를 검색
				mvblCrdnt = Rule.mvblCrdnt(player[turn?1:0], player[turn?0:1], Player.locationToPiece(player[turn?1:0], select));
				//이동할 좌표를 출력
				System.out.println("이동 가능 좌표" +Arrays.toString(mvblCrdnt));
				board.boardNav(mvblCrdnt);
				board.state = "";
			}
			
			Piece seletPiece = Player.locationToPiece(player[turn?1:0], select);
			
			
			System.out.println(String.format("%35s", "round : " + board.round));
			System.out.println(String.format("%35s", board.state));
			System.out.println("이동 가능 좌표" +Arrays.toString(mvblCrdnt));
			System.out.print(player[turn?1:0].name + "님 이동할 좌표를 선택해주세요(다시 선택) >");
			String location = s.nextLine();	//이동할 좌표를 입력
			
			outer: while(true){
				for(int i = 0; i<mvblCrdnt.length; i++){
					if(location.equals(mvblCrdnt[i])){
						break outer;
					}
				}
				if(location.equals("다시 선택"))break;
				System.out.print(player[turn?1:0].name + "님 이동할 좌표를 선택해주세요(다시 선택) >");
				location = s.nextLine();
			}
			if(location.equals("다시 선택"))continue;
			
			//선택된 곳으로 이동하며 생긴 판의 변화를 입력
			Rule.movePiece(board, player[turn?1:0], player[turn?0:1], seletPiece, location);
			
			//킹이 죽으면 끝
			boolean die  = true;
			for(int i=0; i < player[turn?0:1].piece.length; i++){
				if(Piece.locationToName(player[turn?0:1].piece[i]).equals("King"))
					die = false;
			}
			if(die){
				System.out.println(player[turn?1:0].name + "님의 승리!!");
				break;
			}
			
			//폰 승급 체크
			if(Piece.locationToName(seletPiece).equals("Pawn")){
				int y = Board.locationToInt(seletPiece.location.charAt(0));
				if(y == 1 || y == 8){
					outer: while(true){
						System.out.print("승급할 말을 입력하세요.>");
						String name = s.nextLine();
						for(int i=0; i<Piece.mal.length-1; i++){
							if(!name.equals("King") && name.equals(Piece.mal[i])){
								if(!turn){	//플레이어1
									seletPiece.name = name.substring(0, 1).toLowerCase() + name.substring(1).toLowerCase();
								}else{		//플레이어2
									seletPiece.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
								}
								board.pieceMove(seletPiece, seletPiece.location);
								break outer;
							}
						}
					}
				}
			}
			
			seletPiece.count++;
			board.round++;
			turn = !turn;
		}
	}

}
