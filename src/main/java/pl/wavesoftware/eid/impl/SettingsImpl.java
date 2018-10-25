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

import pl.wavesoftware.eid.EidConfiguration;
import pl.wavesoftware.eid.Formatter;
import pl.wavesoftware.eid.UniqueIdGenerator;
import pl.wavesoftware.eid.Validator;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 2018-10-29
 */
final class SettingsImpl implements ConfigurableSettings {

    private Formatter formatter;
    private UniqueIdGenerator generator;
    @Nullable
    private Validator validator;
    @Nullable
    private Locale locale;

    SettingsImpl() {
        // nothing here
    }

    SettingsImpl(ConfigurableSettings settings) {
        this.formatter = settings.getFormatter();
        this.generator = settings.getIdGenerator();
        this.validator = settings.getValidator();
        this.locale    = settings.getLocale();
    }

    @Override
    public EidConfiguration uniqueIdGenerator(UniqueIdGenerator generator) {
        this.generator = generator;
        return this;
    }

    @Override
    public EidConfiguration formatter(Formatter formatter) {
        this.formatter = formatter;
        return this;
    }

    @Override
    public EidConfiguration locale(Locale locale) {
        this.locale = locale;
        return this;
    }

    @Override
    public EidConfiguration validator(Validator validator) {
        this.validator = validator;
        return this;
    }

    @Override
    public Formatter getFormatter() {
        return formatter;
    }

    @Override
    public UniqueIdGenerator getIdGenerator() {
        return generator;
    }

    @Nullable
    @Override
    public Validator getValidator() {
        return validator;
    }

    @Nullable
    @Override
    public Locale getLocale() {
        return locale;
    }
}
