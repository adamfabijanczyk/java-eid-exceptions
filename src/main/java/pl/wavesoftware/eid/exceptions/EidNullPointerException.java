/*
 * Copyright (c) 2015 Wave Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.wavesoftware.eid.exceptions;

import pl.wavesoftware.eid.Eid;
import pl.wavesoftware.eid.EidMessage;

import javax.annotation.Nullable;

/**
 * This exception is Eid version of Java's {@link NullPointerException}.
 * <p>
 * <strong>Caution!</strong> This class shouldn't be used in any public API or
 * library. It is designed to be used for in-house development of end user
 * applications which will report bugs in standardized error pages or post them
 * to issue tracker.
 *
 * @see NullPointerException
 * @see EidRuntimeException
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 0.1.0
 */
public class EidNullPointerException extends EidRuntimeException {

    private static final long serialVersionUID = -9876432123423469L;

    /**
     * Constructs a new runtime exception with the specified Exception ID as
     * it's detail message, that's {@code new Eid(eid).toString()}.
     * <p>
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param eid an exception ID as character sequence
     */
    public EidNullPointerException(CharSequence eid) {
        super(eid);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID and
     * detail message.
     * <p>
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param eid     an exception ID as character sequence
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EidNullPointerException(CharSequence eid, String message) {
        super(eid, message);
    }

    /**
     * Constructs a new runtime exception with the specified Eid message.
     * <p>
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the Eid message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EidNullPointerException(EidMessage message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID,
     * detail message and cause.
     *
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not</i> automatically incorporated in this runtime exception's
     * detail message.
     *
     * @param eid     an exception ID as character sequence
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     */
    public EidNullPointerException(
        CharSequence eid,
        String message,
        @Nullable Throwable cause
    ) {
        super(eid, message, cause);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID,
     * detail message and cause.
     *
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not</i> automatically incorporated in this runtime exception's
     * detail message.
     *
     * @param message the Eid message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     */
    public EidNullPointerException(
        EidMessage message,
        @Nullable Throwable cause
    ) {
        super(message, cause);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID and
     * cause.
     * <p>
     * A detail message of <code>eid.toString() + (cause==null ? "" : cause.toString())</code>
     * (which typically contains the class and detail message of
     * <code>cause</code>).
     * <p>
     * This constructor is useful for runtime exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param eid   an exception ID as character sequence
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     */
    public EidNullPointerException(
        CharSequence eid,
        @Nullable Throwable cause
    ) {
        super(eid, cause);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID as
     * it's detail message, that's {@code eid.toString()}.
     * <p>
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param id an exception ID
     */
    public EidNullPointerException(Eid id) {
        super(id);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID and
     * detail message.
     * <p>
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param id      an exception ID
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EidNullPointerException(Eid id, String message) {
        super(id, message);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID,
     * detail message and cause.
     *
     * <p>
     * Note that the detail message associated with <code>cause</code> is
     * <i>not</i> automatically incorporated in this runtime exception's
     * detail message.
     *
     * @param id      an exception ID
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     */
    public EidNullPointerException(
        Eid id,
        String message,
        @Nullable Throwable cause
    ) {
        super(id, message, cause);
    }

    /**
     * Constructs a new runtime exception with the specified Exception ID and
     * cause.
     * <p>
     * A detail message of <code>eid.toString() + (cause==null ? "" : cause.toString())</code>
     * (which typically contains the class and detail message of
     * <code>cause</code>).
     * <p>
     * This constructor is useful for runtime exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param id    an exception ID
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     */
    public EidNullPointerException(
        Eid id,
        @Nullable Throwable cause
    ) {
        super(id, cause);
    }

    /**
     * @return {@link NullPointerException} class
     */
    @Override
    public Class<? extends RuntimeException> getJavaClass() {
        return NullPointerException.class;
    }

}
