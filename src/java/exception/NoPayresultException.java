/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Ayemi
 */
public class NoPayresultException extends Exception {

    /**
     * Creates a new instance of <code>NoPayresultException</code> without detail message.
     */
    public NoPayresultException() {
    }


    /**
     * Constructs an instance of <code>NoPayresultException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoPayresultException(String msg) {
        super(msg);
    }
}
