package XML.Jsoup;
// 1 ：导包
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 2 ：获取Document对象，根据xml文档获取
            // 2.1：获取student.xml的path
                /*
                    JsoupDemo1.class：class文件
                    getClassLoader()：获取类加载器
                    getResource()：找到对应的资源位置
                */
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
            // 2.2：解析xml文档，加载文档进内存，获取dom树--> Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3 :获取元素对象，Element对象，ctrl+鼠标悬停，可以看到Elements类是继承 ArrayList
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
            // 3.1:获取第一个name的element对象
        Element element = elements.get(0);
            // 3.2获取数据
        String name = element.text();
        System.out.println(name);
    }
}
