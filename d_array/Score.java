package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 Java, Oracle, HTML, CSS, JQeury, JSP 점수를 50 ~ 100 까지 랜덤으로 생성시키고
		 * 석차순으로 석차, 이름, 과목별 점수, 총점, 평균을 출력해주세요
		 * 
		 * 석차  		이름  		Java 	 Oracle  	HTML  	CSS  	JQeury  	JSP  	총점  	평균
		 * 1      	홍길동 		100		 100	 	100   	100  	100     	100  	600 	100.0
		 */
		int studentsNum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명의 학생을 입력 하시겠습니까? ");
		studentsNum = Integer.parseInt(sc.nextLine());
		
		String[][] ourClass = new String[studentsNum][8]; // 학생수, 과목수
		int[] sum = new int[studentsNum];
		double[] avg = new double[studentsNum];
		
		int answer = 0;
		int changeAnswer = 0;
		int changeCnt = 0;
		String changeData = " ";
			
			for(int i = 0; i < ourClass.length; i++){
				System.out.print("학생의 이름, 6가지 과목의 성적을 입력해 주세요(구분은 띄어쓰기로 합니다) : ");
				changeCnt++;
				for(int j = 1; j < ourClass[i].length; j++){
					ourClass[i][j] = sc.next();
				}
				System.out.println(Arrays.toString(ourClass[i]));
				
				sc.nextLine(); // Scanner를 이용하여 입력을 받다가 '\n' 개행 문자가 버퍼에 들어가서 입력이
							   // 중복되거나 에러가 생기는 경우가 있습니다.
							   // Scanner sc = new Scanner();
							   // 에러를 방지하기위해 입력을 받고 개행문자가 들어가는 곳 다음에 대기가 필요합니다.
							   // sc.nextLine()를 사용하여서 개행문자를 한번 받아준다면
							   // 에러를 해결 할 수 있습니다.
				
				while(true){
					if(changeCnt == ourClass.length+1)
						break;
				System.out.print("일부수정 혹은 입력데이터 삭제를 하시겠습니까? (일부수정 0, 삭제 1, 계속진행 2) : ");
				answer = Integer.parseInt((sc.nextLine()));
				
				if(answer == 0){
					System.out.print("수정하고 싶은 데이터의 번호를 입력해주세요 ( 1(이름), 2(Java), 3(Oracle),"
							+ " 4(HTML), 5(CSS), 6(JQeury), 7(JSP) ) : ");
					changeAnswer = Integer.parseInt((sc.nextLine()));
					System.out.print("수정하고 싶은 데이터의 내용을 입력해주세요 : ");
					changeData = sc.nextLine();
					for ( int m = 1; m < ourClass[i].length; m++){
						if( m == changeAnswer){
							ourClass[i][m] = changeData;
						}
					}
					System.out.println(Arrays.toString(ourClass[i]));
					break;
				}
				else if(answer == 1){
						for(int l = 1; l < ourClass[i].length; l++){
							ourClass[i][l] = "0";
						}
						System.out.println(Arrays.toString(ourClass[i]));
						i--;
						changeCnt--;
						break;
				}else if(answer == 2){
					break;
				}else{
					System.out.print("잘못 입력하였습니다.");
					System.out.println();
				}
				}
			}

		
		
//		String[] name = {"김동훈", "김아현", "김지수", "김찬희", "박경범", "박성하", "박승화", "박하은", "박혜선", "안승원", "오송현", "원종찬", "유효상", "이원우", "이재민", "이지윤", "이헌이", "이희욱", "정성훈", "정재은", "정지수", "정혁도", "채홍규", "최우성", "하지민", "한진수"};
		
		
		for( int i = 0; i < ourClass.length; i++){
			for(int k = 0; k != 2; k++ ){
				if( k == 0){
					ourClass[i][k] = Integer.toString(1);
					continue;
				}
					
//				ourClass[i][k] = name[i];
			}
//			for ( int j = 2; j < ourClass[i].length; j++){
//				ourClass[i][j] = Integer.toString(((int)(Math.random()*51) + 50));
//			}
//			System.out.println(Arrays.toString(ourClass[i]));	
		}
		
		for( int i = 0; i < ourClass.length; i++){
			for( int j = 2; j < ourClass[i].length; j++){
				
				sum[i] += Integer.parseInt(ourClass[i][j]); 
				
			}
			avg[i] = (double)sum[i] / (ourClass[i].length-2);
		}
