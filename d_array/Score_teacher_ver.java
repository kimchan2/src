package d_array;

import java.util.Arrays;

public class Score_teacher_ver {
	public static void main(String[] args) {
		// ======================================================================================
		System.out.println();
		System.out.println();
		System.out.println();

		String[] students = { "최우성", "유효상", "이재민" }; // 학생명
		String[] subjects = { "Java", "Oracle", "HTML", "CSS", "JQuery", "JSP" }; // 과목명
		double[][] scores = new double[students.length][subjects.length + 3]; // 배열 초기화

		for (int i = 0; i < scores.length; i++) {  
			scores[i][0] = 1; // [i][0] 석차부분인 배열의 0번째 부분을 1로 초기화
			for (int j = 0; j < subjects.length; j++) {
				scores[i][j + 1] = (int) (Math.random() * 51) + 50; // 0번째를 제외한 1번부터 6번까지 랜덤한 50~ 100 점수값으로 채움
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < subjects.length; j++) {
				scores[i][scores[i].length - 2] += scores[i][j + 1]; // scores[i].length - 2 = 7, 배열의 7번째에 총점을 구한다
			}
			scores[i][scores[i].length - 1] = (int) ((double) scores[i][scores[i].length - 2]
					/ subjects.length * 100 + 0.5) / 100.0; // 배열의 마지막인 8번째에 평균을 구해 넣는다
		}

		for (int i = 0; i < scores.length; i++) { // 배열의 8번째 값인 평균을 가지고 석차를 계산함
			for (int j = 0; j < scores.length; j++) {
				if (scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]) { 
					scores[i][0]++;
				}
			}
			System.out.println(Arrays.toString(scores[i]));
		}

		for (int i = 0; i < scores.length - 1; i++) { // scores.length - 1 = 2, 0,1
			for (int j = i + 1; j < scores.length; j++) { // 1,2
				if (scores[i][0] > scores[j][0]) { // 0이랑 1, 0이랑 2 비교, 1이랑 2랑 비교, 석차가 더 높으면(숫자가 크면) 뒤로 간다
					double[] ttemp = scores[i];    // 선택정렬
					scores[i] = scores[j];
					scores[j] = ttemp;

					String tempName = students[i];
					students[i] = students[j];
					students[j] = tempName;
				}
			}
		}

		System.out.print("석차\t이름");
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t총점\t평균");

		for (int i = 0; i < scores.length; i++) {
			System.out.print((int) scores[i][0] + "\t" + students[i]);
			for (int j = 1; j < scores[i].length; j++) {
				if (j == scores[i].length - 1) {
					System.out.print("\t" + scores[i][j]);
				} else {
					System.out.print("\t" + (int) scores[i][j]);
				}
			}
			System.out.println();
		}

		/*
		 * 한줄삭제 : Ctrl + d 한줄복사 : Ctrl + Alt + 방향키(위/아래) 한줄이동 : Alt + 방향키(위/아래)
		 */

	}

}
