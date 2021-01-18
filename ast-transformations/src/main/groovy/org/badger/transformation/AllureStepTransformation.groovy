package org.badger.transformation

import io.qameta.allure.Step
import org.badger.annotation.ExcludeStep
import org.badger.utils.TransformationUtils
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class AllureStepTransformation implements ASTTransformation {
    
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def clazz = astNodes[1] as ClassNode
        def methods = clazz.methods
        methods.each {
            if(it.public && !it.getAnnotations(new ClassNode(Step)) && !it.getAnnotations(new ClassNode(ExcludeStep))) {
                AnnotationNode annot = new AnnotationNode(new ClassNode(Step))
                annot.addMember('value', new ConstantExpression(TransformationUtils.camelCaseToSentence(it.getName())))
                it.addAnnotation(annot)
            }
        }
    }
}
