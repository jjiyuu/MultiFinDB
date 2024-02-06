package com.multifin.run;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.multifin.view.MultiFinMenu;

public class Run {
	
	public static void main(String[] args) throws IOException, ParseException {
		new MultiFinMenu().mainMenu();
		System.out.println("데이터 초기화 프로그램을 종료합니다.");
	}
}
