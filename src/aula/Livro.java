package aula;

public class Livro {

	// Cria campos da tabela Livro
	private Long id;
	private String titulo;
	private Double preco;
	private Long editoraId;

	// Cria Getters e Setters
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return the editoraId
	 */
	public Long getEditoraId() {
		return editoraId;
	}

	/**
	 * @param editoraId
	 *            the editoraId to set
	 */
	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}

}
