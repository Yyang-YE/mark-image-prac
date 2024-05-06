package org.example.changeimageprac;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ImageFilter {
    public static String getRoute() throws IOException {
        //임시적으로 절대경로 사용했습니다
        String imagePath = "C:\\Users\\samsung\\OneDrive\\바탕 화면\\c-back\\change-image-prac\\build\\resources\\main\\static\\image\\babyneung_1f.png";

        // 이미지 로드
        BufferedImage image = ImageIO.read(new File(imagePath));

        // 시작점과 끝점 좌표
        ArrayList<Point> startPoints = new ArrayList<Point>();
        startPoints.add(new Point(100, 100));
        startPoints.add(new Point(300, 100));
        startPoints.add(new Point(300, 300));
        startPoints.add(new Point(100, 300));

        ArrayList<Point> endPoint = new ArrayList<Point>();
        endPoint.add(new Point(300, 100));
        endPoint.add(new Point(300, 300));
        endPoint.add(new Point(100, 300));
        endPoint.add(new Point(100, 100));

        // 이미지에 선 그리기
        for (int i = 0; i < startPoints.size(); i++) {
            drawLine(image, startPoints.get(i), endPoint.get(i));
        }

        // 무작위 파일명 생성
        String randomFileName = UUID.randomUUID().toString() + ".png";
        System.out.println(randomFileName);

        // 이미지 저장 시 IOException 처리
        try {
            ImageIO.write(image, "png", new File("src/main/resources/static/results/" + randomFileName));

        } catch (IOException e) {
            System.err.println("이미지 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
            throw e;
        }

        return randomFileName;
    }

    // 이미지에 선 그리기
    private static void drawLine(BufferedImage image, Point startPoint, Point endPoint) {
        Graphics2D g2d = image.createGraphics();

        // 선 그리기
        g2d.setColor(Color.RED); // 선 색상 설정
        g2d.setStroke(new BasicStroke(3)); // 선 굵기 설정
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

        g2d.dispose();
    }
}
