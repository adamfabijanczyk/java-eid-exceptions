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

package pl.wavesoftware.eid;

/**
 * A settings provider interface.
 *
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 2.0.0
 */
public interface SettingsProvider {
    /**
     * Gets settings object
     *
     * @return a settings object
     */
    Settings getSettings();

    /**
     * Configures an Eid library programmatically. Note, that method returns a
     * configurator that can be used to restore configuration to the state
     * before you invoke this configuration method.
     *
     * @param configurator a configurator to use to configure Eid library
     * @return a reference to a configurator that can be used to restore
     * previous configuration
     */
    EidConfigurator configure(EidConfigurator configurator);
}
