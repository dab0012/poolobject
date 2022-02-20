package ubu.gii.dass.c01;

public class DuplicatedInstanceException extends Exception {
	
	private static final long serialVersionUID = 7433920074775250188L;

	public  DuplicatedInstanceException(){
		super("Ya existe esa instancia en el pool.");
	}

}
