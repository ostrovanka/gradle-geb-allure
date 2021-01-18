package org.badger

import org.junit.Test

class AllureStepAnnotationTest {
    
    final assertScript = new GroovyTestCase().&assertScript
    
    
    @Test
    void 'should_have_step_annotation_on_method'() {
        assertScript """
    import org.badger.annotation.AllureStepLogger
    import io.qameta.allure.Step
    @AllureStepLogger
    class TestClass {
        void testMethod() {}
    }
    TestClass obj=new TestClass()
    assert obj.class.getDeclaredMethod('testMethod').annotations.any {it.annotationType().name==Step.class.name} == true
"""
    }
    
    @Test
    void 'should_not_have_step_annotation_on_method_with_exclude_step'() {
        assertScript """
    import org.badger.annotation.AllureStepLogger
    import io.qameta.allure.Step
    import org.badger.annotation.ExcludeStep
    @AllureStepLogger
    class TestClass {
        @ExcludeStep
        void testMethod() {}
    }
    TestClass obj=new TestClass()
    assert obj.class.getDeclaredMethod('testMethod').annotations.any {it.annotationType().name==Step.class.name} == false
"""
    }
}
