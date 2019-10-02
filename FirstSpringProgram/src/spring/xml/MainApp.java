package spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	HelloWorld object = (HelloWorld) context.getBean("helloWorld");
	object.setMessage("MyMessage");
	object.getMessage();

	HelloWorld object2 = (HelloWorld) context.getBean("helloWorld");
	object2.getMessage();
	System.out.println("------------------------------------------------------");
	
	NewWorld newWorldObject = (NewWorld) context.getBean("newWorld");
	newWorldObject.setNewWorld("first new world");
	newWorldObject.getNewWorld();

	NewWorld newWorldObject2 = (NewWorld) context.getBean("newWorld");
	newWorldObject2.getNewWorld();	
	
    }
}
