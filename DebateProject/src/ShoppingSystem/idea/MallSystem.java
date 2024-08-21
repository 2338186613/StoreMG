package ShoppingSystem.idea;
import java.util.*;

import ShoppingSystem.DataBase.*;

public class MallSystem{
	private Scanner scan=new Scanner(System.in);
	private User user=new User();
	private ArrayList<Mall> mallAll=new ArrayList<Mall>();
	
	public MallSystem() {
		super();
		Mall mall=new Mall("苹果","水果", 10, 100);
		mallAll.add(mall);		
		Mall mall2=new Mall("香蕉","水果", 3.5, 100);
		mallAll.add(mall2);
		Mall mall3=new Mall("葡萄","水果", 14, 100);
		mallAll.add(mall3);
		Mall mall4=new Mall("薯片","零食", 5, 100);
		mallAll.add(mall4);
		Mall mall5=new Mall("辣条","零食", 3, 100);
		mallAll.add(mall5);
		Mall mall6=new Mall("鸡腿", "生鲜", 15, 100);
		mallAll.add(mall6);
		Mall mall7=new Mall("咯咯", "生鲜", 20, 100);
		mallAll.add(mall7);	
	}

	public User idea(User user) {
		// TODO 自动生成的方法存根
		this.user=user;
		while(true) {
			System.out.println("\n* * * * * * * * * 购物商城 * * * * * * * * * \n");
			System.out.println("\t\t1.查看商品");
			System.out.println("\t\t2.添加或修改订单");
			System.out.println("\t\t3.提交订单");
			System.out.println("\t\t4.购物车");
			System.out.println("\t\t5.返回");
			System.out.println("\t\t6.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch (scan.next()) {
			case "1":
				System.out.println("\n["+"购物商城> 查看商品"+"]");
				MallCom.selectMall(this.mallAll);
				Common.lock();
				break;
			case "2":
				System.out.println("\n["+"购物商城> 添加或修改订单"+"]");
				this.user=MallCom.buyMall(this.user, this.mallAll);
				Common.lock();
				break;
			case "3":
				System.out.println("\n["+"购物商城> 提交订单"+"]");
				this.user=MallCom.subMall(this.user, this.mallAll);
				Common.lock();
				break;
			case "4":
				System.out.println("\n["+"购物商城> 购物车"+"]");
				MallCom.mallCart(this.user);
				Common.lock();
				break;
			case "5":
				return this.user;
			case "6":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
					
		}
		
	}
	public User rootIdea(User user) {
		this.user=user;
		while(true) {
			System.out.println("\n* * * * * * * * 管理员商城系统 * * * * * * * \n");
			System.out.println("\t\t1.查看商品信息");
			System.out.println("\t\t2.添加或修改商品信息");
			System.out.println("\t\t3.删除商品信息");
			System.out.println("\t\t4.返回");
			System.out.println("\t\t5.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				System.out.println("\n["+"管理员购物商城> 查看商品信息"+"]");
				RootMallCom.selectMall(mallAll,user);
				break;
			case "2":
				System.out.println("\n["+"管理员购物商城> 添加或修改商品信息"+"]");
				this.mallAll=RootMallCom.inUpMall(mallAll,user);
				break;
			case "3":
				System.out.println("\n["+"管理员购物商城> 删除商品信息"+"]");
				this.mallAll=RootMallCom.deleteMall(mallAll,user);
				break;
			case "4":
				return this.user;
			case "5":
				System.exit(0);
			}
		}
		
	}
}
