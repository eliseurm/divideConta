package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;
import br.eng.eliseu.gwt.material.shared.utils.UtilsClient;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialDoubleBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.Column;
import gwt.material.design.client.ui.table.cell.TextColumn;

class RachaSocialView extends ViewWithUiHandlers<RachaSocialUiHandlers> implements RachaSocialPresenter.MyView {

	 interface Binder extends UiBinder<Widget, RachaSocialView> {
	 }
	 
	 
	 @UiField MaterialContainer container;
	 @UiField MaterialModal modal;

	 @UiField MaterialTextBox nomeTBox;
	 @UiField MaterialTextBox emailTBox;

	 @UiField MaterialCheckBox gastouCBox;
	 @UiField MaterialDoubleBox valorGastouTBox;

	 @UiField MaterialCheckBox pagarCBox;
	 @UiField MaterialDoubleBox adultosTBox;
	 @UiField MaterialDoubleBox criancasTBox;
	 @UiField MaterialDoubleBox criancasPercentualTBox;
	 
	 @UiField MaterialDataTable<RachaSocialItensDto> table;

	 @Inject
	 RachaSocialView(Binder uiBinder) {
		 
		  initWidget(uiBinder.createAndBindUi(this));


		  // winRachaSocial.addOpenHandler(new OpenHandler<Boolean>() {
		  // @Override
		  // public void onOpen(OpenEvent<Boolean> event) {
		  // MaterialToast.fireToast("Opened : " + winRachaSocial.getTitle());
		  // }
		  // });
		  //
//		  modal.addCloseHandler(new CloseHandler<Boolean>() {
//		   @Override
//		   public void onClose(CloseEvent<Boolean> event) {
//		   MaterialToast.fireToast("Closed : " + modal.getTitle());
//		   }
//		   });

		  
	 }

	 
	 
	    @Override
	 public void setUiHandlers(RachaSocialUiHandlers uiHandlers) {
		  super.setUiHandlers(uiHandlers);
		  table = criaColunas(table);
	 }


	 @UiHandler("btnOpenModal")
	 void onOpenModalClick(ClickEvent e) {
//		 limpaFormulario();
//		 modal.open();
		  
//		  table = criaColunas(table);
		 
		  List<RachaSocialItensDto> listaDB = new ArrayList<RachaSocialItensDto>();
		  RachaSocialItensDto item;
		  for(int i = 0; i <= 5; i++){
			  item = new RachaSocialItensDto();
			  item.setaValores("Eliseu", "eliseu@eliseu", true, 100.0, true, 1.0, 100.0, 0.0, 50.0);
			  listaDB.add(item);
		  }
		  table.setRowData(1, listaDB);
		  table.setRedraw(true); 
		  table.refreshView();
		  

	 }
	 
	 @UiHandler("fechaBtn")
	 void onCloseModalClick(ClickEvent e) {
		 modal.close();;
	 }
	 
	 @UiHandler("gravarBtn")
	 void onGravarBtnClick(ClickEvent e) {
		  if (getUiHandlers() != null) {
			  if (checaCampoEmBranco()){
				  getUiHandlers().onGravarBtnClick();
				  modal.close();
				  
			  }
		  }
	 }
	 
	@UiHandler("gastouCBox")
	void onGastouCBoxClick(ClickEvent event) {
		clickCbGastou();
	}

