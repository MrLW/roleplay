package com.sim.server.game.engine.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import com.sim.server.game.message.request.BaseRequest;

@Component
@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) 
public @interface Regist {

	short id();
	Class<? extends BaseRequest> clazz(); 
}
