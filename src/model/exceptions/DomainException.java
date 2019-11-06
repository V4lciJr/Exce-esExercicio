package model.exceptions;

// Classe de exceções personalizadas onde a mesma herda os conceitos da classe Exception

public class DomainException extends Exception{

		private static final long serialVersionUID = 1L;
		
		public DomainException(String msg)
		{
			super(msg);
		}
}
