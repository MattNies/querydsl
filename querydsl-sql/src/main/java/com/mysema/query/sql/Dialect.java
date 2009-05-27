/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.sql;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.mysema.query.sql.oracle.OracleDialect;
import com.mysema.query.types.operation.Ops;

/**
 * Dialect provides different SQL dialects for querydsl-sql. Querydsl SQL
 * supports the following database systems :
 * <ul>
 * <li>HSQLDB</li>
 * <li>Derby</li>
 * <li>MySQL</li>
 * <li>Oracle</li>
 * <li>PostgreSQL</li>
 * <li>SQL Server</li>
 * </ul>
 * 
 * @author tiwe
 * @version $Id$
 */
public class Dialect {

    // tested
    public static SQLPatterns forHSQLDB() {
        return new SQLPatterns() {
            {
                add(Ops.Math.ROUND, "round(%s,0)");
                add(Ops.TRIM, "trim(both from %s)");
            }
        };
    }

    // tested
    public static SQLPatterns forDerby() {
        return new SQLPatterns() {
            {
                add(Ops.CONCAT, "%s || %s");
                add(Ops.Math.ROUND, "floor(%s)");
                add(Ops.SUBSTR1ARG, "substr(%s,%s+1)");
                add(Ops.SUBSTR2ARGS, "substr(%s,%s+1,%s+1)");

                add(Ops.STARTSWITH, "%s like (%s || '%%')");
                add(Ops.ENDSWITH, "%s like ('%%' || %s)");
                add(Ops.STARTSWITH_IC, "lower(%s) like (lower(%s) || '%%')");
                add(Ops.ENDSWITH_IC, "lower(%s) like ('%%' || lower(%s))");

                add(Ops.DateTime.YEAR, "year(%s)");
                add(Ops.DateTime.MONTH, "month(%s)");

                add(Ops.DateTime.HOUR, "hour(%s)");
                add(Ops.DateTime.MINUTE, "minute(%s)");
                add(Ops.DateTime.SECOND, "second(%s)");
            }
        };
    }

    // tested
    public static SQLPatterns forMySQL() {
        return new SQLPatterns() {
            {
                addClass2TypeMappings("signed", Byte.class, Integer.class,
                        Long.class, Short.class, BigInteger.class);
                addClass2TypeMappings("decimal", Double.class, Float.class,
                        BigDecimal.class);
                addClass2TypeMappings("char(256)", String.class);
            }
        };
    }

    public static SQLPatterns forOracle10() {
        return forOracle();
    }

    // tested
    public static SQLPatterns forOracle() {
        return new OracleDialect();
    }

    // TODO : to be tested
    public static SQLPatterns forPostgreSQL() {
        return new SQLPatterns();
    }

    // TODO : to be tested
    public static SQLPatterns forSQLServer() {
        return new SQLPatterns();
    }

}
