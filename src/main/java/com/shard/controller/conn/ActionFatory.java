package com.shard.controller.conn;

import com.shard.controller.action.member.ShardJoinAction;
import com.shard.controller.action.member.ShardLoginAction;
import com.shard.controller.action.member.ShardLoginIdCheckAction;
import com.shard.controller.action.member.ShardLogoutAction;

public class ActionFatory {
	private ActionFatory() {}
	
	public static ActionFatory instance = new ActionFatory();
	
	public static ActionFatory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("login")) 
			action = new ShardLoginAction();
		else if(command.equals("idCheck")) 
			action = new ShardLoginIdCheckAction();
		else if(command.equals("join"))
			action = new ShardJoinAction();
		else if(command.equals("logout"))
			action = new ShardLogoutAction();
			
		return action;
	}
}
