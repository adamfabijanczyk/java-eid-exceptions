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
import pl.wavesoftware.eid.EidConfigurator;
import pl.wavesoftware.eid.Settings;
import pl.wavesoftware.eid.SettingsProvider;

import java.util.ServiceLoader;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 2018-10-29
 */
final class SettingsProviderImpl implements SettingsProvider {

    private volatile ConfigurableSettings settings;

    @Override
    public Settings getSettings() {
        if (settings == null) {
            settings = doGetSettings();
        }
        return settings;
    }

    /**
     * Configures an Eid library programically.
     *
     * @param configurator a configurator to use to configure Eid library
     * @return a reference to a configurator that can be used to restore
     * previous configuration
     */
    @Override
    public EidConfigurator configure(EidConfigurator configurator) {
        getSettings(); // ensure system settings are loaded
        ConfigurableSettings configuredSettings = settings;
        settings = new SettingsImpl(configuredSettings);
        configurator.configure(settings);
        return new RestoreConfigurator(configuredSettings);
    }

    private synchronized ConfigurableSettings doGetSettings() {
        if (settings == null) {
            return loadSettings();
        }
        return settings;
    }

    private ConfigurableSettings loadSettings() {
        ConfigurableSettings configuration = new SettingsImpl();
        new DefaultEidConfigurator().configure(configuration);
        ServiceLoader<EidConfigurator> configurators =
            ServiceLoader.load(EidConfigurator.class);
        for (EidConfigurator configurator : configurators) {
            configurator.configure(configuration);
        }
        return configuration;
    }

    private static final class RestoreConfigurator
        implements EidConfigurator {
        private final ConfigurableSettings settings;
        RestoreConfigurator(ConfigurableSettings settings) {
            this.settings = settings;
        }

        @SuppressWarnings("ConstantConditions")
        @Override
        public void configure(EidConfiguration configuration) {
            configuration.formatter(settings.getFormatter())
                .uniqueIdGenerator(settings.getIdGenerator())
                .validator(settings.getValidator());
        }
    }
}
