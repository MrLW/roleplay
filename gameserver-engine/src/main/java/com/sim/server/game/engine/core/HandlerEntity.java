package com.sim.server.game.engine.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) 
public @interface HandlerEntity {
	
	short id() ;
	String desc() ;
}
