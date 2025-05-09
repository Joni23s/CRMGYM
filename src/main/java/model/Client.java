package model;

import java.util.Objects;

/**
 * Representa un cliente en el sistema. / Represents a client in the system.
 * Esta clase contiene información personal del cliente, como su DNI, nombre, apellido, email, número de teléfono y estado (activo/inactivo). |
 * This class contains personal information about the client, such as their ID, name, last name, email, phone number, and status (active/inactive).
 */
public class Client {
    private int documentId;
    private String name;
    private String lastName;
    private String email;
    private long phoneNumber;
    private boolean isActive;

    public Client() { this.isActive = true; }

    public Client(int documentId) {
        this.documentId = documentId;
        this.isActive = true;
    }

    // Constructor que inicializa todos los campos excepto el estado, que se establece como activo por defecto.
    // Constructor that initializes all fields except status, which is set to active by default.
    public Client(int documentId, String name, String lastName, String email, long phoneNumber) {
        this.documentId = documentId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = true;
    }

    // Constructor que inicializa todos los campos del cliente, incluido el estado.
    // Constructor that initializes all client fields, including status.
    public Client(int documentId, String name, String lastName, String email, long phoneNumber, boolean isActive) {
        this.documentId = documentId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Devuelve una representación en formato tabla de los datos del cliente.
     * Returns a table-formatted representation of the client's data.
     * @return Una cadena formateada con los datos del cliente. / A formatted string with the client's data.
     */
    @Override
    public String toString() {
        return String.format("""
            ┌────────────────────────────────────────────┐
            │               Datos del Cliente            │
            ├────────────────────────────────────────────┤
            │ DNI:        %-30d │
            │ Nombre:     %-30s │
            │ Apellido:   %-30s │
            │ Email:      %-30s │
            │ Celular:    %-30d │
            │ Estado:     %-30s │
            └────────────────────────────────────────────┘
            """,
                documentId, name, lastName, email, phoneNumber, isActive ? "Activo" : "Inactivo"
        );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return documentId == client.documentId &&
                phoneNumber == client.phoneNumber &&
                isActive == client.isActive &&
                Objects.equals(name, client.name) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, name, lastName, email, phoneNumber, isActive);
    }
}
