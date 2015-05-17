package com.sds.icto.mysite.action.guestbook;

import com.sds.icto.web.Action;

public class GuestActionFactory {

	private static GuestActionFactory instance;
	static{
		instance = new GuestActionFactory();
	}
	private GuestActionFactory(){
		
	}
	
	public static GuestActionFactory getInstance(){
		if(instance == null){
			instance = new GuestActionFactory();
		}
		return instance;
	}
	
	public Action getAction(String action){
		Action act = null;
		if("list".equals(action)){
			act = new listAction();
		} else if ("deleteform".equals(action)) {
			act = new deleteformAction();
		} else if ("delete".equals(action)) {
			act = new deleteAction();
		} else if ("insert".equals(action)) {
			act = new insertAction();
		}  else if ("guestbook".equals(action)) {
			act = new listAction();
		} else {
			act = new listAction();
		}
		return act;
	}
}
