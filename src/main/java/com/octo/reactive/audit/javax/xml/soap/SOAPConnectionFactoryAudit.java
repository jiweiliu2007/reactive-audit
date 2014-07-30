package com.octo.reactive.audit.javax.xml.soap;

import com.octo.reactive.audit.FileAudit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import static com.octo.reactive.audit.lib.Latency.MEDIUM;

/**
 * Created by pprados on 19/05/2014.
 */
@Aspect
public class SOAPConnectionFactoryAudit extends FileAudit
{
	@Before("call(* javax.xml.soap.SOAPConnectionFactory.createConnection())")
	public void createConnection(JoinPoint thisJoinPoint)
	{
		latency(MEDIUM, thisJoinPoint);
	}
}