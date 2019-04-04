/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author luisl
 */
public class MissingRightParenthesisException extends Exception {

    /**
     * Creates a new instance of <code>MissingRightParenthesisException</code>
     * without detail message.
     */
    public MissingRightParenthesisException() {
    }

    /**
     * Constructs an instance of <code>MissingRightParenthesisException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MissingRightParenthesisException(String msg) {
        super(msg);
    }
}
