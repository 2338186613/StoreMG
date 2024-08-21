package ShoppingSystem.idea;

import java.util.ArrayList;
import java.util.Scanner;

import ShoppingSystem.DataBase.*;

public class UserSystem{

	private Scanner scan=new Scanner(System.in);
	private ArrayList<User> userAll=new ArrayList<User>();
	private ArrayList<User> rootUserAll=new ArrayList<User>();
	private User user=new User();
	{
		User rootUser=new User("root","root","root","root");
		rootUserAll.add(rootUser);
	}
	//普通用户
	public User idea(User user) {
		// TODO 自动生成的方法存根	
		this.user=user;
		while(true) {
			if(this.user.getUserName()==null||!this.user.getUserName().equals("root")) {
				System.out.println("\n* * * * * * * * 用户管理 * * * * * * * * \n");
				System.out.println("\t\t1.用户注册");
				System.out.println("\t\t2.用户登录");
				System.out.println("\t\t3.管理员登陆");
				System.out.println("\t\t4.返回");
				System.out.println("\t\t5.退出系统");
				System.out.println("\n* * * * * * * * * * * * * * * * * * * * \n");
				System.out.print("使用功能编号：");
				switch (scan.next()) {
				case "1":
					System.out.println("\n["+"用户管理> 用户注册"+"]");
					this.userAll=UserCom.insertUser(this.userAll);
					Common.lock();
					break;
				case "2":
					System.out.println("\n["+"用户管理> 用户登录"+"]");
					this.user=UserCom.loginUser(this.userAll);
					Common.lock();
					break;
				case "3":
					System.out.println("\n["+"用户管理> 管理员登录"+"]");
					this.user=UserCom.loginRootUser(this.rootUserAll);
				case "4":
					return this.user;
				case "5":
					System.exit(0);
				default:
					System.out.println("输入错误！请重新输入！");
				}
			}else {
				return this.user;
			}
			
		}
		
	}
	//管理员
	public User rootIdea(User user) {
		// TODO 自动生成的方法存根
		this.user=user;
		while(true) {
			System.out.println("\n* * * * * * * 管理员用户管理 * * * * * * * * \n");
			System.out.println("\t\t1.查看用户");
			System.out.println("\t\t2.删除用户");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出管理员系统");
			System.out.println("\t\t5.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch (scan.next()) {
			case "1":
				System.out.println("\n["+"管理员用户管理> 查看用户"+"]");
				RootUserCom.selectUser(this.userAll,this.user);
				break;
			case "2":
				System.out.println("\n["+"管理员用户管理> 删除用户"+"]");
				this.userAll=RootUserCom.deleteUser(this.userAll,this.user);
				break;
			case "3":
				return this.user;
			case "4":
				System.out.println("退出管理员系统");
				return RootUserCom.exitRoot();
			case "5":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
		}
		
	
	}

}
