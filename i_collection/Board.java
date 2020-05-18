package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Board {

	static ArrayList<HashMap<String, Object>> board = new ArrayList<>();
	
	public static void main(String[] args) {

		// 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		// 번호, 제목, 내용, 작성자, 작성일

		// 처음엔 목록이 출력되고
		// 1. 조회 2. 등록
		// 조회시 : 1.수정 2.삭제 3.목록
		Scanner sc = new Scanner(System.in);
		String ans = "";
		int no = 0;
		String title = "";
		String contents = "";
		String writer = "";
		String date = "";
		
//		ArrayList<HashMap<String, Object>> board = new ArrayList<>();

		while (true) {
			if (board.size() == 0) {
				System.out.println("게시판이 비어있습니다.");
			} else if (board.size() != 0) {
				System.out.println();
				System.out.println("=====================게시판 목록=====================");
				System.out.println("번호\t작성일\t\t\t제목\t작성자\t내용");
				for (int i = 0; i < board.size(); i++) {
					for (String key : board.get(i).keySet()) {
						Object value = board.get(i).get(key);
						System.out.print(value + "\t");
//						if (key.equals("번호")) {
//							System.out.print("번호 : " + value + "\t");
//						}
//						if (key.equals("제목")) {
//							System.out.print("제목 : " + value + "\t");
//						}
//						if (key.equals("내용")) {
//							System.out.print("내용 : " + value + "\t");
//						}
//						if (key.equals("작성자")) {
//							System.out.print("작성자 : " + value + "\t");
//						}
//						if (key.equals("작성일")) {
//							System.out.print("작성일 : " + value + "\t");
//						}
					}
					System.out.println();
				}
			}
			System.out.println();
			
			System.out.print("선택해 주십시오. (1 : 조회, 2 : 등록)");
			ans = sc.nextLine();
			
			// 1. 조회
			if (ans.equals("1")) {
				if(board.size() == 0){
					continue;
				}
				
				System.out.print("선택해 주십시오. (1 : 수정, 2 : 삭제, 3 : 목록)");
				ans = sc.nextLine();

				// 1. 게시글 수정
				if (ans.equals("1")){
					System.out.print("수정하고 싶은 게시글 번호를 입력해주세요 : ");
					int correctNo = Integer.parseInt(sc.nextLine());
					System.out.print("수정하고 싶은 내용을 입력해주세요 : ");
					String correctContents = sc.nextLine();
					board.get(correctNo-1).put("내용", correctContents);
					
				}
				System.out.println();
				
				// 2. 게시글을 삭제하면 나머지 게시글의 번호를 다시지정해줌
				if (ans.equals("2")){
					System.out.print("삭제하고 싶은 게시글 번호를 입력해주세요 : ");
					int correctNo = Integer.parseInt(sc.nextLine());
					board.remove(correctNo-1);
					
					for(int i = 0; i < board.size(); i++){
						for(String key : board.get(i).keySet()){
							if(key.equals("번호")){
								board.get(i).put(key, i+1);
							}
						}
					}
					
				}
				System.out.println();
				
				// 3. 게시글 목록 출력
				if (ans.equals("3")) {
					if (board.size() == 0) {
						continue;
					} else if (board.size() != 0) {
						System.out.println();
						System.out.println("=====================게시판 목록=====================");
						for (int i = 0; i < board.size(); i++) {
							for (String key : board.get(i).keySet()) {
								Object value = board.get(i).get(key);
								System.out.print( key + ": " + value + " || \t");
//								if (key.equals("번호")) {
//									System.out.print("번호 : " + value + "\t");
//								}
//								if (key.equals("제목")) {
//									System.out.print("제목 : " + value + "\t");
//								}
//								if (key.equals("내용")) {
//									System.out.print("내용 : " + value + "\t");
//								}
//								if (key.equals("작성자")) {
//									System.out.print("작성자 : " + value + "\t");
//								}
//								if (key.equals("작성일")) {
//									System.out.print("작성일 : " + value + "\t");
//								}
							}
							System.out.println();
						}
					}
					System.out.println();
				}
				
			}
			// 2. 등록
			else if(ans.equals("2")){
				HashMap<String, Object> map = new HashMap<>();
				no++;
				map.put("번호", no); // 번호는 ++ 자동으로 넣어줌
				
				System.out.print("제목을 입력하세요 : ");
				ans = sc.nextLine();
				map.put("제목", ans);
				
				System.out.print("내용을 입력하세요 : ");
				ans = sc.nextLine();
				map.put("내용", ans);
				
				System.out.print("작성자를 입력하세요 : ");
				ans = sc.nextLine();
				map.put("작성자", ans);
				
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				map.put("작성일", sdf.format(today));
				
				board.add(map);
			}
			
			
			
		}
	}

}
