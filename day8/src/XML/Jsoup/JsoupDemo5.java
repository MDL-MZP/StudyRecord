package XML.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        // 1.获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        // 2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 3.查询name标签, 这。。下面这啥区别啊: 选择器能处理更复杂的情况？
        /*
            div{

            }
        */
        Elements elements1 = document.getElementsByTag("name");
        Elements elements = document.select("name");
        System.out.println(elements1);
        System.out.println("---------------");
        System.out.println(elements);

        System.out.println("--------分割--------");
        // 4.查询id值为MZP的元素
        Elements select = document.select("#MZP");
        System.out.println(select);
        System.out.println("----------------");
        Element mzp = document.getElementById("MZP");
        System.out.println(mzp);

        System.out.println("--------分割--------");
        // 5.获取student标签并且number属性值为heima_0001的age子标签
            //5.1 获取student标签并且number属性值为heima_0001
        Elements select1 = document.select("student[number='heima_0001']");
        System.out.println(select1);
            //5.2
        System.out.println("----------------");
        Elements select2 = document.select("student[number='heima_0001'] > age");
        System.out.println(select2);

    }
}
