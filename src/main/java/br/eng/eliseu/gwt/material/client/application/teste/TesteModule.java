package br.eng.eliseu.gwt.material.client.application.teste;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TesteModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TestePresenter.class, TestePresenter.MyView.class, TesteView.class, TestePresenter.MyProxy.class);
    }
}