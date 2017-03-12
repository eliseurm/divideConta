package br.eng.eliseu.gwt.material.client.application.testehandles;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import br.eng.eliseu.gwt.material.client.application.ApplicationPresenter;
import br.eng.eliseu.gwt.material.client.place.NameTokens;
public class TesteHandlesPresenter extends Presenter<TesteHandlesPresenter.MyView, TesteHandlesPresenter.MyProxy> implements TesteHandlesUiHandlers {

	 interface MyView extends View, HasUiHandlers<TesteHandlesUiHandlers> {
    }

    @ProxyStandard
    @NameToken(NameTokens.TESTEHANDLES)
    interface MyProxy extends ProxyPlace<TesteHandlesPresenter> {
    }

    @Inject
    TesteHandlesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
        getView().setUiHandlers(this);
    }
    
    
    protected void onReveal() {
        super.onReveal();
    }
    
}