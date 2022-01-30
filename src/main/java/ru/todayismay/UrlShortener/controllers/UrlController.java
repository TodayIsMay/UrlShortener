package ru.todayismay.UrlShortener.controllers;

import ru.todayismay.UrlShortener.repositories.UrlRepository;
import ru.todayismay.UrlShortener.dto.UrlLongRequest;
import ru.todayismay.UrlShortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private UrlService urlService;

    @PostMapping("/short")
    public String convertToShortUrl(@RequestBody UrlLongRequest request) {
        return urlService.convertToShortUrl(request);
    }

    @GetMapping("{shortUrl}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        var url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @DeleteMapping("{shortUrl}")
    public void delete(@PathVariable String shortUrl) {
        long id = urlService.decode(shortUrl);
        urlRepository.deleteById(id);
    }
}
