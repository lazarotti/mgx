package br.com.mgx.helper;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.framework.EntityQuery;

@Name("daoHelper")
public class DaoHelper {
	
	public void cleanDao(EntityHome dao){
		dao.setId(null);
		dao.setInstance(null);
	}
	
	public void persist(EntityHome dao, Object instance){
		dao.setInstance(instance);
		dao.persist();
	}
	
	public void remove(EntityHome dao, Object instance){
		dao.setInstance(instance);
		dao.remove();
	}	

}
