package ru.todayismay.UrlShortener.repositories;

import ru.todayismay.UrlShortener.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
}
