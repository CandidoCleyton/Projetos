package br.net.cleytoncandido.arquivar.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean
public class MenuBean {

	public String getItemCssClass(String viewId) {
		FacesContext context = FacesContext.getCurrentInstance();
		String currentViewId = context.getViewRoot().getViewId();
		
		viewId = "/" + viewId + ".xhtml";
		
		return currentViewId.equals(viewId) ? "is-selected" : null;
	}
	
}
