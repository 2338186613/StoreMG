package ShoppingSystem;

import java.util.*;

import ShoppingSystem.DataBase.*;
import ShoppingSystem.idea.*;

public class ShoppingMain {
	public static void main(String[] args) {
		/**
		 *	user		存放用户数据
		 *	userSystem	用户管理系统
		 *	mallSystem	购物商城系统*/
		Scanner scan = new Scanner(System.in);
		User user=new User();
		UserSystem userSystem=new UserSystem();
		MallSystem mallSystem=new MallSystem();
		while(true) {
			if(user.getUserName()==null||!user.getUserName().equals("root")) {
				System.out.println("\n* * * * * * * 翻斗花园购物系统 * * * * * * * \n");
				System.out.println("\t\t1.用户管理");
				System.out.println("\t\t2.购物商城");
				System.out.println("\t\t3.退出系统");
				System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
				System.out.print("使用功能编号：");
				switch (scan.next()) {
				case "1":
					user=userSystem.idea(user);
					break;
				case "2":
					user=mallSystem.idea(user);
					break;
				case "3":
					scan.close();
					System.exit(0);
				default:
					System.out.println("输入错误！请重新输入！");
				}
			}else {
				System.out.println("\n* * * * * * * * 管理员系统 * * * * * * * * *\n");
				System.out.println("\t\t1.用户管理");
				System.out.println("\t\t2.购物商城");
				System.out.println("\t\t3.退出系统");
				System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
				System.out.print("使用功能编号：");
				switch (scan.next()) {
				case "1":
					user=userSystem.rootIdea(user);
					break;
				case "2":
					user=mallSystem.rootIdea(user);
					break;
				case "3":
					scan.close();
					System.exit(0);
				default:
					System.out.println("输入错误！请重新输入！");
				}
			}
	
		}
	}
}
