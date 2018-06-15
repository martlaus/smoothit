package it.smooth.smoothie.controller;

import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.service.SmoothieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/smoothies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class SmoothieController {

    private final SmoothieService smoothieService;

    @GetMapping
    @CrossOrigin
    public Iterable<Smoothie> findAll(
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return smoothieService.findAll(pageable);
    }

    @PostMapping
    @CrossOrigin
    public Smoothie create(
            @RequestBody Smoothie smoothie) {
        return smoothieService.create(smoothie);
    }

    @PostMapping(value = "/{id}/file")
    @CrossOrigin
    public Smoothie addFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Smoothie> smoothieOp = smoothieService.findById(id);
        if (smoothieOp.isPresent()) {
            try {
                Smoothie smoothie = smoothieOp.get();
                smoothie.setFile(file.getBytes());
                return smoothieService.create(smoothie);
            } catch (IOException ignored) {
                System.out.println(ignored.getMessage());
            }
        }
        return null;
    }
}
