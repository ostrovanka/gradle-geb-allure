package org.badger.utils

import org.apache.commons.lang3.StringUtils

class TransformationUtils {
    static String camelCaseToSentence(String source) {
        return StringUtils.splitByCharacterTypeCamelCase(source).collect { it.capitalize() }.join(' ')
    }
}
