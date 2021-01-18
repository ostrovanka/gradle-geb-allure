package org.badger.annotation

import groovy.transform.AnnotationCollector
import groovy.util.logging.Slf4j

@AnnotationCollector([Slf4j, LogPublicMethods, AllureStep])
@interface AllureStepLogger {}
