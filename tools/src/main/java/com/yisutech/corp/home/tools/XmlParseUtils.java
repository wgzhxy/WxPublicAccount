package com.yisutech.corp.home.tools;

import com.google.common.collect.Maps;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.corp.home.tools.XmlParseUtils
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-05-22 下午12:42
 **/
public class XmlParseUtils {

    /**
     * xml文档转换为Map
     */
    public static Map<String, Object> parseXmlToMap(String xml) {

        Map<String, Object> retMap = Maps.newHashMap();
        try {

            StringReader read = new StringReader(xml);

            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);

            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();

            // 通过输入源构造一个Document
            Document doc = (Document) sb.build(source);
            Element root = doc.getRootElement();// 指向根节点

            List<Element> es = root.getChildren();
            if (es != null && es.size() != 0) {
                for (Element element : es) {
                    retMap.put(element.getName(), element.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retMap;
    }
}
