package com.max.api.execptionjandler;

import java.time.LocalDateTime;
import java.util.List;

public class ProblemException {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;

	public static class Campo {

		private String nomeCampo;
		private String mensagem;

		public Campo(String nomeCampo, String mensagem) {
			super();
			this.nomeCampo = nomeCampo;
			this.mensagem = mensagem;
		}

		public String getNome() {
			return nomeCampo;
		}

		public void setNome(String nome) {
			this.nomeCampo = nome;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
