package com.main;

import java.util.List;

public enum Tag {
	java("java"), inheritance("inheritance"), polymorphism("polymorphism"), collections(
			"collections"), generics("generics"), database("database"), image(
			"image"), nio("nio"), io("io"), nio2("nio2"), sockets("sockets"), debugging(
			"debugging"), android("android"), mysql("mysql");

	private String name;

	private Tag(String name) {
		this.name = name;
	}
	
	public static String getTags(List<Tag> tags ) {
		StringBuilder str = new StringBuilder();
		for(Tag t : tags) {
			str.append(t.name+";");
		}
		return str.toString();
	}
	
}


