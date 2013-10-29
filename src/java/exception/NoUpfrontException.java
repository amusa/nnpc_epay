/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Ayemi
 */
public class NoUpfrontException extends Exception {

    /**
     * Creates a new instance of <code>NoUpfrontException</code> without detail message.
     */
    public NoUpfrontException() {
    }


    /**
     * Constructs an instance of <code>NoUpfrontException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoUpfrontException(String msg) {
        super(msg);
    }
}
