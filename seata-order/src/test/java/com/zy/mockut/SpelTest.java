package com.zy.mockut;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Description
 * @Author zy
 * @Date 2024/12/8 22:57
 **/
public class SpelTest {
    @Test
    public void testSpel(){
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression("#id");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("id",1);
        Object value = expression.getValue(context);
        System.out.println(value);
    }
}
