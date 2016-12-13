package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialDoubleBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;

class RachaSocialView extends ViewWithUiHandlers<RachaSocialUiHandlers> implements RachaSocialPresenter.MyView {

	 interface Binder extends UiBinder<Widget, RachaSocialView> {
	 }

	 @UiField MaterialModal modal;

	 @UiField MaterialTextBox nomeTBox;
	 @UiField MaterialTextBox emailTBox;

	 @UiField MaterialCheckBox gastouCBox;
	 @UiField MaterialDoubleBox valorGastouTBox;

	 @UiField MaterialCheckBox pagarCBox;
	 @UiField MaterialDoubleBox adultosTBox;
	 @UiField MaterialDoubleBox criancasTBox;

	 @Inject
	 RachaSocialView(Binder uiBinder) {
		  initWidget(uiBinder.createAndBindUi(this));

		  // cbGastou.set

		  // winRachaSocial.addOpenHandler(new OpenHandler<Boolean>() {
		  // @Override
		  // public void onOpen(OpenEvent<Boolean> event) {
		  // MaterialToast.fireToast("Opened : " + winRachaSocial.getTitle());
		  // }
		  // });
		  //
		  // winRachaSocial.addCloseHandler(new CloseHandler<Boolean>() {
		  // @Override
		  // public void onClose(CloseEvent<Boolean> event) {
		  // MaterialToast.fireToast("Closed : " + winRachaSocial.getTitle());
		  // }
		  // });

		  
	 }

	 @UiHandler("btnOpenModal")
	 void onOpenModal(ClickEvent e) {
		  modal.open();
	 }

	 @UiHandler("btnCloseModal")
	 void onCloseModal(ClickEvent e) {
		  modal.close();;
	 }

	 private void limpaFormulario() {

		  nomeTBox.setText("");
		  emailTBox.setText("");

		  gastouCBox.setValue(false);
		  valorGastouTBox.setValue(0.0);
		  valorGastouTBox.setEnabled(false);

		  pagarCBox.setValue(false);
		  adultosTBox.setValue(1.0);
		  criancasTBox.setValue(0.0);
		  adultosTBox.setEnabled(false);
		  criancasTBox.setEnabled(false);

	 }

	 @Override
	 public RachaSocialItensDto pegaDadosTela() {
		  RachaSocialItensDto item = new RachaSocialItensDto();

		  item.setaValores(
					 nomeTBox.getValue(), 
					 emailTBox.getValue(), 
					 gastouCBox.getValue(), 
					 valorGastouTBox.getValue(), 
					 pagarCBox.getValue(),
					 adultosTBox.getValue(), 
					 new Double("100"), 
					 criancasTBox.getValue(), 
					 new Double("50"));

		  return item;

	 }

//	 public HasClickHandlers getClickGastouCBox() {
//		  return gastouCBox;
//	 }

	 // Handlers
	 @UiHandler("gastouCBox")
	 void onGastouCBoxClick(ClickEvent event) {
		  if (getUiHandlers() != null) {
				getUiHandlers().onGastouCBoxClick();
		  }
	 }

	 @UiHandler("pagarCBox")
	 void onPagarCBoxClick(ClickEvent event) {
		  if (getUiHandlers() != null) {
				getUiHandlers().onPagarCBoxClick();
		  }
	 }

}