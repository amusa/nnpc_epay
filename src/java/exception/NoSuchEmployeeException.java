/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Ayemi
 */
public class NoSuchEmployeeException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchEmployeeException</code> without detail message.
     */
    public NoSuchEmployeeException() {
        super("No such employee");
    }


    /**
     * Constructs an instance of <code>NoSuchEmployeeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoSuchEmployeeException(String msg) {
        super(msg);
    }
}
