/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.io.rest.voice.internal;

import java.util.HashSet;
import java.util.Locale;

import org.eclipse.smarthome.core.voice.text.HumanLanguageInterpreter;

/**
 * Mapper class that maps {@link HumanLanguageInterpreter} instanced to their respective DTOs.
 *
 * @author Kai Kreuzer - Initial contribution and API
 *
 */
public class HLIMapper {

    /**
     * Maps a {@link HumanLanguageInterpreter} to an {@link HumanLanguageInterpreterDTO}.
     *
     * @param hli the human language interpreter
     * @param locale the locale to use for the DTO
     *
     * @return the corresponding DTO
     */
    public static HumanLanguageInterpreterDTO map(HumanLanguageInterpreter hli, Locale locale) {
        HumanLanguageInterpreterDTO dto = new HumanLanguageInterpreterDTO();
        dto.id = hli.getId();
        dto.label = hli.getLabel(locale);
        if (hli.getSupportedLocales() != null) {
            dto.locales = new HashSet<String>(hli.getSupportedLocales().size());
            for (Locale l : hli.getSupportedLocales()) {
                dto.locales.add(l.toString());
            }
        }
        return dto;
    }

}