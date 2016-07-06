package br.com.gft.digital.bigdata.pocbigdata.model;

public class RestObject {
	private int code;
	private boolean sucess;
	private String message;
	private Object data;

	public RestObject(int code, boolean sucess, String message, Object data) {
		super();
		this.code = code;
		this.sucess = sucess;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
