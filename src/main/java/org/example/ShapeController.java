package org.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {
    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping
    public List<Shape> getAllShapes() {
        return shapeService.getAllShapes();
    }

    @PostMapping("/rectangle")
    public Rectangle createRectangle(@RequestBody Rectangle rectangle) {
        return (Rectangle) shapeService.saveShape(rectangle);
    }

    @PostMapping("/triangle")
    public Triangle createTriangle(@RequestBody Triangle triangle) {
        return (Triangle) shapeService.saveShape(triangle);
    }
}
