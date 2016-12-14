package br.eng.eliseu.gwt.material.client.application.rachaSocial;

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
import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;

public class RachaSocialPresenter extends Presenter<RachaSocialPresenter.MyView, RachaSocialPresenter.MyProxy> implements RachaSocialUiHandlers {
    
    interface MyView extends View, HasUiHandlers<RachaSocialUiHandlers>  {
    	public RachaSocialItensDto pegaDadosTela();
    }
    
    private RachaSocialItensDto item = new RachaSocialItensDto();
    
    @ProxyStandard
    @NameToken(NameTokens.RACHA_SOCIAL)
    interface MyProxy extends ProxyPlace<RachaSocialPresenter> {
    }

    @Inject
    RachaSocialPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        
        getView().setUiHandlers(this);
        
    }



	@Override
	public void onGravarBtnClick() {
		
		
	}
    
    
    
}