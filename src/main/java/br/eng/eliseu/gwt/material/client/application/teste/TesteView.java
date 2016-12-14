package br.eng.eliseu.gwt.material.client.application.teste;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import br.eng.eliseu.gwt.material.shared.dto.RachaSocialItensDto;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.TextColumn;

class TesteView extends Composite implements TestePresenter.MyView {

	interface Binder extends UiBinder<Widget, TesteView> {
	}

	@UiField
	MaterialDataTable<RachaSocialItensDto> table;

	@Inject
	TesteView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	protected void onLoad() {
		super.onLoad();

		TextColumn<RachaSocialItensDto> colID = new TextColumn<RachaSocialItensDto>() {
			@Override
			public String getValue(RachaSocialItensDto object) {
				return String.valueOf(object.getId());
			}
		};

		TextColumn<RachaSocialItensDto> colNome = new TextColumn<RachaSocialItensDto>() {
			@Override
			public String getValue(RachaSocialItensDto object) {
				return object.getNome();
			}
		};

		TextColumn<RachaSocialItensDto> colEmail = new TextColumn<RachaSocialItensDto>() {
			@Override
			public String getValue(RachaSocialItensDto object) {
				return object.getEmail();
			}
		};

		table.addColumn(colID, "ID");
		table.addColumn(colNome, "Nome");
		table.addColumn(colEmail, "e-Mail");

		
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

	@Override
	public void addToSlot(Object slot, IsWidget content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromSlot(Object slot, IsWidget content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		// TODO Auto-generated method stub

	}

}