package com.daisuzz.samplespringelasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import co.elastic.clients.elasticsearch._core.search.Hit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("elasticsearch")
public class SampleElasticsearchController {

    private final ElasticsearchClient elasticsearchClient;

    public SampleElasticsearchController(final ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @GetMapping("books")
    public List<Book> searchBooks(@RequestParam("query") String query) {
        try {
            SearchResponse<Book> search = elasticsearchClient.search(s -> s
                            .index("books")
                            .query(q -> q.match(m -> m
                                    .field("title")
                                    .query(query)
                            ))
                    , Book.class);

            return search.hits().hits().stream()
                    .map(Hit::source)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("検索処理で例外が発生しました。");
        }
    }
}
