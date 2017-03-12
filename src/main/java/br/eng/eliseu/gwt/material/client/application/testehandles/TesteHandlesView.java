package br.eng.eliseu.gwt.material.client.application.testehandles;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class TesteHandlesView extends ViewWithUiHandlers<TesteHandlesUiHandlers> implements TesteHandlesPresenter.MyView {
	 
    interface Binder extends UiBinder<Widget, TesteHandlesView> {
    }


    @Inject
    TesteHandlesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
}