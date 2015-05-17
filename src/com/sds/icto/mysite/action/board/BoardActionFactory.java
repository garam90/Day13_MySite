package com.sds.icto.mysite.action.board;

import com.sds.icto.web.Action;

public class BoardActionFactory {

	private static BoardActionFactory instance;
	static {
		instance = new BoardActionFactory();
	}

	private BoardActionFactory() {

	}

	public static BoardActionFactory getInstance() {
		if (instance == null) {
			instance = new BoardActionFactory();
		}
		return instance;
	}

	public Action getAction(String action) {
		Action act = null;
		if ("".equals(action)) {
			act = new boardListAction();
		} else if ("search".equals(action)) {
			act = new boardSearchAction();
		} else if ("delete".equals(action)) {
			act = new boardDeleteAction();
		} else if ("insert".equals(action)) {
			act = new boardInsertAction();
		} else if ("insertform".equals(action)) {
			act = new boardInsertFormAction();
		} else if ("detail".equals(action)) {
			act = new boardDetailAction();
		} else if ("updateform".equals(action)) {
			act = new boardUpdateFormAction();
		} else if ("update".equals(action)) {
			act = new boardUpdateAction();
		} else {
			act = new boardListAction();
		}
		return act;
	}
}
