package com.idemia.hiring.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;

import com.idemia.hiring.exception.FieldErrorDTO;

@JsonInclude(value=Include.NON_NULL)
public class ResponseEnvelope {
	private  boolean success;
	private Object data;
	private String path;
	private String message;
	private List< FieldErrorDTO > errors;

	public ResponseEnvelope() {}

	public ResponseEnvelope(Object body,String message,String path) {
		this.success=true;
		this.data=body;
		this.message=message;
		this.path=path;
	}

	public void addError(FieldErrorDTO error) {
		if(errors==null)
		{
			errors = new ArrayList< FieldErrorDTO >();
		}
		errors.add(error);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<FieldErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldErrorDTO> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
