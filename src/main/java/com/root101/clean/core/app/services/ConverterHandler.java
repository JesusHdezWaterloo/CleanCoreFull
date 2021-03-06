/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.clean.core.app.services;

import com.root101.clean.core.exceptions.AlreadyRegisteredService;
import com.root101.clean.core.exceptions.NoneRegisteredService;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ConverterHandler {

    private static ConverterService converterService;

    private ConverterHandler() {
    }

    public static void registerConverterService(ConverterService newService) {
        if (converterService != null) {
            throw new AlreadyRegisteredService("Converter");
        }
        Objects.requireNonNull(newService, "ConverterService can't be null");

        converterService = newService;
    }

    public static ConverterService getLicenceService() {
        if (converterService == null) {
            throw new NoneRegisteredService("Converter");
        }
        return converterService;
    }

    public static <T> T convert(Object objectToConvert, Class<? extends T> convertToClass) throws RuntimeException {
        return converterService.convert(objectToConvert, convertToClass);
    }

    public static <T> List<T> convert(List list, Class<? extends T> convertToClass) throws RuntimeException {
        return converterService.convert(list, convertToClass);
    }

}
