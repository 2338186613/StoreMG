package ShoppingSystem.idea;
import java.util.*;

import ShoppingSystem.DataBase.*;


public class RootMallCom {
	private static Scanner scan=new Scanner(System.in);
	//1.查看商品信息
	public static void selectMall(ArrayList<Mall> mallAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * 查找商品信息系统 * * * * * * * \n");
			System.out.println("\t\t1.查找商品");
			System.out.println("\t\t2.全部商品信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				selectMallSingle(mallAll,rootUser);
				break;
			case "2":
				selectMallAll(mallAll,rootUser);
				Common.lock();
				break;
			case "3":
				return;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
		}
		
	}
	//1.1查找商品
	public static void selectMallSingle(ArrayList<Mall> mallAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * * * 查找商品 * * * * * * * * * \n");
			System.out.println("\t\t1.根据商品名查找信息");
			System.out.println("\t\t2.根据商品类型查找信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				selectMallGoodsName(mallAll,rootUser);
				Common.lock();
				break;
			case "2":
				selectMallGoodsTypes(mallAll,rootUser);
				Common.lock();
				break;
			case "3":
				return;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
		}
		
	}
	//1.1.1根据商品名查找信息
	public static void selectMallGoodsName(ArrayList<Mall> mallAll,User rootUser) {
		String goodsName,transPIN;
		boolean f=true,fOne=true;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				System.out.print("请输入商品名：");
				goodsName=scan.next();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Iterator<Mall> malls=mallAll.iterator();
				while(malls.hasNext()) {
					Mall mall=(Mall)malls.next();
					if(mall.getName().equals(goodsName)) {
						f=false;
						if(fOne) {
							System.out.println("商品名"+"\t\t商品类型"+"\t\t商品价格"+"\t\t商品数量\t");
							fOne=false;
						}
						System.out.println(mall);
					}
				}
				if(f) {
					System.out.println("未查找到该目标商品！");
				}
				return;
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		
	}
	//1.1.2根据商品类型查找信息
	public static void selectMallGoodsTypes(ArrayList<Mall> mallAll,User rootUser) {
		String types,transPIN;
		boolean f=true,fOne=true;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				System.out.print("请输入商品类型：");
				types=scan.next();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Iterator<Mall> malls=mallAll.iterator();
				while(malls.hasNext()) {
					Mall mall=(Mall)malls.next();
					if(mall.getTypes().equals(types)) {
						f=false;
						if(fOne) {
							System.out.println("商品名"+"\t\t商品类型"+"\t\t商品价格"+"\t\t商品数量\t");
							fOne=false;
						}
						System.out.println(mall);
					}
				}
				if(f) {
					System.out.println("未查找到该类型商品！");
				}
				return;
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		
	}
	//1.2全部商品信息
	public static void selectMallAll(ArrayList<Mall> mallAll,User rootUser) {
		String transPIN;
		boolean f=true,fOne=true;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Iterator<Mall> malls=mallAll.iterator();
				while(malls.hasNext()) {
					f=false;
					if(fOne) {
						System.out.println("商品名"+"\t\t商品类型"+"\t\t商品价格"+"\t\t商品数量\t");
						fOne=false;
					}
					Mall mall=(Mall)malls.next();
					System.out.println(mall);
				}
				if(f) {
					System.out.println("该商场暂无商品！");
				}
				return;
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
	}
	//2.添加或修改商品信息
	public static ArrayList<Mall> inUpMall(ArrayList<Mall> mallAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * 添加或修改商品信息系统 * * * * * \n");
			System.out.println("\t\t1.添加商品");
			System.out.println("\t\t2.修改商品信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				mallAll=insertMall(mallAll,rootUser);
				Common.lock();
				break;
			case "2":
				mallAll=updateMall(mallAll,rootUser);
				Common.lock();
				break;
			case "3":
				return mallAll;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
		}
		
	}
	//2.1添加商品
	public static ArrayList<Mall> insertMall(ArrayList<Mall> mallAll,User rootUser) {
		String name,types,transPIN;
		double price,number;
		boolean f;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				while(true) {
					f=true;
					System.out.print("请输入商品名：");
					name=scan.next();
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					Iterator<Mall> malls=mallAll.iterator();
					while(malls.hasNext()) {
						Mall mall=(Mall)malls.next();
						if(mall.getName().equals(name)) {
							f=false;
							System.out.print("您添加的商品已存在！是否重新添加？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								break;
							}else {
								return mallAll;
							}
						}
					}
					if(f) {
						System.out.print("商品可添加！是否继续？（Y/N）：");
						if(Common.ifOpt(scan.next())) {
							System.out.print("请输入商品类型：");
							types=scan.next();
							System.out.print("请输入商品价格：");
							price=scan.nextDouble();
							System.out.print("请输入商品数量：");
							number=scan.nextDouble();
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							Mall mall=new Mall(name,types,price,number);
							mallAll.add(mall);
							System.out.println("添加成功！");
							System.out.print("是否继续添加？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								
							}else {
								return mallAll;
							}
						}else {
							return mallAll;
						}
					}
					
				}
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		return mallAll;
		
	}
	//2.2修改商品信息
	public static ArrayList<Mall> updateMall(ArrayList<Mall> mallAll,User rootUser) {
		String name,types,transPIN;
		double price,number;
		boolean f;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				while(true) {
					f=true;
					System.out.print("请输入要修改信息的商品名：");
					name=scan.next();
					Iterator<Mall> malls=mallAll.iterator();
					while(malls.hasNext()) {
						Mall mall=(Mall)malls.next();
						if(mall.getName().equals(name)) {
							f=false;
							System.out.print("商品可修改！是否继续？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								while(true) {
									System.out.println("\n* * * * * * * * * 修改商品 * * * * * * * * * \n");
									System.out.println("\t\t1.修改商品类型");
									System.out.println("\t\t2.修改商品单价");
									System.out.println("\t\t3.修改商品数量");
									System.out.println("\t\t4.修改商品全部属性");
									System.out.println("\t\t5.取消修改");
									System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
									System.out.print("使用功能编号：");
									switch(scan.next()) {
									case "1":
										System.out.print("请输入要修改的商品类型：");
										types=scan.next();
										mall.setTypes(types);
										System.out.println("修改成功！");
										break;
									case "2":
										System.out.print("请输入要修改的商品单价：");
										price=scan.nextDouble();
										mall.setPrice(price);
										System.out.println("修改成功！");
										break;
									case "3":
										System.out.print("请输入要修改的商品数量：");
										number=scan.nextDouble();
										mall.setNumber(number);
										System.out.println("修改成功！");
										break;
									case "4":
										System.out.print("请输入要修改的商品类型：");
										types=scan.next();
										System.out.print("请输入要修改的商品单价：");
										price=scan.nextDouble();
										System.out.print("请输入要修改的商品数量：");
										number=scan.nextDouble();
										mall.setTypes(types);
										mall.setPrice(price);
										mall.setNumber(number);
										System.out.println("修改成功！");
										break;
									case "5":
										return mallAll;
									default:
										System.out.println("输入错误！请重新输入！");
									}
									System.out.print("是否继续修改？（Y/N）：");
									if(Common.ifOpt(scan.next())) {
										break;
									}else {
										return mallAll;
									}
								}
							}else {
								System.out.print("已取消！是否继续修改？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									break;
								}else {
									return mallAll;
								}
							}
						}else {
							
						}
						
					}
					if(f) {
						System.out.print("商品不存在，不可修改！是否继续修改？（Y/N）：");
						if(Common.ifOpt(scan.next())) {
							
						}else {
							return mallAll;
						}
					}
				}
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		return mallAll;
		
		
	}
	//3.删除商品信息
	public static ArrayList<Mall> deleteMall(ArrayList<Mall> mallAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * 删除商品信息系统 * * * * * * * \n");
			System.out.println("\t\t1.删除商品");
			System.out.println("\t\t2.清空商品信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				mallAll=deleteMallSingle(mallAll,rootUser);
				break;
			case "2":
				mallAll=deleteMallAll(mallAll,rootUser);
				Common.lock();
				break;
			case "3":
				return mallAll;
			case "4":
				System.exit(0);
			}
		}
		
	}
	//3.1删除商品信息
	public static ArrayList<Mall> deleteMallSingle(ArrayList<Mall> mallAll,User rootUser) {
		while(true) {
			System.out.println("\n* * * * * * * 删除商品系统 * * * * * * * \n");
			System.out.println("\t\t1.根据商品名删除信息");
			System.out.println("\t\t2.根据商品类型删除信息");
			System.out.println("\t\t3.返回");
			System.out.println("\t\t4.退出系统");
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * \n");
			System.out.print("使用功能编号：");
			switch(scan.next()) {
			case "1":
				mallAll=deleteMallGoodsName(mallAll,rootUser);
				Common.lock();
				break;
			case "2":
				mallAll=deleteMallTypes(mallAll,rootUser);
				Common.lock();
				break;
			case "3":
				return mallAll;
			case "4":
				System.exit(0);
			default:
				System.out.println("输入错误！请重新输入！");
			}
		}
	}
	//3.1.1根据商品名删除信息
	public static ArrayList<Mall> deleteMallGoodsName(ArrayList<Mall> mallAll,User rootUser) {
		String name,transPIN;
		boolean f;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				while(true) {
					f=true;
					System.out.print("请输入要删除信息的商品名：");
					name=scan.next();
					Iterator<Mall> malls=mallAll.iterator();
					while(malls.hasNext()) {
						Mall mall=(Mall)malls.next();
						if(mall.getName().equals(name)) {
							f=false;
							System.out.print("商品可删除！二次确认是否删除？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								mallAll.remove(mall);
								System.out.println("商品已删除！");
							}else {
								System.out.println("已取消！");
							}
							System.out.print("是否继续删除？（Y/N）：");
							if(Common.ifOpt(scan.next())) {
								break;
							}else {
								return mallAll;
							}
						}
					}
					if(f) {
						System.out.println("查无商品！");
						System.out.print("是否继续删除？（Y/N）：");
						if(Common.ifOpt(scan.next())) {
							
						}else {
							return mallAll;
						}
					}
				}
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		return mallAll;
		
	}
	//3.1.2根据商品类型删除信息
	public static ArrayList<Mall> deleteMallTypes(ArrayList<Mall> mallAll,User rootUser) {
		String types,transPIN;
		boolean f,fOne;
		int n=3,i=0;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				while(true) {
					f=true;
					fOne=true;
					System.out.print("请输入要删除信息的商品类型：");
					types=scan.next();
					Iterator<Mall> malls=mallAll.iterator();
					while(malls.hasNext()) {
						Mall mall=(Mall)malls.next();
						if(mall.getTypes().equals(types)) {
							f=false;
							if(fOne) {
								fOne=false;
								System.out.print("商品可删除！二次确认是否删除？（Y/N）：");
								if(Common.ifOpt(scan.next())) {
									
								}else {
									System.out.println("已取消！");
									System.out.print("是否继续删除？（Y/N）：");
									if(Common.ifOpt(scan.next())) {
										fOne=true;
										break;
									}else {
										return mallAll;
									}
								}
							}
							i++;
						}
					}
					while(i>0) {
						Iterator<Mall> malls2=mallAll.iterator();
						while(malls2.hasNext()) {
							Mall mall=(Mall)malls2.next();
							if(mall.getTypes().equals(types)) {
								mallAll.remove(mall);
								i--;
								break;
							}
						}
					}
					if(!fOne) {
						System.out.println("商品已删除！");	
						System.out.print("是否继续删除？（Y/N）：");
						if(Common.ifOpt(scan.next())) {

						}else {
							return mallAll;
						}
					}
					if(f) {
						System.out.println("查无此类商品！");
						System.out.print("是否继续删除？（Y/N）：");
						if(Common.ifOpt(scan.next())) {
							
						}else {
							return mallAll;
						}
					}
				}
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		return mallAll;

	}
	//3.2清空商品信息
	public static ArrayList<Mall> deleteMallAll(ArrayList<Mall> mallAll,User rootUser) {
		String transPIN;
		int n=3;
		while(n>0) {
			System.out.print("请输入操作码：");
			transPIN=scan.next();
			if(rootUser.getTransPIN().equals(transPIN)) {
				System.out.print("一次确认（Y/N）：");
				if(Common.ifOpt(scan.next())) {
					System.out.print("二次确认（Y/N）：");
					if(Common.ifOpt(scan.next())) {
						mallAll.clear();
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("已删除！");
						return mallAll;
					}else {
						System.out.println("已取消！");
						return mallAll;
					}
				}else {
					System.out.println("已清空！");
					return mallAll;
				}
			}else {
				System.out.println("操作码错误！还剩"+(n-1)+"次机会");
				n--;
			}
		}
		return mallAll;
	}
	
}
