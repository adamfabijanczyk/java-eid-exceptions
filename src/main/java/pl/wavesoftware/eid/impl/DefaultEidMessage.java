/*
 * Copyright (c) 2018 Wave Software
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

package pl.wavesoftware.eid.impl;

import pl.wavesoftware.eid.Eid;
import pl.wavesoftware.eid.EidContainer;
import pl.wavesoftware.eid.EidMessage;
import pl.wavesoftware.eid.Formatter;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 2.0.0
 */
public class DefaultEidMessage implements EidMessage, Serializable {
    private static final long serialVersionUID = 20181029192322L;

    private final EidRepr repr;

    public DefaultEidMessage(
        Eid eid,
        Formatter formatter,
        CharSequence messageFormat,
        Object[] arguments
    ) {
        this.repr = new EidRepr(
            eid,
            new TextMessage(messageFormat, arguments),
            formatter
        );
    }

    @Override
    public int length() {
        return repr.get().length();
    }

    @Override
    public char charAt(int index) {
        return repr.get().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return repr.get().subSequence(start, end);
    }

    @Override
    public Eid getEid() {
        return repr.getEid();
    }

    @Override
    public String toString() {
        return repr.get();
    }

    @Override
    public CharSequence getFormattedMessage() {
        return repr.getTextMessage().get();
    }

    private static final class EidRepr implements EidContainer, Serializable {
        private static final long serialVersionUID = 20181029231519L;

        private final Eid eid;
        private final TextMessage textMessage;
        private transient Formatter formatter;
        private String actual;

        private EidRepr(
            Eid eid,
            TextMessage textMessage,
            Formatter formatter
        ) {
            this.eid = eid;
            this.textMessage = textMessage;
            this.formatter = formatter;
        }

        @Override
        public Eid getEid() {
            return eid;
        }

        private TextMessage getTextMessage() {
            return textMessage;
        }

        private String get() {
            if (actual == null) {
                actual = doGet();
                formatter = null;
            }
            return actual;
        }

        private synchronized String doGet() {
            if (actual == null) {
                return formatter.format(eid, textMessage.get());
            }
            return actual;
        }

        /**
         * Ensures that the value is evaluated before serialization.
         *
         * @param stream An object serialization stream.
         * @throws java.io.IOException If an error occurs writing to the stream.
         */
        private void writeObject(ObjectOutputStream stream) throws IOException {
            get(); // evaluates the values if it isn't evaluated yet!
            stream.defaultWriteObject();
        }
    }

    private static final class TextMessage implements Serializable {
        private static final long serialVersionUID = 20181029231527L;

        private transient CharSequence messageFormat;
        private transient Object[] arguments;
        private String message;

        private TextMessage(
            CharSequence messageFormat,
            Object[] arguments
        ) {
            this.messageFormat = messageFormat;
            this.arguments = arguments;
        }

        private String get() {
            if (message == null) {
                message = doGet();
                messageFormat = null;
                arguments = null;
            }
            return message;
        }

        private synchronized String doGet() {
            if (message == null) {
                @Nullable
                Locale locale = Eid.getSettingProvider()
                    .getSettings()
                    .getLocale();
                MessageFormat formatter = locale == null
                    ? new MessageFormat(messageFormat.toString())
                    : new MessageFormat(messageFormat.toString(), locale);
                return formatter.format(arguments);
            }
            return message;
        }

        /**
         * Ensures that the value is evaluated before serialization.
         *
         * @param stream An object serialization stream.
         * @throws java.io.IOException If an error occurs writing to the stream.
         */
        private void writeObject(ObjectOutputStream stream) throws IOException {
            get(); // evaluates the values if it isn't evaluated yet!
            stream.defaultWriteObject();
        }
    }
}
