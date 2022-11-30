package command;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DAO.venture_DAO;
import VO.venture;

public class main_cmd {
	
	public static void main(String[] args) {
		venture_DAO vdao = new venture_DAO();
		List<venture> list = vdao.Select_all();
		
		// 카테고리 중복 제거 분류 출력
		Set<String> category = new HashSet<>();
		//Set - 중복허용 X
		
		// 분류 출력 
		Iterator<venture> it = list.iterator();
		while(it.hasNext()) {
			category.add(it.next().getCategory());
		}
		
		Set<venture> retail = new HashSet<>(); // 도소매업
		Set<venture> sw = new HashSet<>(); // 정보처리, SW
		Set<venture> build = new HashSet<>(); // 건설, 운수
		
		it = list.iterator();
		while(it.hasNext()) {
			venture data = it.next(); //벤처데이터들을 하나씩 data에 저장하기
			if(data.getCategory().contains("도소매업") )
				retail.add(data);
			if(data.getCategory().contains("정보처리") )
				sw.add(data);
			if(data.getCategory().contains("건설") )
				build.add(data);
		}
//		System.out.println( sw.size() );
		
//		System.out.println(retail);
		
		// 차집합, 교집합, 합집합
		// 주소를 기준으로 ....
		
		HashSet<String> name1 = new HashSet<>();
		HashSet<String> name2 = new HashSet<>();
		
		name1.add("김유신");	name1.add("이순신");	name1.add("김춘추");
		name1.add("장영주");	name1.add("김기원");	name1.add("윤재영");
		name1.add("이지현");	name1.add("미지연");	name1.add("최윤도");
		
		name2.add("김민정");	name2.add("김민서");	name2.add("김춘추");
		name2.add("장영주");	name2.add("이종빈");	name2.add("윤재영");
		name2.add("이지현");	name2.add("변크리스탈");	name2.add("리정수");
		
		Set<String> hab = new HashSet<>();
		Set<String> cha = new HashSet<>();
		Set<String> gyo = new HashSet<>();
		
		//name1과 name2를 비교하여 출력한다.
		//name1번을 다 출력하고 name2와 비교해서 중복은 빼고 출력함.
		
		// 합집합 (중복 제외한 둘의 합 전체)
		int i = 0;
		Iterator<String> test = name1.iterator();
		while(test.hasNext()) { // name1의 데이터를 hab에 저장
			hab.add(test.next());
			i++;
		}
		test = name2.iterator();
		while(test.hasNext()) { // name2의 데이터를 hab에 있는지를 비교하여 없으면 저장
			String name=test.next();
			if(hab.contains(name)) // hab내부에 name 값이 있는가??
				continue;
			hab.add(name);
			i++;
		}
		System.out.println("합집합 : " + hab);
		
		// 교집합 (중복인 것만)
		test = name2.iterator();
		while(test.hasNext()) {
			String name = test.next();
			if(name1.contains(name))
				gyo.add(name);
		}
		System.out.println("교집합 : " + gyo);
		
		// 차집합
		test = name2.iterator();
		while(test.hasNext()) { // name2와 name1의 차집합, name2에만 있는 이름 찾기
			String name = test.next();
			if(name1.contains(name))
				continue;
			cha.add(name);
		}
		System.out.println("차집합 : " + cha);
		
		// 출력
//		for(venture v : list) {
//			System.out.println("번호 : " + v.getNum()+"\n회사이름 : "+v.getCompany()+"\n회사주소 : "+v.getAddr()+
//					"\n사업종류 : "+v.getCategory()+"\n기술종류 : "+v.getBusiness_name()+"\n프로덕트 : "+v.getProduct()+"\n");
//		}
	}
}
