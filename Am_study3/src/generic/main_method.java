package generic;

public class main_method {

	public static void main(String[] args) {
		
		seafood_box<seafood> 해산물박스 = new seafood_box<>();
		해산물박스.setBox(new seafood());
		해산물박스.setBox(new 오징어() );
		해산물박스.setBox(new  참치() );
		해산물박스.setBox(new  새우() );
		
//		해산물박스 = new seafood_box<새우>();
		
		seafood_box<새우> 새우박스 = new seafood_box<>();
		새우박스.setBox(new 새우());
		
		seafood_box<오징어> 오징어박스 = new seafood_box<>();
		오징어박스.setBox(new 오징어());
		
		구매 구매자 = new 구매();
		구매자.buy(오징어박스);		
		구매자.buy(새우박스);
		
		//seafood_box에 오징어박스라는 객체를 만들었을 뿐 오징어를 불러오거나 한것이 아님.
//		seafood_box<오징어> 오징어박스 = new seafood_box<>();
//		
//		오징어박스.setBox(new 오징어());
//		오징어박스.sellBox();
//		
//		seafood_box<새우> 새우박스 = new seafood_box<>();
//		새우박스.setBox(new 새우());
//		
//		오징어박스.setBox(new 참치() );
		// 오징어박스는 오징어 객체만
		
		
		
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		list.add(100);
//		list.add(200);
//		list.add(342);
//		list.add(3.14);
//		list.add("박영주 목발");
//		
//		System.out.println(list);
		
		
	}
}
