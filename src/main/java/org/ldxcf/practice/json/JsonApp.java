package org.ldxcf.practice.json;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

import ikidou.reflect.TypeBuilder;

public class JsonApp {
	private JsonApp() {

	}

	public void json() {
		String json = "{\"code\":\"0\",\"message\":\"success\",\"data\":\"Android\"}";
		String json1 = "{\"code\":\"0\",\"message\":\"success\",\"data\":[\"Android\",\"Java\",\"PHP\"]}";
		Gson gson = new Gson();
		Type StringType = TypeBuilder.newInstance(Pojo.class).addTypeParam(String.class).build();
		Type ListStringType = TypeBuilder.newInstance(Pojo.class).beginSubType(List.class).addTypeParam(String.class)
				.endSubType().build();
		Pojo<String> pojo1 = gson.fromJson(json, StringType);
		Pojo<List<String>> pojo3 = gson.fromJson(json1, ListStringType);
		System.out.println(pojo1.getData());
		pojo3.getData().forEach(System.out::println);
		/////////////////////////////////////////////////
		Pojo<String> pojo4 = new Pojo();
		pojo4.setName("aaa");
		pojo4.setDesc("bbb");
		pojo4.setData("ccc");
		gson.toJson(pojo4, System.out);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonApp a = new JsonApp();
		a.json();
	}

}
