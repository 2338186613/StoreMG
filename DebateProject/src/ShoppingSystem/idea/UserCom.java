package ShoppingSystem.idea;

import java.util.*;

import ShoppingSystem.DataBase.*;

public class UserCom {
	private static Scanner scan=new Scanner(System.in);
	//1.用户注册
	public static ArrayList<User> insertUser(ArrayList<User> userAll) {
		String userName,account,password,transPIN;
		while(true) {
			Iterator<User> userList=userAll.iterator();
			boolean f=true;
			System.out.print("请输入用户名昵称：");
			userName=scan.next();
			System.out.print("请输入账号：");
			account=scan.next();
			System.out.print("请输入密码：");
			password=scan.next();
			System.out.print("请输入交易密码：");
			transPIN=scan.next();
			while(userList.hasNext()) {
				User user=(User)userList.next();
				if(user.getAccount().equals(account)) {
					System.out.print("该账号已存在！是否继续注册？（Y/N）：");
					if(Common.ifOpt(scan.next())) {
						f=false;
						break;
					}else {
						System.out.println("已取消注册！");
						return userAll;
					}	
				}
			}
			if(f) {				
				User user=new User(userName,account,password,transPIN);
				userAll.add(user);
				try {
					Thread.sleep(2000);//延时一秒
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println("注册成功！");
				return userAll;
			}
		}
		
	}
	//2.用户登录
	public static User loginUser(ArrayList<User> userAll) {
		String account,password;
		while(true) {
			Iterator<User> userList=userAll.iterator();
			System.out.print("账号：");
			account=scan.next();
			System.out.print("密码：");
			password=scan.next();
			while(userList.hasNext()) {
				User user=(User)userList.next();
				if(user.getAccount().equals(account)&&user.getPassword().equals(password)) {
					System.out.println("登录成功！");
					return user;
				}
			}
			System.out.print("账号或密码错误!是否重新登录？（Y/N）：");
			if(Common.ifOpt(scan.next())) {
				
			}else {
				System.out.println("已取消登录！");
				User userNull=new User();
				return userNull;
			}
		}	
	}
	//3.管理员登录
	public static User loginRootUser(ArrayList<User> userAll) {
		String account,password;
		while(true) {
			Iterator<User> userList=userAll.iterator();
			System.out.print("账号：");
			account=scan.next();
			System.out.print("密码：");
			password=scan.next();
			while(userList.hasNext()) {
				User user=(User)userList.next();
				if(user.getAccount().equals(account)&&user.getPassword().equals(password)) {
					System.out.println("登录成功！");
					return user;
				}
			}
			System.out.print("用户名或密码错误!是否重新登录？（Y/N）：");
			if(Common.ifOpt(scan.next())) {
				
			}else {
				System.out.println("已取消登录！");
				User userNull=new User();
				return userNull;
			}
		}	
	}
	
}
