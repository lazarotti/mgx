package aop;

import org.jboss.seam.Component;
import java.lang.reflect.Field;
import org.jboss.seam.annotations.*;

public aspect InjectEntity{
	
	pointcut inject() : initialization(public br.com.mgx.entity.*.new (..));
	 
	after():inject(){
		Object obj = thisJoinPoint.getThis();
		String valueOfContextVariable = null;
		Boolean createContextVariable=false;

		for(Field field:obj.getClass().getDeclaredFields()){
			if(field.isAnnotationPresent(In.class)){
				In in = field.getAnnotation(In.class);
				
				if(in.value().equals("")){
					valueOfContextVariable = field.getName();
				}else{
					valueOfContextVariable = in.value();
				}	
				
				if(in.create())
					createContextVariable = true;

				field.setAccessible(true);
				
				try {
				  field.set(obj, Component.getInstance(valueOfContextVariable, createContextVariable));
				} catch (IllegalStateException e) {
					System.out.println("Don´t have context active");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
 	}
	
}
