package br.net.cleytoncandido.arquivar.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.net.cleytoncandido.arquivar.model.Arquivo;
import br.net.cleytoncandido.arquivar.repository.Arquivos;
import br.net.cleytoncandido.arquivar.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Arquivo.class)
public class ArquivoConverter implements Converter {

	//@Inject
	private Arquivos arquivos;
	
	public ArquivoConverter() {
		arquivos = CDIServiceLocator.getBean(Arquivos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Arquivo retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = arquivos.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Arquivo arquivo = (Arquivo) value;
			return arquivo.getId() == null ? null : arquivo.getId().toString();
		}
		
		return "";
	}

}
