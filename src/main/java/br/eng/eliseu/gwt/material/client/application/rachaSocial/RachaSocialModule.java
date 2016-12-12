package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RachaSocialModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
	
        bindPresenter(RachaSocialPresenter.class, RachaSocialPresenter.MyView.class, RachaSocialView.class, RachaSocialPresenter.MyProxy.class);
    }
    
    
}