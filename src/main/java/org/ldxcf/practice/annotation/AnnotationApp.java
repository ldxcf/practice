package org.ldxcf.practice.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 */
public class AnnotationApp {
	private AnnotationApp(){
		
	}
	public void setAnnotation() throws ClassNotFoundException{
		Persion p = new Persion();
		p.setId(1222);
		p.setDesciption("asdf");
		String sql = getSQLFrom(p);
		System.out.println(sql);
	}
	private String getSQLFrom(Persion p) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		StringBuffer selectSB = new StringBuffer();
		StringBuffer fromSB = new StringBuffer();
		StringBuffer whereSB = new StringBuffer();
		 Class<?> persionClass = Class.forName("org.ldxcf.practice.annotation.Persion");
		 MyAnnotation  annotation = persionClass.getAnnotation(MyAnnotation.class);
		 String tableName = annotation.table();
		 fromSB.append(" from ").append(tableName);
		 selectSB.append("select ");
		 
		Field[] fields = persionClass.getDeclaredFields();
		Arrays.asList(fields).forEach(f->{
			if(f.isAnnotationPresent(MyColumn.class)){
				MyColumn m = f.getAnnotation(MyColumn.class);
				String columnName = m.value();
				Type t = m.type();
				if(selectSB.length()==0){
					selectSB.append(" ").append(columnName).append(" ");
				}else{
					selectSB.append(",").append(columnName).append(" ");
				}
				try {
					if(f.get(p)!=null){
						StringBuffer temp = new StringBuffer();
						temp.append(" ").append(columnName).append("=");
						if(t==Type.STRING){
							temp.append("'").append(f.get(p)).append("' ");
						}else{
							temp.append(f.get(p)).append(" ");
						}
						if(whereSB.length()==0){
							whereSB.append(" where ").append(temp);
						}else{
							whereSB.append(" and ").append(temp);
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
		return selectSB.toString()+fromSB.toString()+whereSB.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationApp a = new AnnotationApp();
		try {
			a.setAnnotation();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