	@UiHandler("pagarCBox")
	void onPagarCBoxClick(ClickEvent event) {
		clickCbPagante();
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
	 
	private void clickCbGastou(){
		if (gastouCBox.getValue()){
			valorGastouTBox.setEnabled(true);
		} else {
			valorGastouTBox.setValue(null);
			valorGastouTBox.setEnabled(false);
		}
	}
	
	private void clickCbPagante(){
		if (pagarCBox.getValue()){
			adultosTBox.setEnabled(true);
			criancasTBox.setEnabled(true);
			criancasPercentualTBox.setEnabled(true);
			criancasPercentualTBox.setValue(50.0);
		} else {
			adultosTBox.setValue(null);
			criancasTBox.setValue(null);
			criancasPercentualTBox.setValue(null);
	
			adultosTBox.setEnabled(false);
			criancasTBox.setEnabled(false);
			criancasPercentualTBox.setEnabled(false);
		}
	}

	 
	private boolean checaCampoEmBranco(){
		boolean temErro = false;
		
		if (nomeTBox.getValue() == ""){
			nomeTBox.setError("O nome de quem fez o gasto deve ser preenchido");
			temErro = true;
		} else {
			nomeTBox.clearErrorOrSuccess();
		}
		if(gastouCBox.getValue()){
			if (UtilsClient.isValidFieldDouble(valorGastouTBox.getValue()) <= 0){
				valorGastouTBox.setError("Informe o valor que foi gasto");
				temErro = true;
			} else {
				valorGastouTBox.clearErrorOrSuccess();
			}
		}
		if (pagarCBox.getValue()){
			int zeroAdulto = UtilsClient.isValidFieldDouble(adultosTBox.getValue());
			int zeroCrianca = UtilsClient.isValidFieldDouble(criancasTBox.getValue());

			if (zeroAdulto <= 0 && zeroCrianca <= 0) {
				if (zeroAdulto <= 0){
					adultosTBox.setError("Informe quantos Adultos");
					temErro = true;
				} else {
					adultosTBox.clearErrorOrSuccess();
				}
				if (zeroCrianca <= 0){
					criancasTBox.setError("Informe quantas CrianÁas");
					temErro = true;
				} else {
					criancasTBox.clearErrorOrSuccess();
				}
				
			}
			
			if (UtilsClient.isValidFieldDouble(criancasPercentualTBox.getValue()) <= 0){
				criancasPercentualTBox.setError("Informe o percentual em relaÁ„o ao adulto");
				temErro = true;
			} else {
				criancasPercentualTBox.clearErrorOrSuccess();
			}
		}
		
		if (!gastouCBox.getValue() && !pagarCBox.getValue()){
			MaterialToast.fireToast("Uma pessoa deve gastar ou pagar alguma coisa.");
			temErro = true;
		} 
		
		if (temErro) {
			MaterialToast.fireToast("Campos com valores invalidos ou em branco.");
		}
		
		return !temErro;
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
		  criancasPercentualTBox.setEnabled(false);
		  
		  nomeTBox.clearErrorOrSuccess();
		  valorGastouTBox.clearErrorOrSuccess();
		  adultosTBox.clearErrorOrSuccess();
		  criancasTBox.clearErrorOrSuccess();
		  criancasPercentualTBox.clearErrorOrSuccess();
	 }


		private MaterialDataTable<RachaSocialItensDto> criaColunas( MaterialDataTable<RachaSocialItensDto> tabela ){
//			tabela.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//
////			Torna a tabela selecionavel
//			final SingleSelectionModel<RachaSocialItensDto> selectionModel = new SingleSelectionModel<RachaSocialItensDto>();
//			tabela.setSelectionModel(selectionModel);
//			selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//				public void onSelectionChange(SelectionChangeEvent event) {
//					selected = selectionModel.getSelectedObject();
//					if (selected != null) {
//						dfNome.setValue(selected.getNome());
//						dfEmail.setValue(selected.getEmail());
//						cbGastou.setValue(selected.isGastou());
//						dfValorGasto.setValue(selected.getValorGasto().doubleValue());
//						clickCbGastou();
//						cbPagante.setValue(selected.isPaga());
//						dfQtdeAdultos.setValue(selected.getQtdeAdultos().doubleValue());
//						dfQtdeCriancas.setValue(selected.getQtdeCriancas().doubleValue());
//						dfPercentualCriancas.setValue(selected.getPercentualCriancas().doubleValue());
//						clickCbPagante();
//						limpaErros();
//					}
//				}
//			});

		
//			TextColumn<RachaSocialItensDto> colID = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return String.valueOf(object.getId());
//				}
//			};

			TextColumn<RachaSocialItensDto> colNome = new TextColumn<RachaSocialItensDto>() {

				@Override
				public String getName() {
					 super.getName();
					 return "Nome";
				}

				@Override
				public String getHeaderWidth() {
					super.getHeaderWidth();
					return "150px";
				}

				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getNome();
				}
				 
			};
//			colNome.setHeaderWidth("150");
//			colNome.setName("Nome");
			
//			TextColumn<RachaSocialItensDto> colEmail = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getEmail();
//				}
//			};
//			
//			Column<RachaSocialItensDto, Boolean> colGastou = new Column<RachaSocialItensDto, Boolean>( new CheckboxCell(true, false)) {
//				@Override
//				public Boolean getValue(RachaSocialItensDto object) {
//					return object.isGastou();
//				}
//			};
//
//			TextColumn<RachaSocialItensDto> colValorGasto = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getValorGasto().toString();
//				}
//			};
//			colValorGasto.setTextAlign(TextAlign.RIGHT);
//			
//			Column<RachaSocialItensDto, Boolean> colPaga = new Column<RachaSocialItensDto, Boolean>( new CheckboxCell(true, false)) {
//				@Override
//				public Boolean getValue(RachaSocialItensDto object) {
//					return object.isPaga();
//				}
//			};
//
//			TextColumn<RachaSocialItensDto> colQtdeAdultos = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getQtdeAdultos().toString();
//				}
//			};
//			colQtdeAdultos.setTextAlign(TextAlign.RIGHT);
//			
//			TextColumn<RachaSocialItensDto> colPercAdultos = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getPercentualAdultos().toString();
//				}
//			};
//			colPercAdultos.setTextAlign(TextAlign.RIGHT);
//			
//			TextColumn<RachaSocialItensDto> colQtdeCriancas = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getQtdeCriancas().toString();
//				}
//			};
//			colQtdeCriancas.setTextAlign(TextAlign.RIGHT);
//			
//			TextColumn<RachaSocialItensDto> colPercCriancas = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getPercentualCriancas().toString();
//				}
//			};
//			colPercCriancas.setTextAlign(TextAlign.RIGHT);
//
//			TextColumn<RachaSocialItensDto> colHaReceber = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getHaReceber().toString();
//				}
//			};
//			colHaReceber.setTextAlign(TextAlign.RIGHT);
//
//			TextColumn<RachaSocialItensDto> colHaPagar = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getHaPagar().toString();
//				}
//			};
//			colHaPagar.setTextAlign(TextAlign.RIGHT);

			

//			tabela.addColumn(colID, "ID");
			tabela.addColumn(colNome, "Nome");
//			tabela.addColumn(colEmail, "e-Mail");
//			tabela.addColumn(colGastou, "Gastou");
//			tabela.addColumn(colValorGasto, "Valor Gasto");
//			tabela.addColumn(colPaga, "Pagante");
//			tabela.addColumn(colQtdeAdultos, "Qtde Adultos");
//			tabela.addColumn(colPercAdultos, "% Adultos");
//			tabela.addColumn(colQtdeCriancas, "Qtde Crian√ßas");
//			tabela.addColumn(colPercCriancas, "% Crian√ßas");
//			tabela.addColumn(colHaReceber, "Ha Receber");
//			tabela.addColumn(colHaPagar, "Ha Pagar");
//
//			tabela.setVisibleRange(0, 5);
			
//			tabela.setWidth("100%");
			
//			tabela.setColumnWidth(colID, 0, Unit.PX);
//			tabela.setColumnWidth(colNome, 150, Unit.PX);
//			tabela.setColumnWidth(colEmail, 0.0, Unit.PX);
//			tabela.setColumnWidth(colGastou, 40, Unit.PX);
//			tabela.setColumnWidth(colValorGasto, 70, Unit.PX);
//			tabela.setColumnWidth(colPaga, 40, Unit.PX);
//			tabela.setColumnWidth(colQtdeAdultos, 50, Unit.PX);
//			tabela.setColumnWidth(colPercAdultos, 0, Unit.PX);
//			tabela.setColumnWidth(colQtdeCriancas, 50, Unit.PX);
//			tabela.setColumnWidth(colPercCriancas, 0, Unit.PX);
//			tabela.setColumnWidth(colHaReceber, 70, Unit.PX);
//			tabela.setColumnWidth(colHaPagar, 70, Unit.PX);

			
			return tabela;
		}

	 
}
