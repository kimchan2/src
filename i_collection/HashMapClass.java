package i_collection;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapClass {

	public static void main(String[] args) {

		/*
		 * put()	: 지정된 키와 값을 저장
		 * get()	: 지정된 키의 값을 반환 (없으면 null)
		 * remove()	: 지정된 키로 저장된 값을 제거
		 * keySet()	: 저장된 모든 키를 Set으로 반환
		 */
		
		HashMap<String, String> map = new HashMap<>(); // 앞 : 키, 뒤 : 값, 키는 보통 String으로

		map.put("title", "제목입니다.");
		map.put("content", "내용입니다.");
		map.put("user", "김승섭");
		map.put("date", "2020-05-18 10:38");
		
		System.out.println(map.get("title"));
		System.out.println(map.get("content"));
		System.out.println(map.get("user"));
		System.out.println(map.get("date"));
		
		map.put("user", "홍길동"); // 같은 키에 값을 저장하면 기존의 값을 사라지고 새로운 값이 저장됨
		System.out.println(map.get("user"));
		
		map.remove("user"); // user, 홍길동 삭제
		System.out.println(map.get("user")); // null 출력
		
		System.out.println(map.keySet()); 
		System.out.println(map.keySet().getClass().getName());
		
		// keySet은 따로 값을 가져오는 방법이 없음, 향상된 for문을 이용, iterator 반복자를 이용해도됨
		// keySet은 key의 집합, 하나씩 key를 꺼내와서 맞는 value를 출력
		for(String key : map.keySet()){
			String value = map.get(key);
			System.out.println(key + " : " + value);
			
		}
		
		ArrayList<HashMap<String,String>> list = new ArrayList<>();
		HashMap<String, String> m = new HashMap<>();
		m.put("DEPTNO", "10");
		m.put("DNAME", "ACOOUNTING");
		m.put("LOC", "NEW YORK");
		list.add(m);
		
		m = new HashMap<>();
		m.put("DEPTNO", "20");
		m.put("DNAME", "RESEARCH");
		m.put("LOC", "DALLAS");
		list.add(m);
		
		m = new HashMap<>();
		m.put("DEPTNO", "30");
		m.put("DNAME", "SALES");
		m.put("LOC", "CHICAGO");
		list.add(m);
		
		m = new HashMap<>();
		m.put("DEPTNO", "40");
		m.put("DNAME", "OPERATIONS");
		m.put("LOC", "BOSTON");
		list.add(m);
		
		m = new HashMap<>();
		m.put("DEPTNO", "99");
		m.put("DNAME", "ddit");
		m.put("LOC", "daejeon");
		list.add(m);
		
		m = new HashMap<>();
		m.put("DEPTNO", "98");
		m.put("DNAME", "대덕");
		m.put("LOC", "대전");
		list.add(m);
		
		for(HashMap i : list){
			System.out.println(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (String key : list.get(i).keySet()) {
				String value = list.get(i).get(key);
				System.out.print(key + " : " + value + ", ");
			}
			System.out.println();
		}
		
	}

}
