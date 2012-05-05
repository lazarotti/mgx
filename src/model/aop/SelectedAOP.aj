package aop;

import javax.persistence.Transient;
import br.com.mgx.entity.*;

public aspect SelectedAOP {
	
	@Transient
	private boolean Selecionavel.select;
	
	public boolean Selecionavel.isSelected(){
		return select;
	}
	
	public void Selecionavel.setSelected(boolean value){
		select = value;
	}
	
	declare parents:br.com.mgx.entity..* implements Selecionavel;	
}