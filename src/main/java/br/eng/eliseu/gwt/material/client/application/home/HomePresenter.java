/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package br.eng.eliseu.gwt.material.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import br.eng.eliseu.gwt.material.client.application.ApplicationPresenter;
import br.eng.eliseu.gwt.material.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {

	 interface MyView extends View, HasUiHandlers<HomeUiHandlers> {

	 }

	 @ProxyStandard
	 @NameToken(NameTokens.HOME)
	 interface MyProxy extends ProxyPlace<HomePresenter> {
	 }

	 private PlaceManager placeManager;

	 @Inject
	 HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
		  super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		  this.placeManager = placeManager;

		  getView().setUiHandlers(this);
	 }

	 @Override
	 public void chamaTela(String nameToken) {
		  PlaceRequest placeRequest = new PlaceRequest.Builder()
					 .nameToken(nameToken)
					 .build();

		  placeManager.revealPlace(placeRequest);
	 }
}
