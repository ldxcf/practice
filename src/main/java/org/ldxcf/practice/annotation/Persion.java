package org.ldxcf.practice.annotation;
import static org.ldxcf.practice.annotation.Type.STRING;
import static org.ldxcf.practice.annotation.Type.NUMBER;
@MyAnnotation(description = "persion", table = "Persion")
public class Persion {
	@MyColumn(value="name",type=STRING)
	 String name;
	@MyColumn(value="description",type=STRING)
	 String desciption;
	@MyColumn(value="id",type=NUMBER)
	 long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
