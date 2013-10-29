/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Ayemi
 */
public class NoAppraisalException extends Exception {

    /**
     * Creates a new instance of <code>NoAppraisalException</code> without detail message.
     */
    public NoAppraisalException() {
    }


    /**
     * Constructs an instance of <code>NoAppraisalException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoAppraisalException(String msg) {
        super(msg);
    }
}
