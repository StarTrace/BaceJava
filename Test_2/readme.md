## 5.3 接口（Interface）
### 5.3.1 接口与类的区别 
>**接口描述：接口是一种规定**  
>默认是抽象的，不需要abstract关键字。
#### 1. 接口与类的<font color=red>相似点</font>  
1）接口可以有任意数量的方法  
2）接口保存为“.java”为后缀的文件，接口名要与文件名匹配  
3）接口编译后是后缀为“.clase”的字节码文件  
4）在包中的接口，相应的字节码文件必须放置在和包名称相匹配的一个目录结构中。
#### 2. 接口与类的<font color=red>不同点</font>    
1）接口不能被实例化  
2）接口不包含任何构造器  
3）接口中所有方法都是抽象的  
4）接口中不能包含实例成员变量。接口中的成员变量必须同时声明为static和final  
5）接口不能被一个类继承，只能被一个类实现  
6）一个接口能够继承多个接口  

	public interface Teach {	-------------- 定义一个接口
		public static final String name; ----- 成员变量必须为static和final
		public void teaching();	-------------- 接口中没有构造器，且方法都是抽象的
	}

><font color=red>抽象类是对类的抽象，是一种约束。  
>接口是对行为的抽象，也是一种约束，必须实现的。</font>  

### 5.3.2 接口的继承      
#### 1. 继承多个接口
1) 接口不是类，可以继承多个父接口。  
2) 接口多继承，关键字extends只使用一次，多个父接口之间用“，”号隔开  
  
	public interface Sport extends Run,Swim{	
	}
>**单继承：** 一个类只能继承一个父类。   
>**多实现：** 接口可以被多个类实现。  
  
#### 2. 标记接口    
**标记接口**：当继承的父接口不包含任何方法的时候。

* 设计宗旨：  
	1) 创建一个通用的父类。  
	2) 给一个类添加数据类型。

		public interface Sport{}
		public interface Run extends Sport{}
### 5.3.3 接口与多态  
接口可以通过多态实现，需要用到向**上转型技术**，和**重写机制**  
   
	public class SportPeople{                   ----------定义一个父类：运动员
		public void sleep(){
			System.out.println("运动员要休息");
		}
	}
	public interface Run {                      ----------定义一个Run接口
		public void run();
	}
	public class RunPeople extends SportPeople implements Run{
		@Override
		public void run() {                 ----------子类继承父类，也实现Run接口的方法
			System.out.println("长跑运动员跑的快");
		}	
	}
	public class Game {
		public void Runshow(Run r1){        ----------设定形参对象
			r1.run();						
		}
	}
	public class Test {
		public static void main(String[] args) {
			Game game = new Game();
			Run r = new RunPeople();    ----------多态的向上类型转换
			game.Runshow(r);
		}
	}
运行结果：
  
	长跑运动员跑的快  
### 5.3.4 接口与抽象的区别  
#### 1. 接口与抽象的相同点：
1）都不能被实例化  
2）都可以包含抽象方法。
#### 2. 接口与抽象的不同点：
1）接口只能包含抽象方法；抽象类可以包含普通方法。  
2）接口不能定义静态方法；抽象类可以定义静态方法。  
3）接口只能定义静态常量属性，不能定义普通属性；抽象类可以定义普通属性，也可以定义静态常量属性  
4）接口不包含构造器；抽象类中可以包含构造器。（抽象类的构造器只是为了让子类调用这些构造器完成属于抽象类的初始化工作）  
5）接口不包含初始化块；抽象类可以包含初始化块。
>**接口定义了一些不同实现类的共享行为。**  
>**接口定义的，不属于对象的方法，就是附加的方法。**  
>**对象自身带有的方法，要定义在抽象类中。**
