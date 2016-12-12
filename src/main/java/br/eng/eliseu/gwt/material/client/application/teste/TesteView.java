package br.eng.eliseu.gwt.material.client.application.teste;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class TesteView extends ViewWithUiHandlers<TesteUiHandlers> implements TestePresenter.MyView {
	
    interface Binder extends UiBinder<Widget, TesteView> {
    }

    @UiField SimplePanel main;

    @Inject
    TesteView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    
 // Handlers 
    @UiHandler("saveBtn")
    void onSaveButtonClick(ClickEvent event) {
        if(getUiHandlers() != null) {
            getUiHandlers().onSaveButtonClick();
        }
    }

    @UiHandler("cancelBtn")
    void onCancelButtonClick(ClickEvent event) {
        if(getUiHandlers() != null) {
            getUiHandlers().onCancelButtonClick();
        }
    }
    
}