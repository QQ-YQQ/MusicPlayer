package xx;


import javafx.scene.image.Image;
import org.junit.Test;

import java.net.URL;


public class yyTest {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void testFilePath() {
       /*
        Image image = new Image("xx/file/1.png");
        System.out.println(image);
        */
        // 使用类加载器获取资源
        URL resourceUrl = getClass().getClassLoader().getResource("xx/file/1.png");

        if (resourceUrl != null) {
            System.out.println("找到资源: " + resourceUrl.getPath());
            // 使用资源URL创建Image对象
            Image image = new Image(resourceUrl.toString());
            System.out.println(image);
        } else {
            System.out.println("未找到资源: xx/file/1.png");
        }

    }
}
