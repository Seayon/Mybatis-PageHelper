package com.github.pagehelper.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Seayon
 * @BelongProjecet Mybatis-PageHelper
 * @BelongPackage com.github.pagehelper.util
 * @Copyleft 2013-3102
 * @Date 2022/11/17 17:57
 * @Description SqlSafeUtil 工具类的单元测试
 */
@RunWith(Parameterized.class)
public class SqlSafeUtilTest {

    // 参数合法
    public static final boolean VALID = false;

    // 参数不合法
    public static final boolean INVALID = true;

    // 测试参数提供
    @Parameterized.Parameters(name = "{index}: check value({0}) is {1}")
    public static Collection<Object[]> sqlInjectValidTestData() {
        return Arrays.asList(new Object[][]{
                {null, VALID},
                {"", VALID},
                {" ", VALID},
                {"   ", VALID},
                {"insert", VALID},
                {"insert__", VALID},
                {"SELECT aa FROM user", INVALID},
                {"databaseType desc,orderNum desc", INVALID}
        });
    }

    @Parameterized.Parameter(0)
    public String value;

    @Parameterized.Parameter(1)
    public boolean expectedIsValid;

    /*
     * Test method for {@link com.github.pagehelper.util.SqlSafeUtil#isValid(java.lang.String)}.
     */
    @Test
    @Parameterized.Parameters
    public void testValueValid() {
        assertEquals(expectedIsValid, SqlSafeUtil.check(value));
    }

}
