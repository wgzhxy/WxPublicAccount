package com.yisutech.corp.home.third_party;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.yisutech.corp.home.tools.result.YisuResult;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		YisuResult<Object> result = new YisuResult<>();
		result.setModel("882eerererewrewerw");
		System.out.println(JSON.toJSONString(result));
	}
}
