/**
 * 
 */
package com.dss.exception;

/**
 * @author ADMIN
 *
 */
public class EmployeeException extends RuntimeException {

    private static final long serialVersionUID = 2621112486886026514L;
    private String exceptionMsg;

    public EmployeeException(String exceptionMsg) {
	this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
	return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
	this.exceptionMsg = exceptionMsg;
    }

}
