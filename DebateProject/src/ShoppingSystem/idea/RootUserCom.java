package ShoppingSystem.idea;
import java.util.*;

import ShoppingSystem.DataBase.*;

public class RootUserCom {
	private static Scanner scan=new Scanner(System.in);
	//1.查看用户
	public static void selectUser(ArrayList<User> userAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * * * 查找用户系统 * * * * * * * \n");
			System.out.println("\t\t1.查找用户");
			System.out.println("\t\t2.全部用户信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				selectUserSingle(userAll,rootUser);
				Common.lock();
				break;
			case "2":
				selectUserAll(userAll,rootUser);
				Common.lock();
				break;
			case "3":
				return;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入");
			}
		}
		
	}
	//1.1查找用户
	public static void selectUserSingle(ArrayList<User> userAll,User rootUser) {
		String account,transPIN;
		boolean f=true;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				System.out.print("请输入用户的账号：");
				account=scan.next();
				Iterator<User> users=userAll.iterator();
				while(users.hasNext()) {
					User user=(User)users.next();
					if(user.getAccount().equals(account)) {
						f=false;
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("搜索完毕！已找到对应用户！");
						System.out.println("["+"用户名："+user.getUserName()+"\t\t账号："+user.getAccount()+"\t\t密码："+user.getPassword()+"]");
					}
				}
				if(f) {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					System.out.println("查无此人！");
				}
				return;
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		
	}
	//1.2全部用户信息
	public static void selectUserAll(ArrayList<User> userAll,User rootUser) {
		String transPIN;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				Iterator<User> users=userAll.iterator();
				while(users.hasNext()) {
					User user=(User)users.next();
					System.out.println("["+"用户名："+user.getUserName()+"\t\t账号："+user.getAccount()+"\t\t密码："+user.getPassword()+"]");
				}
				return;
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		
	}
	//2.删除用户
	public static ArrayList<User> deleteUser(ArrayList<User> userAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * * * 删除用户系统 * * * * * * * \n");
			System.out.println("\t\t1.清除用户");
			System.out.println("\t\t2.清空用户信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				userAll=deleteUserSingle(userAll,rootUser);
				Common.lock();
				break;
			case "2":
				userAll=deleteUserAll(userAll,rootUser);
				Common.lock();
				break;
			case "3":
				return userAll;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入");
			}
		}
	}
	//2.1清除用户
	public static ArrayList<User> deleteUserSingle(ArrayList<User> userAll,User rootUser) {
		Iterator<User> users=userAll.iterator();
		String account;
		boolean f=true;
		int n=3;
		System.out.println("请输入您要删除的用户对象账号：");
		account=scan.next();
		while(users.hasNext()) {
			User user=(User)users.next();
			if(user.getAccount().equals(account)) {
				f=false;
				System.out.println("用户信息：");
				System.out.println("["+"用户名："+user.getUserName()+"\t\t账号："+user.getAccount()+"\t\t密码："+user.getPassword()+"]");
				System.out.print("确定删除！（Y/N）：");
				if(Common.ifOpt(scan.next())) {
					while(n>=1) {
						System.out.println("输入操作码：");
						if(rootUser.getTransPIN().equals(scan.next())) {
							userAll.remove(user);
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							System.out.println("已删除！");
							return userAll;
						}else {
							System.out.println("输入错误！还有"+(n-1)+"次机会");
							n--;
						}
					}
					System.out.println("已自动退出！");
				}else {
					System.out.println("已取消操作！");
				}
			}
		}
		if(f) {
			System.out.println("查无此人！无法删除！");
		}
		return userAll;
	}
	//2.2清空用户信息
	public static ArrayList<User> deleteUserAll(ArrayList<User> userAll,User rootUser) {
		int n=3;
		System.out.print("确定清除所有用户数据？（Y/N）：");
		if(Common.ifOpt(scan.next())) {
			System.out.print("二次确认（Y/N）：");
			if(Common.ifOpt(scan.next())) {
				while(n>=1) {
					System.out.println("输入操作码：");
					if(rootUser.getTransPIN().equals(scan.next())) {
						userAll.clear();
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("清空完成！");
						return userAll;
					}else {
						System.out.println("输入错误！还有"+(n-1)+"次机会");
						n--;
					}
				}
				System.out.println("已自动退出！");
			}else {
				System.out.println("已取消操作！");
			}
		}else {
			System.out.println("已取消操作！");
		}
		return userAll;
	}
	//4.退出管理员系统
	public static User exitRoot() {
		User user=new User();
		return user;
	}
}
