package XML.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup对象功能
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        // 2 ：获取Document对象，根据xml文档获取
            // 2.1：获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
            // 2.2：解析xml文档，加载文档进内存，获取dom树--> Document对象
        System.out.println("-----------------1-常用----------------");
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        System.out.println("---------------2-不常用--------------");
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "\n" +
                "    <student number=\"heima_0001\">\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>11</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "\n" +
                "    <student number=\"heima_0002\">\n" +
                "        <name>lisi</name>\n" +
                "        <age>11</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "\n" +
                "</students>";
        Document document1 = Jsoup.parse(str);
        System.out.println(document1);
        System.out.println("---------------3-爬虫--------------");
        // 代表网络中的资源路径
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document document2 = Jsoup.parse(url, 10000);
        System.out.println(document2);
    }
}