//		System.out.println(Arrays.toString(sum));
//		System.out.println(Arrays.toString(avg));
		

		for (int i = 0; i < ourClass.length; i++) {
			for (int j = 0; j < ourClass.length; j++) {

				if (i != j && sum[i] < sum[j]) {
					ourClass[i][0] = Integer.toString((Integer.parseInt(ourClass[i][0]) + 1));
				}
			}

		}
		
		String[] temp = new String[1];
		int tempSum = 0;
		double tempAvg = 0.0;
		
		for ( int i = 0; i < ourClass.length; i++){
			for( int j = i+1 ; j < ourClass.length; j++){ // j = 0으로 놓고 numbers[i] < numbers[j]로 해도
														 // 큰수가 계속 뒤로 가기때문에 정렬이 되긴 된다
				
				for( int k = 0; k < ourClass[i].length; k++){
					if ( Integer.parseInt(ourClass[i][0]) > Integer.parseInt(ourClass[j][0])){
						temp = ourClass[j];
						ourClass[j] = ourClass[i];
						ourClass[i] = temp;
					
						tempSum = sum[j];
						sum[j] = sum[i];
						sum[i] = tempSum;
					
						tempAvg = avg[j];
						avg[j] = avg[i];
						avg[i] = tempAvg;
					}
				}
			}
		}
		
		
		for( int i = 0; i < ourClass.length; i++){
//			System.out.println(Arrays.toString(ourClass[i]) + " " + sum[i] + " " + avg[i]);	
		}
		
		System.out.println("석차\t이름\tJava\tOracle\tHTML\tCSS\tJqeury\tJSP\t총점\t평균");
		for(int i = 0; i < ourClass.length; i++){
			for(int j = 0; j < ourClass[i].length; j++){
				System.out.print(ourClass[i][j]+"\t");
			}
			System.out.print(sum[i] + "\t" + avg[i]);
			System.out.println();
		}
		
		
		
		
		
//		======================================================================================
		/*System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		String[] students = { "최우성", "유효상", "이재민"};
		String[] subjects = { "Java", "Oracle", "HTML", "CSS", "JQuery", "JSP"};
		double[][] scores = new double[students.length][subjects.length + 3];
		
		for(int i = 0; i < scores.length; i++){
			scores[i][0] = 1;
			for( int j = 0; j < subjects.length; j++){
				scores[i][j+1] = (int)(Math.random() *51) + 50;
			}
		}
		
		for( int i = 0; i < scores.length; i++){
			for( int j = 0; j < subjects.length; j++){
				scores[i][scores[i].length - 2] += scores[i][j+1];
			}
			scores[i][scores[i].length - 1 ] = (int)((double)scores[i][scores[i].length -2]
														/subjects.length * 100 + 0.5 ) / 100.0;
		}
		
		for ( int i = 0; i < scores.length; i++){
			for ( int j = 0; j < scores.length; j++){
				if(scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]){
					scores[i][0]++;
				}
			}
		}
		
		for ( int i = 0; i < scores.length - 1; i++){
			for(int j = i + 1; j < scores.length; j++){
				if(scores[i][0] > scores[j][0]){
					double[] ttemp = scores[i];
					scores[i] = scores[j];
					scores[j] = ttemp;
					
					String tempName = students[i];
					students[i] = students[j];
					students[j] = tempName;
				}
			}
		}
		
		System.out.print("석차\t이름");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t총점\t평균");
		
		for(int i = 0; i < scores.length; i++){
			System.out.print((int)scores[i][0] + "\t" + students[i]);
			for(int j = 1; j < scores[i].length; j++){
				if(j == scores[i].length - 1){
					System.out.print("\t" + scores[i][j]);
				}else{
					System.out.print("\t" + (int)scores[i][j]);
				}
			}
			System.out.println();
		}*/
		
		/*
		 * 한줄삭제 : Ctrl + d
		 * 한줄복사 : Ctrl + Alt + 방향키(위/아래)
		 * 한줄이동 : Alt + 방향키(위/아래)
		 */
		
	}

}
