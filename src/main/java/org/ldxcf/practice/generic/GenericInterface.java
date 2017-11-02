package org.ldxcf.practice.generic;
/**
 * 泛型接口
 * @author Administrator
 *
 * @param <T>
 * @param <V>
 */
public interface GenericInterface<T,V> {
	public T getValue();
	public void setValue(T t);
	public default boolean isType(T t,V v){
		return false;
	}
}
