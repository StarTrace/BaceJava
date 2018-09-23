package com.starTrace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		// ★★★★System 类
		
		System.out.println(System.currentTimeMillis());						// 系统时间
		
		Properties pts = System.getProperties();							// 获取系统平台参数
		try {
			PrintStream out = new PrintStream("D:\\workSpace\\123.txt");	// 将属性列表输出到制定的输出流
			pts.list(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String ptsStr = pts.toString();
		String [] array = ptsStr.split(","); 			// 拆分数据参数
		System.out.println("\n ★System 类：\n" );
		for(String s : array){
			System.out.println(s);
		}
		
		// ★★★★Runtime 类
		Runtime r = Runtime.getRuntime();
//		try {
//			r.exec("notepad.exe"); // 运行 Windows 的记事本程序
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("\n ★Runtime 类：\n");
		System.out.println("当前处理器数量： " + r.availableProcessors());
		System.out.println("空闲内存数： " + r.freeMemory());
		System.out.println("总内存数： " + r.totalMemory());
		System.out.println("可用最大内存数： " + r.maxMemory()/(1024*1024*1024));
		
		// ★★★★String 类
		String s1 = new String("Hello !");
		String s2 = new String(" World !");
		System.out.println("\n ★String 类: \n");
		System.out.println("0 位 char：" + s1.charAt(0)); 				// 指定下标输出 char
		System.out.println("0 位 unicode：" + s1.codePointAt(0)); 		// 指定下标输出的字符 Unicode 
		System.out.println("2 位前 unicode：" + s1.codePointBefore(2)); 	// 指定下标之前的字符 Unicode
		System.out.println("s1 s2 比较：" + s1.compareTo(s2)); 			// 字典顺序比较字符串
		System.out.println("s1 s2 比较：" + s1.compareToIgnoreCase(s2)); // 字典顺序比较字符串,不考虑大小写
		System.out.println("连接 s1 - s2: " + s1.concat(s2));			// 连接字符串
		System.out.println("s1 包含 ‘ll0’：" + s1.contains("llo")); 		// 包含，true or false
		System.out.println("s1 相同 'ell'：" + s1.contentEquals("ell")); 	// 与制定字符串比较：true or false
		
		char[] data = {'l','l','o','H','r','t','y','u'};
		System.out.println(" data中表示s1的字符串？：" + s1.copyValueOf(data)); 	// 与制定字符串比较：true or false
		System.out.println("s1以‘\\0’结束:"+ s1.endsWith("\0"));				// 以什么结束：ture or false
		System.out.println("s1以‘H’开始："+s1.startsWith("H"));				// 以什么开始：ture or false
		System.out.println("s1 序列- Byte[]'：" + s1.getBytes()); 				// 获得Byte [] 数组序列
		s1.getChars(0,s1.length()< data.length?s1.length():data.length, data, 0);	//	复制到制定数组，不得超过数组长度和字符串长度
		for(char c : data){
			System.out.print(c+" ");
		}		
		System.out.println("\n"+s1.indexOf(0));					//	???
		System.out.println(s1.indexOf("H"));					//	返回制定字符串出现的第一个位置
		System.out.println(s1.lastIndexOf("H"));				//	返回制定字符串出现的最后一个位置
		System.out.println(s1.isEmpty());						//	长度是否位 0：true or false
		for(String s : s1.split("l")){							//	拆分
			System.out.print(" "+s+",");
		}
		System.out.println("\n"+s1.subSequence(0, 3));			// 子序列
		System.out.println(s1.substring(1));					// 子字符串
		System.out.println(s1.substring(1, 2));					// 子字符串
		
		for(char c : s1.toCharArray()){							// 字符数组
			System.out.print(c+" ");
		}
		
		System.out.println("\n"+s1.toLowerCase());				// 小写
		System.out.println(s1.toUpperCase());					// 大写	
		
		System.out.println(s2.trim());							// 副本：忽略前后空白
		
		// ★★★★ StringBuffer 类
		String sss = " my Love ";
		StringBuffer sb1 = new StringBuffer("How are you?");
		System.out.println("★StringBuffer:"+sb1.append(sss));					// 追加字符串 
		
		// ★★★★ Date 类 : 基本已过期
		//	DateFormat 
		System.out.println("★DateFormat 类型：");
		System.out.println(DateFormat.getInstance().format(System.currentTimeMillis()));		// 日期+时间 的格式，格式化一个系统时间
		System.out.println(DateFormat.getDateInstance().format(System.currentTimeMillis()));	// 日期 的格式，格式化一个系统时间
		System.out.println(DateFormat.getTimeInstance().format(System.currentTimeMillis()));	// 时间 的格式，格式化一个系统时间
		// SimpleDateFormat
		/*G 年代标志符
          y 年
          M 月
          d 日
          h 时 在上午或下午 (1~12)
          H 时 在一天中 (0~23)
          m 分
          s 秒
          S 毫秒
          E 星期
          D 一年中的第几天
          F 一月中第几个星期几
          w 一年中第几个星期
          W 一月中第几个星期
          a 上午 / 下午 标记符
          k 时 在一天中 (1~24)
          K 时 在上午或下午 (0~11)
          z 时区
		 */
		SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-dd  hh:mm:ss a 第D天  F w W k K 时区：z");
		System.out.println("★SimpleDateFormat:"+sdate.format(System.currentTimeMillis()));
		// ★★calendar 
		Calendar calendar = Calendar.getInstance();
		System.out.println("★Calendar-GregorianCalendar:"+calendar.get(Calendar.DATE));
		System.out.println("年:"+calendar.get(Calendar.YEAR));
		System.out.println("月:"+calendar.get(Calendar.MONTH));
		System.out.println("日:"+calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("AM-PM:"+calendar.get(Calendar.AM_PM));
		System.out.println("时:"+calendar.get(Calendar.HOUR));
		System.out.println("分:"+calendar.get(Calendar.MINUTE));
		System.out.println("秒:"+calendar.get(Calendar.SECOND));
		System.out.println("星期:"+(Integer.valueOf(calendar.get(Calendar.DAY_OF_WEEK))-1));
		
		calendar.add(Calendar.MONTH, 1);	// add:计算年月日的进位关系，添加时间量	月份+1
		System.out.println(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH));
		calendar.roll(Calendar.MONTH, 1);	// add:不考虑年月日的进位关系，单独添加时间量	月份+1
		System.out.println(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH));
		
	}
 
}
