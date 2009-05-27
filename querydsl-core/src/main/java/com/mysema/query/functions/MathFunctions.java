/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.functions;

import com.mysema.query.types.ExprFactory;
import com.mysema.query.types.OperationFactory;
import com.mysema.query.types.SimpleExprFactory;
import com.mysema.query.types.SimpleOperationFactory;
import com.mysema.query.types.expr.ENumber;
import com.mysema.query.types.expr.Expr;
import com.mysema.query.types.operation.Ops;
import com.mysema.query.types.operation.Ops.Math;

/**
 * QMath provides math functions
 * 
 * @author tiwe
 * @version $Id$
 */
public final class MathFunctions {

    private MathFunctions() {
    }

    private static final OperationFactory factory = SimpleOperationFactory.getInstance();

    private static final ExprFactory exprFactory = SimpleExprFactory.getInstance();

    public static <A extends Number & Comparable<?>> ENumber<A> mult(Expr<A> left, A right) {
        return factory.createNumber(left.getType(), Ops.MULT, left, exprFactory.createConstant(right));
    }

    public static <A extends Number & Comparable<?>> ENumber<A> mult(Expr<A> left, Expr<A> right) {
        return factory.createNumber(left.getType(), Ops.MULT, left, right);
    }

    public static <A extends Number & Comparable<?>> ENumber<Double> div(ENumber<A> left, A right) {
        return factory.createNumber(Double.class, Ops.DIV, left, exprFactory.createConstant(right));
    }

    public static <A extends Number & Comparable<?>> ENumber<Double> div(Expr<A> left, Expr<A> right) {
        return factory.createNumber(Double.class, Ops.DIV, left, right);
    }

    public static <A extends Number & Comparable<?>> ENumber<A> add(Expr<A> left, A right) {
        return factory.createNumber(left.getType(), Ops.ADD, left, exprFactory.createConstant(right));
    }

    public static <A extends Number & Comparable<?>> ENumber<A> add(Expr<A> left, Expr<A> right) {
        return factory.createNumber(left.getType(), Ops.ADD, left, right);
    }

    public static <A extends Number & Comparable<?>> ENumber<A> sub(Expr<A> left, A right) {
        return factory.createNumber(left.getType(), Ops.SUB, left, exprFactory.createConstant(right));
    }

    public static <A extends Number & Comparable<?>> ENumber<A> sub(Expr<A> left, Expr<A> right) {
        return factory.createNumber(left.getType(), Ops.SUB, left, right);
    }

    public static <A extends Number & Comparable<?>> ENumber<A> abs(Expr<A> left) {
        return factory.createNumber(left.getType(), Math.ABS, left);
    }

    public static ENumber<Double> acos(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.ACOS, left);
    }

    public static ENumber<Double> asin(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.ASIN, left);
    }

    public static ENumber<Double> atan(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.ATAN, left);
    }

    public static ENumber<Double> ceil(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.CEIL, left);
    }

    public static ENumber<Double> cos(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.COS, left);
    }

    public static ENumber<Double> exp(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.EXP, left);
    }

    public static ENumber<Double> floor(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.FLOOR, left);
    }

    public static ENumber<Double> log(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.LOG, left);
    }

    public static ENumber<Double> log10(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.LOG10, left);
    }

    public static <A extends Number & Comparable<?>> ENumber<A> max(Expr<A> left, Expr<A> right) {
        return factory.createNumber(left.getType(), Math.MAX, left, right);
    }

    public static <A extends Number & Comparable<?>> ENumber<A> min(Expr<A> left, Expr<A> right) {
        return factory.createNumber(left.getType(), Math.MIN, left, right);
    }

    public static ENumber<Double> pow(Expr<Double> left, Expr<Double> right) {
        return factory.createNumber(left.getType(), Math.POWER, left, right);
    }

    public static ENumber<Double> random() {
        return factory.createNumber(Double.class, Math.RANDOM);
    }

    public static ENumber<Double> round(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.ROUND, left);
    }

    public static ENumber<Double> sin(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.SIN, left);
    }

    public static <A extends Number & Comparable<?>> ENumber<Double> sqrt(Expr<A> left) {
        return factory.createNumber(Double.class, Math.SQRT, left);
    }

    public static ENumber<Double> tan(Expr<Double> left) {
        return factory.createNumber(left.getType(), Math.TAN, left);
    }

}
