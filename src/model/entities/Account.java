package model.entities;

import model.exceptions.DomainException;

public class Account {
		
		// Definição dos atributos da classe
	
		private Integer number;
		private String holder;
		private double balance;
		private Double withdrawLimit;
		
		// Construtor com argumentos
		
		public Account(Integer number, String holder, Double initialDeposit, Double withdrawLimit) {
			this.number = number;
			this.holder = holder;
			this.withdrawLimit = withdrawLimit;
			deposit(initialDeposit);
		}

		// Getters e Setters padrão
		
		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}

		public Double getBalance() {
			return balance;
		}

		public Double getWithdrawLimit() {
			return withdrawLimit;
		}

		public void setWithdrawLimit(Double withdrawLimit) {
			this.withdrawLimit = withdrawLimit;
		}
		
		public void deposit(Double amount)
		{
			balance += amount;
		}
		
		// Método para saque na conta onde vemos um pouco de programação defensiva
		// Se o valor a ser sacado for maior que o limite de saque ou valor maior que o saldo na conta
		// é dada uma mensagem de erro especificando o porque daquele erro
		
		public void withdraw(Double amount) throws DomainException
		{
			if(amount > withdrawLimit)
			{
				throw new DomainException("The amount exceeds withdraw limit");
			}
			if(amount > balance)
			{
				throw new DomainException(" Not enough balance");
			}
			
			balance -= amount;
		}
		
		@Override
		public String toString()
		{
			return "New Balance: "
					+String.format("%.2f", balance);
		}
}
