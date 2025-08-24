package cn.localioutils;


import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class ImageUtils {

    // 将 BufferedImage 转换为 WritableImage
    public static WritableImage bufferedImageToWritableImage(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        // 创建 WritableImage 对象
        WritableImage writableImage = new WritableImage(width, height);

        // 获取 PixelWriter 用于写入像素
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        // 遍历 BufferedImage 中的每个像素
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // 获取像素值
                int rgb = bufferedImage.getRGB(x, y);

                // 将 RGB 转换为 javafx.scene.paint.Color
                Color color = Color.rgb(
                        (rgb >> 16) & 0xFF, // Red
                        (rgb >> 8) & 0xFF,  // Green
                        rgb & 0xFF,         // Blue
                        ((rgb >> 24) & 0xFF) / 255.0 // Alpha
                );

                // 设置像素
                pixelWriter.setColor(x, y, color);
            }
        }

        return writableImage;
    }
}
