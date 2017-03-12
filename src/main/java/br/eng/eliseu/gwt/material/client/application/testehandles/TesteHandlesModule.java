package br.eng.eliseu.gwt.material.client.application.testehandles;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TesteHandlesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TesteHandlesPresenter.class, TesteHandlesPresenter.MyView.class, TesteHandlesView.class, TesteHandlesPresenter.MyProxy.class);
    }
}