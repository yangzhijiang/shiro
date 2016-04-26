package com.yang.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
    @Test
    public void testHelloWorld(){
    	
    	Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    	SecurityManager securityManager = factory.getInstance();
    	SecurityUtils.setSecurityManager(securityManager);
    	
    	Subject subject = SecurityUtils.getSubject();
    	
    	UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");
    
    	try{
    		subject.login(token);
    	}catch(AuthenticationException e){
    		System.out.println("用户名和密码错误！");
    	}
    	Assert.assertEquals(true, subject.isAuthenticated());
    	subject.logout();
    }
}
