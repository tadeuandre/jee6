package br.nom.penha.bruno.arquiteto.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.nom.penha.bruno.arquiteto.model.Banco;

public class ConversorBanco implements Converter {

    private static final String NOME = "nomeBanco=";
    private static final String ID = "idBanco=";
    
    public ConversorBanco() {
    }

    public Object getAsObject(FacesContext facesContext,
                              UIComponent uIComponent, String novoValor) {        
        StringBuffer texto = new StringBuffer(novoValor);
        int posDescricao = texto.indexOf(NOME);
        int posId = texto.indexOf(ID);
        String nome = texto.substring(posDescricao + NOME.length(), posId-1);
        Integer id = new Integer(texto.substring(posId + ID.length(), texto.length()));        
        return new Banco(id,nome);
    }

    public String getAsString(FacesContext facesContext,
                              UIComponent uIComponent, Object object) {                              
        Banco banco= (Banco)object;
        return NOME+banco.getNome()+"&"+ID+banco.getId();

    }
}
