package org.ldxcf.practice.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericApp {
	private GenericApp() {

	}

	public  <T,M> void getOne(List<T> t,M... args) { //泛型方法
		t.forEach(x -> System.out.printf("%s", x));
		GenericInterface<Integer,Long> gc = new GenericClass<Integer,Long>();
		gc.setValue(1);
		System.out.println(gc.isType(1, (long) 2));
		System.out.println(gc.getValue());
		showKeyValue(gc);
		List<M> list2 = Arrays.asList(args);
		list2.forEach(x->System.out.println(x));
	}

	private void showKeyValue(GenericInterface<?,?> gc){
		System.out.println(gc.getValue());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericApp a = new GenericApp();
		List<String> t = new ArrayList<String>();
		t.add("a");
		t.add("b");
		a.getOne(t,"1","2");
	}
	class GenericClass<T,V> implements GenericInterface<T, V>{ //泛型类
		protected T t;
		public GenericClass(){
			
		}
		public T getValue(){
			return t;
		}
		@SuppressWarnings("unchecked")
		@Override
		public void setValue(Object t) {
			this.t = (T) t;
		}
	}
	@SuppressWarnings("hiding")
	class StringGeneric<String,Long> extends GenericClass<String,Long>{
		public String getValue(){
			return t;
		}
	}
}
