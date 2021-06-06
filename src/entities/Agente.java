package entities;

public class Agente {
	
	private Integer id;
	private String name;
	private Double salario;
	
	public Agente(Integer id, String name, Double salario) {
		this.id = id;
		this.name = name;
		this.salario = salario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public void increaseSalario(double percentage) {
		salario += salario * percentage / 100.0;
	}
	
	
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salario);
	}

}
