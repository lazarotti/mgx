package br.com.mgx.converter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

@Name("moneyBrConverter")
@BypassInterceptors
@org.jboss.seam.annotations.faces.Converter
public class MoneyBrConverter implements Converter {

	private DecimalFormat formatter;

	public MoneyBrConverter() {
		formatter = new DecimalFormat("###,###.##");
		formatter.setDecimalFormatSymbols(DecimalFormatSymbols
				.getInstance(new Locale("pt", "BR")));
		formatter.setMinimumFractionDigits(2);
	}

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) {
		Double doubleValue = null;
		if (newValue != null && !newValue.equals("")) {

			try {
				doubleValue = formatter.parse(newValue).doubleValue();
			} catch (ParseException e) {
				throw new ConverterException(e);
			}
		}
		
		return doubleValue;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		
		String stringValue;
	
		try {
			stringValue = formatter.format(value);
		} catch (Exception e) {
			return "";
		}
		return stringValue;
	}
}
