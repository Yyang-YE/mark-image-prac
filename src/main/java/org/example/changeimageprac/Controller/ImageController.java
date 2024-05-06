package org.example.changeimageprac.Controller;

import org.example.changeimageprac.ImageFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
class ImageController {

    @GetMapping("/showImage")
    public String showImage(Model model) {
        // 이미지 파일의 경로
        String image = "babyneung_1f.png";

        // 모델에 이미지 경로 추가
        model.addAttribute("image", image);

        return "image-page";
    }

    @GetMapping("/showImage/result")
    public String showResultImage(Model model) throws IOException, InterruptedException {
        String newImg = ImageFilter.getRoute();
        System.out.println("지금이름: " + newImg);
        model.addAttribute("newImg", newImg);

        return "result-page";
    }

}