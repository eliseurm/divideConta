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
package br.eng.eliseu.gwt.material.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import br.eng.eliseu.gwt.material.client.application.home.HomeModule;
import br.eng.eliseu.gwt.material.client.application.rachaSocial.RachaSocialModule;
import br.eng.eliseu.gwt.material.client.application.testehandles.TesteHandlesModule;

public class ApplicationModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new TesteHandlesModule());
		install(new HomeModule());
		install(new RachaSocialModule());

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);

	}

}
