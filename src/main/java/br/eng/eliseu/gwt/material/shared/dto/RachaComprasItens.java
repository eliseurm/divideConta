package br.eng.eliseu.gwt.material.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.eng.eliseu.gwt.divideconta.infra.Utils;


@Entity
@Table(name="DIC_RACHACOMPRASITENS")
public class RachaComprasItens implements Serializable{
	
	private static final long serialVersionUID = -6862859190919938476L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_compra")
	private RachaCompras compra;

	private String nome;
	private String email;
	
	private boolean gastou;
	private BigDecimal valorGasto;
	
	private boolean paga;
	private BigDecimal qtdeAdultos;
	private BigDecimal percentualAdultos;
	private BigDecimal qtdeCriancas;
	private BigDecimal percentualCriancas;
	
	private BigDecimal haReceber;
	private BigDecimal haPagar;

	
	public void setaValores( String nome, String email, 
			boolean gastou, Double valorGasto, boolean paga, 
			Double qtdeAdulto, Double percentualAdultos, 
			Double qtdeCriancas, Double percentualCriancas ) {
		
		if (valorGasto == null){
			valorGasto = 0.0;
		}
		if (qtdeAdulto == null){
			qtdeAdulto = 0.0;
		}
		if (percentualAdultos == null){
			percentualAdultos = 0.0;
		}
		if (qtdeCriancas == null){
			qtdeCriancas = 0.0;
		}
		if ( percentualCriancas == null){
			percentualCriancas = 0.0;
		}
		this.setNome(nome);
		this.setEmail(email);
		this.setGastou(gastou);
		this.setValorGasto(BigDecimal.valueOf(valorGasto));
		this.setPaga(paga);
		this.setQtdeAdultos(BigDecimal.valueOf(qtdeAdulto));
		this.setPercentualAdultos(BigDecimal.valueOf(percentualAdultos));
		this.setQtdeCriancas(BigDecimal.valueOf(qtdeCriancas));
		this.setPercentualCriancas(BigDecimal.valueOf(percentualCriancas));
	}

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGastou() {
		return gastou;
	}
	public void setGastou(boolean gastou) {
		this.gastou = gastou;
	}
	public BigDecimal getValorGasto() {
		if (valorGasto==null){
			valorGasto = new BigDecimal("0");
		}
		return valorGasto;
	}
	public void setValorGasto(BigDecimal valorGasto) {
		this.valorGasto = Utils.truncaBigDecimal(valorGasto, 2);
	}
	public boolean isPaga() {
		return paga;
	}
	public void setPaga(boolean paga) {
		this.paga = paga;
	}
	public BigDecimal getQtdeAdultos() {
		if (qtdeAdultos==null){
			qtdeAdultos = BigDecimal.valueOf(0);
		}
		return qtdeAdultos;
	}
	public void setQtdeAdultos(BigDecimal qtdeAdultos) {
		if (qtdeAdultos == null){
			qtdeAdultos = BigDecimal.valueOf(0);
		}
		this.qtdeAdultos = qtdeAdultos;
	}
	public BigDecimal getPercentualAdultos() {
		if (percentualAdultos==null){
			percentualAdultos = BigDecimal.valueOf(0);
		}
		return percentualAdultos;
	}
	public void setPercentualAdultos(BigDecimal percentualAdultos) {
		if (percentualAdultos == null){
			percentualAdultos = BigDecimal.valueOf(0);
		}
		this.percentualAdultos = percentualAdultos;
	}
	public BigDecimal getQtdeCriancas() {
		if (qtdeCriancas==null){
			qtdeCriancas = BigDecimal.valueOf(0);
		}
		return qtdeCriancas;
	}
	public void setQtdeCriancas(BigDecimal qtdeCriancas) {
		if (qtdeCriancas == null){
			qtdeCriancas = BigDecimal.valueOf(0);
		}
		this.qtdeCriancas = qtdeCriancas;
	}
	public BigDecimal getPercentualCriancas() {
		if (percentualCriancas==null){
			percentualCriancas = BigDecimal.valueOf(0);
		}
		return percentualCriancas;
	}
	public void setPercentualCriancas(BigDecimal percentualCriancas) {
		if (percentualCriancas == null){
			percentualCriancas = BigDecimal.valueOf(0);
		}
		this.percentualCriancas = percentualCriancas;
	}
	public BigDecimal getHaReceber() {
		if (haReceber==null){
			haReceber = BigDecimal.valueOf(0);
		}
		return haReceber;
	}
	public void setHaReceber(BigDecimal haReceber) {
		this.haReceber = Utils.truncaBigDecimal(haReceber, 2);
	}
	public BigDecimal getHaPagar() {
		if (haPagar==null){
			haPagar = BigDecimal.valueOf(0);
		}
		return haPagar;
	}
	public void setHaPagar(BigDecimal haPagar) {
		this.haPagar = Utils.truncaBigDecimal(haPagar, 2);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RachaCompras getCompra() {
		return compra;
	}
	public void setCompra(RachaCompras compra) {
		this.compra = compra;
	}
}
