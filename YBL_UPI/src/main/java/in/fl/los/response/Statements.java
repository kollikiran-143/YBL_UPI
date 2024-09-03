package in.fl.los.response;

import java.util.List;

public class Statements {

	private List<BSInfo> bankStatements;

	public List<BSInfo> getBankStatements() {
		return bankStatements;
	}

	public void setBankStatements(List<BSInfo> bankStatements) {
		this.bankStatements = bankStatements;
	}

	@Override
	public String toString() {
		return "Statements [bankStatements=" + bankStatements + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
