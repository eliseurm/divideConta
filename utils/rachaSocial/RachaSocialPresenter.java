package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import br.eng.eliseu.gwt.material.client.application.ApplicationPresenter;
import br.eng.eliseu.gwt.material.client.application.home.HomePresenter;
import br.eng.eliseu.gwt.material.client.place.NameTokens;

public class RachaSocialPresenter extends Presenter<RachaSocialPresenter.MyView, RachaSocialPresenter.MyProxy> {

    interface MyView extends View { }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    RachaSocialPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
	super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }


}
