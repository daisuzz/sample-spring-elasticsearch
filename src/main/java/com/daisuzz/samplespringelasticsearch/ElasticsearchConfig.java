package com.daisuzz.samplespringelasticsearch;

import co.elastic.clients.base.RestClientTransport;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    /**
     * {@link org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientConfigurations}
     * で設定されるRestClientBuilderを使ってElasticsearchClientのBeanを生成する。
     * 認証情報や接続先情報は {@link org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties} を利用する。
     */
    @Bean
    public ElasticsearchClient elasticsearchClient(RestClientBuilder builder) {

        RestClient restClient = builder.build();

        Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
