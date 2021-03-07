package br.com.kleytonms.sysChamados.enums;

public enum Status {

	ABERTO("Aberto"), NOVO("Novo"), FECHADO("Fechado"), EM_ATENDIMENTO("Em Atendimento");
	
	private final String name;       

    private Status(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
