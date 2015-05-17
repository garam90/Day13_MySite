package com.sds.icto.mysite.action.main;

import com.sds.icto.web.Action;

public class ActionFactory {

	private static ActionFactory instance;
	static{
		instance = new ActionFactory();
	}
	private ActionFactory(){
		
	}
	
	public static ActionFactory getInstance(){
		if(instance == null){
			instance = new ActionFactory();
		}
		return instance;
	}
	
	public Action getAction(String action){
		Action act = (Action) new IndexAction();
		if ("form".equals(action)) {

		} else if ("insert".equals(action)) {
		
		} else {
		
		}
		return act;
	}
}
