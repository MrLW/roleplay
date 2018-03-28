package com.sim.server.game.data.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sim.server.game.data.service.UserService;

@Controller
public class DBServerHandler implements Runnable{

	@Autowired
	private UserService userService;
	
	public void run() {
	}

}
