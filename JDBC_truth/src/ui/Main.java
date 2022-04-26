package ui;

import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import test.book;
import test.user;
import test.Impl.SQLHelper;
import test.biz.BookManager;
import test.biz.UserManager;
import test.constants.global;
import test.tool.tool;

public class Main {
	private UserManager userManager = null;
	private BookManager bookManager = null;
	
	public static void main(String[] args) {
		new Main().start();
	}
	/**
	 * 用于初始化系统的一些变量
	 */
	private void init() {
		userManager = new UserManager();
		bookManager = new BookManager();
	}
	private void start() {
		init();
		user user = login();
		global.CURRENTROLE = user.getRole();
		
		while(true) {
			showMenu();
			Scanner in = new Scanner(System.in);
			int opt = in.nextInt();
			
			switch(opt) {
			case 1:  //入库操作
				try {
					entrybook();
				} catch (Exception e) {
					tool.showMessage(e.getMessage());
				}
				

				break;
				
			case 2:  //图书出库
				try {
					outbook();
				} catch (Exception e) {
					tool.showMessage(e.getMessage());
				}
				
				break;
				
			case 3: //图书查询
				try {
					findbook();
				} catch (Exception e) {
					tool.showMessage(e.getMessage());
				}
				break;
				
			case 4: //查看所有库存
				System.out.println("查询书籍成功");
				List<book> books = bookManager.getAllBook();
				if(books.size() == 0) {
					System.out.println("库存无图书");
				}
				else {
					for(book book:books ) {
						System.out.println(book);
					}
				}
				break;
				
			case 5:
				System.out.println(">>>>>>>>>>>>Bye<<<<<<<<<<<<");
				System.exit(0);
			default :
				break;
				
			}
		}
			
		
	}
	private void findbook() {
		System.out.println("请输入想查询的isbn号");
		Scanner out = new Scanner(System.in);
		String isbn = out.next();
		System.out.println("查询书籍成功");
		book book = bookManager.getBookByIsbn(isbn);
		if(book!=null) 	System.out.println(book);
		else System.out.println("查无此输入");
	}
	private void outbook() {
		System.out.println("请输入想删除的isbn号");
		Scanner out = new Scanner(System.in);
		String isbn = out.next();
		boolean isok = bookManager.outBook(isbn);
		if(isok) System.out.println("删除书籍成功");
		else System.out.println("不存在此图书");
	}
	private void entrybook() {
//		bookManager.enterBook(new book("0110-2233-334455","this is java","tom","china-pub",66.88,20));
		bookManager.enterBook(new book("0111-2233-334466","this is c#","jack","china-pub",66.11,10));
		System.out.println("图书入库成功");
	}
	
	private void showMenu() {
		if(global.CURRENTROLE.equals("admin")) {
			System.out.println("请选择操作");
			System.out.println("1.图书入库\t2.图书出库\t3.图书查询\t4.查看所有图书\t5.退出系统");

		}else {
			System.out.println("请选择操作");
			System.out.println("1.图书查询\t2.查看所有图书\t3.退出系统");
		}
		
	}
	private user login(){
		user user = null;
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.print("请输入用户名");
			String userName = input.next();
			System.out.print("请输入密码");
			String passWord = input.next();
			user = userManager.login(userName, passWord);
			if(user==null) {
				System.out.print("账号或密码有误，请重新输入");
				continue;
			}else {
				System.out.print("恭喜登陆成功");
				break;
			}
		
		}
			return user;
	}
}
