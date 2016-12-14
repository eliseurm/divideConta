package br.eng.eliseu.gwt.material.client.application.teste;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import br.eng.eliseu.gwt.material.client.application.ApplicationPresenter;
import br.eng.eliseu.gwt.material.client.place.NameTokens;
public class TestePresenter extends Presenter<TestePresenter.MyView, TestePresenter.MyProxy>  {
	
    interface MyView extends View  {
    }

    @NameToken(NameTokens.TESTE)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<TestePresenter> {
    }

    @Inject
    TestePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
    }
    
    
}