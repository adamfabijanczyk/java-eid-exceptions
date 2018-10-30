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

package pl.wavesoftware.eid.utils;

import pl.wavesoftware.eid.Eid;

import javax.annotation.Nullable;

/**
 * @author <a href="mailto:krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszynski</a>
 * @since 2018-10-29
 */
final class EidUtil {
    private EidUtil() {
        // nothing here
    }

    static Eid ensureEid(@Nullable Eid eid) {
        if (eid == null) {
            return new Eid("20160329:132823", "EID-NULL");
        }
        return eid;
    }

    static Eid ensureEid(@Nullable String eid) {
        if (eid == null) {
            return new Eid("20160329:133052", "EID-NULL");
        }
        return new Eid(eid);
    }
}
