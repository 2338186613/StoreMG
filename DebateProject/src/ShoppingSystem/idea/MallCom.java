package ShoppingSystem.idea;
import java.util.*;

import ShoppingSystem.DataBase.*;

public class MallCom {
	private static Scanner scan=new Scanner(System.in);
	//1.查看商品
	public static void selectMall(ArrayList<Mall> mallAll) {
		Iterator<Mall> malls=mallAll.iterator();
		System.out.println("商品名\t\t"+"商品类型\t\t"+"单价\t\t"+"数量\t");
		while(malls.hasNext()) {
			Mall mall=(Mall)malls.next();
			System.out.println(mall);
		}
	}
	//2.添加或修改订单
	public static User buyMall(User user,ArrayList<Mall> mallAll) {
		if(!Common.LoginChecking(user)) {
			System.out.println("您没有登陆，请登录后重试！");
			return user;
		}
		String name;
		double number;
		boolean mallF,iniF;
		while(true) {
			mallF=true;//商店中是否存在该商品
			iniF=true;//购物车是否为空
			System.out.println("商品：");
			selectMall(mallAll);
			System.out.print("请输入您要购买的商品名：");
			name=scan.next();
			System.out.print("请输入您要购买的数量：");
			while(true) {
				if(scan.hasNextDouble()) {
					number=scan.nextDouble();
					break;
				}else {
					System.out.print("请输入正确的数量！是否继续输入？（Y/N）：");
					if(Common.ifOpt(scan.next())) {
						
					}else {
						return user;
					}
				}
			}

			Iterator<Mall> malls=mallAll.iterator();
			while(malls.hasNext()) {
				Mall mall=(Mall)malls.next();
				if(mall.getName().equals(name)) {
					mallF=false;
					Iterator<Cart> carts=user.getCartList().iterator();
					while(carts.hasNext()) {
						iniF=false;
						Cart cart=(Cart)carts.next();
						if(cart.getName().equals(name)) {
							if(number<=mall.getNumber()) {
								System.out.print("您的购物车存在该商品，是否覆盖（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									cart.setNumber(number);
									//cartAll.remove(cart); 删除
									System.out.println("已加入购物车！");
									System.out.print("是否继续购买？（Y/N）");
									if(Common.ifOpt(scan.next())) {
										break;
									}else {
										return user;
									}
								}else {
									System.out.println("已取消！");
									break;
								}
							}else {
								System.out.println("商品数量不足！");
								break;
							}
						}else {
							if(number<=mall.getNumber()) {
								System.out.print("您的购物车不存在该商品，是否添加进购物车？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									Cart addCart=new Cart(name,mall.getTypes(),mall.getPrice(),number);
									user.setCart(addCart);
									System.out.println("已加入购物车！");
									System.out.print("是否继续购买？（Y/N）");
									if(Common.ifOpt(scan.next())) {
										break;
									}else {
										return user;
									}
								}else {
									System.out.println("已取消！");
									break;
								}
							}else {
								System.out.println("商品数量不足！");
								System.out.print("是否继续购买？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									break;
								}else {
									return user;
								}
							}
						}
					}
					if(iniF) {
						if(number<mall.getNumber()) {
							System.out.print("购物车为空，是否添加为您的第一个商品？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								Cart addCart=new Cart(name,mall.getTypes(),mall.getPrice(),number);
								user.setCart(addCart);
								System.out.println("已加入购物车！");
								System.out.print("是否继续购买？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									break;
								}else {
									return user;
								}
							}else {
								System.out.println("已取消！");
								System.out.print("是否继续购买？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									break;
								}else {
									return user;
								}
							}
						}else {
							System.out.println("商品数量不足！");
							System.out.print("是否继续购买？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								break;
							}else {
								return user;
							}
						}
					}	
				}
			}
			if(mallF) {
				System.out.print("无此商品！是否需要重新购买？（Y/N）：");
				if(Common.ifOpt(scan.next())) {
					
				}else {
					return user;
				}
			}
		}
		
	}
	//3.提交订单
	public static User subMall(User user,ArrayList<Mall> mallAll) {
		double totalPrice=0;
		int n=3;
		if(!Common.LoginChecking(user)) {
			System.out.println("您没有登陆，请登录后重试！");
			return user;
		}
		while(n>=1) {
			System.out.print("请输入您的交易密码：");
			if(user.getTransPIN().equals(scan.next())) {
				Iterator<Cart> carts=user.getCartList().iterator();
				while(carts.hasNext()) {
					Cart cart=(Cart)carts.next();
					Iterator<Mall> malls=mallAll.iterator();
					while(malls.hasNext()) {
						Mall mall=(Mall)malls.next();
						if(cart.getName().equals(mall.getName())) {
							if(cart.getNumber()<=mall.getNumber()) {
								totalPrice+=cart.getNumber()*cart.getPrice();
								mall.setNumber(mall.getNumber()-cart.getNumber());
								cart.setNumber(0);
							}else {
								System.out.println("商店的"+mall.getName()+"数量不足，已结算排除！");
							}
						}else {
							
						}
					}
				}
				break;
			}else {
				System.out.println("您输入的交易密码有误，还剩下"+(n-1)+"次机会！");
				n--;
			}
		}
		if(n==0) {
			System.out.println("已强制退出！");
		}
		//删除订单中数量为0的商品
		boolean removeF=true;
		while(removeF) {
			removeF=false;
			Iterator<Cart> carts=user.getCartList().iterator();
			while(carts.hasNext()) {
				Cart cart=(Cart)carts.next();
				if(cart.getName()!=null&&cart.getNumber()==0) {
					user.getCartList().remove(cart);
					removeF=true;
					break;
				}else {
					removeF=false;
				}
			}
		}
		
		System.out.println("购买成功！您本次消费"+totalPrice+"元");
		return user;
		
	}
	//4.购物车
	public static void mallCart(User user) {
		boolean f;
		if(!Common.LoginChecking(user)) {
			System.out.println("您没有登陆，请登录后重试！");
			return;
		}
		Iterator<Cart> cartAll=user.getCartList().iterator();
		f=true;
		while(cartAll.hasNext()) {
			if(f) {
				System.out.println("商品名\t\t"+"商品类型\t\t"+"商品单价\t\t"+"商品数量");
				f=false;
			}
			Cart cart=(Cart)cartAll.next();
			System.out.println(cart);
		}
		if(f) {
			System.out.println("暂无商品");
		}
	}
}
