package javaelasticdata;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;

public class javaelasticclient {

	public static void main(String[] args) throws IOException {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http")));
		
		CreateIndexRequest request = new CreateIndexRequest("sampleindex");
        request.settings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 2));
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("response id: " + createIndexResponse.index());
		
		

	}

}
