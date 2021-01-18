package org.badger.transformation

import org.badger.utils.TransformationUtils
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class LogPublicMethodsTransformation implements ASTTransformation {
    
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def clazz = astNodes[1] as ClassNode
        def methods = clazz.methods
        methods.each {
            if(it.public) {
                def code = it.getCode() as BlockStatement
                Statement logStatement = new ExpressionStatement(new MethodCallExpression(new VariableExpression('log'),
                                                                                          'info',
                                                                                          new ArgumentListExpression(new ConstantExpression(
                                                                                              'Executing step: {}'),
                                                                                                                     new ConstantExpression(
                                                                                                                         TransformationUtils.
                                                                                                                             camelCaseToSentence(
                                                                                                                                 it.
                                                                                                                                     getName())))))
                code.statements.add(0, logStatement)
            }
        }
    }
}
