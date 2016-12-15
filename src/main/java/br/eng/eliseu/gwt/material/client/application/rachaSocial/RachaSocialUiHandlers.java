package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import java.util.List;

import com.gwtplatform.mvp.client.UiHandlers;

import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;

public interface RachaSocialUiHandlers extends UiHandlers {

	 public List<RachaSocialItensDto> gravaItensPresenter(RachaSocialItensDto item);

	 public List<RachaSocialItensDto> limpaItensPresenter();


}
