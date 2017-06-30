package jp.co.corporationstorage.form;

import org.hibernate.validator.constraints.NotEmpty;

public class Form {

	@NotEmpty
	private String name;
	@NotEmpty
	private	String text;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


}
