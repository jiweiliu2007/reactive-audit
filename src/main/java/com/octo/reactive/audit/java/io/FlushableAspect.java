package com.octo.reactive.audit.java.io;

import com.octo.reactive.audit.FileAudit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import static com.octo.reactive.audit.lib.Latency.HIGH;

/**
 * Created by pprados on 19/05/2014.
 */
@Aspect
public class FlushableAspect extends FileAudit
{
	@Before("call(* java.io.Flushable.flush()) " +
			        "&& !target(java.io.ByteArrayOutputStream) " +
			        "&& !target(java.io.CharArrayWriter)" +
			        "&& !target(java.io.StringWriter)")
	public void advice_high(JoinPoint thisJoinPoint)
	{
		latency(HIGH, thisJoinPoint);
	}

}
