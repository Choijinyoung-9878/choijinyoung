class Person {

	String name;
	int age;
	
	Person(){
		this("�̸�����",1);     // Person(String,int)  ������ ȣ��
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	Person returnItSelf() {
		return this;    // �ּҸ� ��ȯ�ϴ� ��
		
	}
	public class CallAnotherConst {
		public void main(String[] args) { 
			
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);
		
		Person p = noName.returnItSelf();
		System.out.println(p);
		System.out.println(noName);
	}
}
}
	
	
	