package br.com.stocking.entities.company;

public enum CompanySize {
    SMALL("1-10 Colaboladores"),
    MEDIUM("11-20 Colaboradores"),
    LARGE("21+ Colaboradores");

    private final String displayName;

    CompanySize(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
