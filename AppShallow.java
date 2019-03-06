package com.qinhan.objclone.shallow;

public class AppShallow {
/**
 * 浅复制测试
 * 浅拷贝：创建一个新对象，然后将当前对象的非静态字段复制到该对象，
 * 如果字段类型是值类型（基本类型）的，那么对该字段进行复制；
 * 如果字段是引用类型的，则只复制该字段的引用而不复制引用指向的对象。
 * 此时新对象里面的引用类型字段相当于是原始对象里面引用类型字段的一个副本，原始对象与新对象里面的引用字段指向的是同一个对象。
 * @param args  main方法参数
 * @throws CloneNotSupportedException 
 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//创建一个包含可变引用属性的Person对象作为我们要复制的对象
			Person person=new Person(15,"zhang",new Address("四川","天府二街"));
			
			//这里使用实现的clone方法来复制本身
			Person clonePerson=(Person) person.clone();
			
			//打印被复制的对象和clone对象 这里是打印的是地址。
			System.out.println(person);
			System.out.println(clonePerson);
			System.out.println("这里的地址是不同的，表示clone对象和原对象是两个不同的对象");
			
			//打印被复制的对象和clone对象 这里是值
			System.out.println(person.display());
			System.out.println(clonePerson.display());
			
			//然后我们进行重设值，将clone对象的基本属性以及String类型属性以及Address类型属性更改，查看是否对原对象有影响
			clonePerson.setName("li");
			clonePerson.setAge(22);
			Address address=clonePerson.getAddress();
			address.setStreet("天府四街");
			//查看重设值后 clone对象和原对象的更改，如果原对象的引用属性也更改，就表示是浅复制，如果原对象没有改变，就表示是深复制。
			System.out.println(person.display());
			System.out.println(clonePerson.display());
//			System.out.println("仔细查看这四次，发现引用属性Address的地址是同一个。所以实现clone只是浅复制");
			System.out.println("仔细查看这四次，发现引用属性更改了，表示是浅复制");
	}

}
