package org.ldxcf.practice.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
/**
 * lambda的简单例子
 * @author Administrator
 *
 */
public class LambdaApp {
	private LambdaApp(){
		
	}
	public void anonmousClass(){
		new Thread(()->System.out.println("lambda")).start(); //匿名函数
	}
	public void sort(){ //更多的用于集合
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		Collections.sort(list, (x,y)->x-y); //排序
		list.forEach(x->System.out.println(x)); //forEach
		//filter
		System.out.println("small than 2-->");
		filter(list,x->x<=2);
	}
	private void filter(List<Integer> list, Predicate<Integer>  object) {
		// TODO Auto-generated method stub
//		list.forEach(x->{
//			if(object.test(x)){
//				System.out.println(x);
//			}
//		});
		list.stream().filter(x->object.test(x)).forEach(x->System.out.println(x));
		int bill =list.stream().map(x->x+4).reduce((sum,cost)->sum+cost).map(m->m-1).orElse(1);
		System.out.println("total value:"+bill);
	}
	public static void main( String[] args ){
		LambdaApp app = new LambdaApp();
//		app.anonmousClass();
		app.sort();
	}
}
