package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialDoubleBox;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

class RachaSocialView extends ViewImpl implements RachaSocialPresenter.MyView {
    
    interface Binder extends UiBinder<Widget, RachaSocialView> {
    }

    @UiField MaterialWindow winRachaSocial;

    @UiField MaterialTextBox dfNome;
    @UiField MaterialTextBox dfEmail;

    @UiField MaterialCheckBox cbGastou;
    @UiField MaterialDoubleBox dfValorGastou;

    @UiField MaterialCheckBox   cbPagar;
    @UiField MaterialIntegerBox dfAdultos;
    @UiField MaterialIntegerBox dfCriancas;

    
    
    @Inject
    RachaSocialView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        
//        cbGastou.set
        
        winRachaSocial.addOpenHandler(new OpenHandler<Boolean>() {
            @Override
            public void onOpen(OpenEvent<Boolean> event) {
                MaterialToast.fireToast("Opened : " + winRachaSocial.getTitle());
            }
        });

        winRachaSocial.addCloseHandler(new CloseHandler<Boolean>() {
            @Override
            public void onClose(CloseEvent<Boolean> event) {
                MaterialToast.fireToast("Closed : " + winRachaSocial.getTitle());
            }
        });

    }
    
    
    @UiHandler("btnOpenWindow")
    void onOpenWindow(ClickEvent e) {
	limpaFormulario();
	winRachaSocial.open();
    }

    private void limpaFormulario(){
	
        dfNome.setText("");
        dfEmail.setText("");
        
        cbGastou.setValue(false);
        dfValorGastou.setValue(0.0);
        dfValorGastou.setEnabled(false);
        
        cbPagar.setValue(false);
        dfAdultos.setValue(1);
        dfCriancas.setValue(0);
        dfAdultos.setEnabled(false);
        dfCriancas.setEnabled(false);

    }
    
}