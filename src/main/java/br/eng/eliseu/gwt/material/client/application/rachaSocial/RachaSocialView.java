package br.eng.eliseu.gwt.material.client.application.rachaSocial;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;
import br.eng.eliseu.gwt.material.shared.utils.UtilsClient;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialDoubleBox;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
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
	 
	 private boolean tabelaCriada = false;

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
	protected void onAttach() {
		super.onAttach();
		if (!tabelaCriada) {
			 criaColunas();
			 tabelaCriada = true;
		}
	}





	@UiHandler("novoItemBtn")
	 void onNovoItemBtnClick(ClickEvent e) {
		 limpaFormulario();
		 modal.open();
	 }
	
	 @UiHandler("excluiItemBtn")
	 void onExcluiItemBtnClick(ClickEvent e) {
		  if (getUiHandlers() != null) {
		  }
	 }

	 @UiHandler("limpaTabelaBtn")
	 void onLimpaTabelaBtnClick(ClickEvent e) {
		  if (getUiHandlers() != null) {
				int n = table.getTotalRows();
				n = table.getSelectedRowModels(false).size();
				n = table.getRowCount();
				n = table.getRowHeight();
//				table.selectAllRows(true);
		  }
	 }

	 
	 
	 @UiHandler("fechaBtn")
	 void onCloseModalClick(ClickEvent e) {
		  
		  List<RachaSocialItensDto> listaItens = new ArrayList<RachaSocialItensDto>();
		  RachaSocialItensDto item;
		  for(int i = 0; i <= 5; i++){
				  item = new RachaSocialItensDto();
				  item.setaValores("Eliseu", "eliseu@eliseu", true, 100.0, true, 1.0, 100.0, 0.0, 50.0);
				  listaItens.add(item);
		  }
			
		  table.setRowData(0, listaItens);
		  modal.close();
	 }
	 
	 @UiHandler("gravarBtn")
	 void onGravarBtnClick(ClickEvent e) {
		  if (getUiHandlers() != null) {
			  if (checaCampoEmBranco()){
					
				  table.setRowData(0, getUiHandlers().gravaItensPresenter(pegaDadosTela()) );
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
	 

// --- Outros Metodos	 
	 
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
					criancasTBox.setError("Informe quantas Crianças");
					temErro = true;
				} else {
					criancasTBox.clearErrorOrSuccess();
				}
				
			}
			
			if (UtilsClient.isValidFieldDouble(criancasPercentualTBox.getValue()) <= 0){
				criancasPercentualTBox.setError("Informe o percentual em relação ao adulto");
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
		  valorGastouTBox.setValue(null);
		  valorGastouTBox.setEnabled(false);

		  pagarCBox.setValue(false);
		  adultosTBox.setValue(2.0);
		  criancasTBox.setValue(null);
		  adultosTBox.setEnabled(false);
		  criancasTBox.setEnabled(false);
		  criancasPercentualTBox.setEnabled(false);
		  
		  nomeTBox.clearErrorOrSuccess();
		  valorGastouTBox.clearErrorOrSuccess();
		  adultosTBox.clearErrorOrSuccess();
		  criancasTBox.clearErrorOrSuccess();
		  criancasPercentualTBox.clearErrorOrSuccess();
	 }


		public void criaColunas(){
			 table.getTableTitle().setText("Passoas que dividirão a conta");
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
				public String getValue(RachaSocialItensDto object) {
					return object.getNome();
				}
				 
			};
			colNome.setHeaderWidth("300px");
			
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

			TextColumn<RachaSocialItensDto> colValorGasto = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getValorGasto().toString();
				}
			};
//			colValorGasto.setTextAlign(TextAlign.RIGHT);
			
//			Column<RachaSocialItensDto, Boolean> colPaga = new Column<RachaSocialItensDto, Boolean>( new CheckboxCell(true, false)) {
//				@Override
//				public Boolean getValue(RachaSocialItensDto object) {
//					return object.isPaga();
//				}
//			};

			TextColumn<RachaSocialItensDto> colQtdeAdultos = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getQtdeAdultos().toString();
				}
			};
//			colQtdeAdultos.setTextAlign(TextAlign.RIGHT);
			
			TextColumn<RachaSocialItensDto> colPercAdultos = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getPercentualAdultos().toString();
				}
			};
//			colPercAdultos.setTextAlign(TextAlign.RIGHT);
			
			TextColumn<RachaSocialItensDto> colQtdeCriancas = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getQtdeCriancas().toString();
				}
			};
//			colQtdeCriancas.setTextAlign(TextAlign.RIGHT);
			
//			TextColumn<RachaSocialItensDto> colPercCriancas = new TextColumn<RachaSocialItensDto>() {
//				@Override
//				public String getValue(RachaSocialItensDto object) {
//					return object.getPercentualCriancas().toString();
//				}
//			};
//			colPercCriancas.setTextAlign(TextAlign.RIGHT);

			TextColumn<RachaSocialItensDto> colHaReceber = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getHaReceber().toString();
				}
			};
//			colHaReceber.setTextAlign(TextAlign.RIGHT);

			TextColumn<RachaSocialItensDto> colHaPagar = new TextColumn<RachaSocialItensDto>() {
				@Override
				public String getValue(RachaSocialItensDto object) {
					return object.getHaPagar().toString();
				}
			};
//			colHaPagar.setTextAlign(TextAlign.RIGHT);

			

//			table.addColumn(colID, "ID");
			table.addColumn(colNome, "Nome");
//			table.addColumn(colEmail, "e-Mail");
//			table.addColumn(colGastou, "Gastou");
			table.addColumn(colValorGasto, "Valor Gasto");
//			table.addColumn(colPaga, "Pagante");
			table.addColumn(colQtdeAdultos, "Qtde Adultos");
			table.addColumn(colPercAdultos, "% Adultos");
			table.addColumn(colQtdeCriancas, "Qtde CrianÃ§as");
//			table.addColumn(colPercCriancas, "% CrianÃ§as");
			table.addColumn(colHaReceber, "Ha Receber");
			table.addColumn(colHaPagar, "Ha Pagar");

			table.setVisibleRange(0, 5);
			
//			tabela.setWidth("100%");
			
//			// --- passa aqui sempre que selecinar uma linha
			table.addRowSelectHandler((e, model, elem, selected) -> {
	            updateSelectedRows(table.getSelectedRowModels(false).size());
	            GWT.log(e.getType() + " " + model.getNome() + ": " + selected);
	            return true;
	        });
//			
//			table.addSelectAllHandler((e, models, elems, selected) -> {
//	            updateSelectedRows(table.getSelectedRowModels(false).size());
//	            GWT.log("Selected["+selected+"]: " + models.size() + " models");
//	            return true;
//	        });
			
			
		}

		private void updateSelectedRows(int size) {
	        String word = " item ";
	        if(size > 1) {
	            word = " items ";
	        }
	        if(size <= 0) {
	            table.getTableTitle().setText("Table Title");
	            table.getScaffolding().getTopPanel().removeStyleName("active-header");
	        }else {
	            table.getScaffolding().getTopPanel().addStyleName("active-header");
	            table.getTableTitle().setText(size + word + "selected ");
	        }
	    }
	 
}
