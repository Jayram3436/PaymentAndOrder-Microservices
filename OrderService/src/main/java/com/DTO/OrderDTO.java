package com.DTO;

public class OrderDTO {

    private String msg;
    
    private String TransactionId;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	@Override
	public String toString() {
		return "OrderDTO [msg=" + msg + ", TransactionId=" + TransactionId + "]";
	}
    
}
