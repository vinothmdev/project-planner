package dev.vinothm.planner.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountProfileTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getUri(int port) {
        return "http://localhost:" + port + "/api/v1/account/profile";
    }

    @Test
    public void shouldGetProfile() throws Exception {
        assertThat(this.restTemplate.getForObject(getUri(port), String.class)).contains("Profile receive");
    }

    @Test
    public void shouldPutProfile() throws Exception {
        ResponseEntity<String> response = this.restTemplate
                .exchange(new RequestEntity<String>(HttpMethod.PUT, new URI(getUri(port))), String.class);
        assertThat(response.getBody()).isEqualTo("Profile update");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void shouldDeleteProfile() throws Exception {
        ResponseEntity<String> response = this.restTemplate
                .exchange(new RequestEntity<String>(HttpMethod.DELETE, new URI(getUri(port))), String.class);
        assertThat(response.getBody()).isEqualTo("Profile Delete");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void shouldCreateProfile() throws Exception {
        ResponseEntity<String> response = this.restTemplate
                .exchange(new RequestEntity<String>(HttpMethod.POST, new URI(getUri(port))), String.class);
        assertThat(response.getBody()).isEqualTo("Profile Create");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
