package br.com.stocking.entities.role;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Authority;

    public Role() {}

    public Role(Long id, String authority) {
        this.id = id;
        Authority = authority;
    }

    public Long getId() {
        return id;
    }

    public String getAuthority() {
        return Authority;
    }
}
