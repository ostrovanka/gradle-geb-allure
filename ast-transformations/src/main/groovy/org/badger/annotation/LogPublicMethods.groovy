package org.badger.annotation

import org.badger.transformation.LogPublicMethodsTransformation
import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.*

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@GroovyASTTransformationClass(classes = [LogPublicMethodsTransformation])
@Inherited
@interface LogPublicMethods {}


