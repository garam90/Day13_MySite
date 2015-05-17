package com.sds.icto.mysite.action.user;

import com.sds.icto.mysite.action.main.IndexAction;
import com.sds.icto.web.Action;

public class UserActionFactory {

	private static UserActionFactory instance;
	static{
		instance = new UserActionFactory();
	}
	private UserActionFactory(){
		
	}
	
	public static UserActionFactory getInstance(){
		if(instance == null){
			instance = new UserActionFactory();
		}
		return instance;
	}
	// /Day05_MySite/user?a=loginform 로그인
	// /Day05_MySite/user?a=joinform 회원가입
	// /Day05_MySite/user?a=uinfo 회원정보수정폼
	// /Day05_MySite/user?a=logout 로그아웃
	// /Day05_MySite/user?a=login 로그인하기
	// /Day05_MySite/user 회원가입하기
	// /Day05_MySite/user?action=update 수정하기
	
	public Action getAction(String action){
		Action act = null;
		if ("join".equals(action)) {
			act = (Action) new InsertAction();
		} else if ("joinform".equals(action)) {
			act = (Action) new JoinFormAction();
		} else if ("loginform".equals(action)){
			act = (Action) new LoginFormAction();
		} else if ("uinfo".equals(action)){
			act = (Action) new UInfoAction();
		} else if ("logout".equals(action)){
			act = (Action) new LogoutAction();
		} else if ("login".equals(action)){
			act = (Action) new LoginAction();
		} else if ("update".equals(action)){
			act = (Action) new UpdateAction();
		} else {
			act = (Action) new IndexAction();
		}
		return act;
	}
}
