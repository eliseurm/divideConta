package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class RachaSocialView extends ViewImpl implements RachaSocialPresenter.MyView {


    interface Binder extends UiBinder<Widget, RachaSocialView> { }

    @Inject
    RachaSocialView(Binder uiBinder) {
	initWidget(uiBinder.createAndBindUi(this));
    }

}
