/* package sy.wkutils;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;




public class XmlUtil {
	
	
	

    @SuppressWarnings("unchecked")
    public static <T> T XML2Bean(String input, Class<T> clazz) throws IOException {
        XStream xstream = new XStream(new DomDriver()) {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next){
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName){
                        if (definedIn == Object.class){
                            try {
                                return this.realClass(fieldName) != null;
                            } catch (Exception e){
                                return false;
                            }
                        } else {
                            return super.shouldSerializeMember(definedIn, fieldName);
                        }
                    }
                };
            }

        };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{clazz});
        xstream.alias("xml", clazz);
        //xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(input);
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML
     *            XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     
    public static Map<String, String> xmlToMap(String strXML) throws Exception {

        Map<String, String> data = new HashMap<String, String>();
        DocumentBuilder documentBuilder = XmlUtil.newDocumentBuilder();
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(strXML.getBytes("gbk"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return data;

    }

    *//**
     * 将Map转换为XML格式的字符串
     *
     * @param data
     *            Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     *//*
    public static String mapToXml(Map<String, String> data) throws Exception {
        Document document = XmlUtil.newDocument();
        org.w3c.dom.Element root = document.createElement("root");
        document.appendChild(root);
        for (String key : data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            if(StringUtils.isBlank(value)) {
                continue;
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "gbk");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String output = writer.getBuffer().toString();
            return output;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);

        return documentBuilderFactory.newDocumentBuilder();
    }

    public static Document newDocument() throws ParserConfigurationException {
        return newDocumentBuilder().newDocument();
    }

    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        JSONObject obj = new JSONObject();
        map.put("TRANSCODE", "A001");
        map.put("CITIZEN_CARD_NO", "3104930700800393766");
        String s = XmlUtil.mapToXml(map);
        System.out.println(s);
    }
    
    

}

*/