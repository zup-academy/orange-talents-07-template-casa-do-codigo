package com.github.zlbovolini.casacodigo.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private final String name;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String description;

    private final LocalDateTime createdAt = LocalDateTime.now();

    public Author(@NotBlank String name,
                  @NotBlank String email,
                  @NotBlank @Size(max = 400) String description) {

        List<String> parameters = Arrays.asList(name, email, description);
        boolean hasInconsistency = parameters.stream()
                .anyMatch(parameter -> Objects.isNull(parameter) || parameter.isBlank());

        if (hasInconsistency) {
            throw new IllegalArgumentException("There is some invalid value");
        }

        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author(Long id,
                  @NotBlank String name,
                  @NotBlank String email,
                  @NotBlank @Size(max = 400) String description) {
        this(name, email, description);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
