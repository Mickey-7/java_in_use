package com.example.configurationproperties.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private String description;
    private String uploadsDir;
    private Duration connectTimeout = Duration.ofMillis(1000);
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration readTimeout = Duration.ofSeconds(30);

    private final Security security = new Security();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadsDir() {
        return uploadsDir;
    }

    public void setUploadsDir(String uploadsDir) {
        this.uploadsDir = uploadsDir;
    }

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Security getSecurity() {
        return security;
    }

    public static  class Security{
        private String username;
        private String password;

        private List<String> roles = new ArrayList<>();
        private boolean enabled;
        private Map<String, String> permissions = new HashMap<>();

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public Map<String, String> getPermissions() {
            return permissions;
        }

        public void setPermissions(Map<String, String> permissions) {
            this.permissions = permissions;
        }
    }
}
